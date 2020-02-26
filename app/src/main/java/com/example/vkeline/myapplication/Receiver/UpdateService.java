package com.example.vkeline.myapplication.Receiver;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.RemoteViews;
import com.example.vkeline.myapplication.R;
import com.example.vkeline.myapplication.Utils.FileSizeUtil;
import com.example.vkeline.myapplication.data.UpdateInformation;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;

public class UpdateService extends Service {
    // BT字节参考量
    private static final float SIZE_BT = 1024L;
    // KB字节参考量
    private static final float SIZE_KB = SIZE_BT * 1024.0f;
    // MB字节参考量
    private static final float SIZE_MB = SIZE_KB * 1024.0f;

    private final static int DOWNLOAD_COMPLETE = 1;// 完成
    private final static int DOWNLOAD_NOMEMORY = -1;// 内存异常
    private final static int DOWNLOAD_FAIL = -2;// 失败

    private String appName = null;// 应用名字
    private String appUrl = null;// 应用升级地址
    private File updateDir = null;// 文件目录
    private File updateFile = null;// 升级文件

    // 通知栏
    private NotificationManager updateNotificationManager = null;
    private Notification.Builder mBuilder;
    private Notification updateNotification = null;

    private Intent updateIntent = null;// 下载完成
    private PendingIntent updatePendingIntent = null;// 在下载的时候

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }



    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        appName = intent.getStringExtra("appname");
        appUrl = intent.getStringExtra("appurl");
        String channelId = "asgdown";
        String channelName = "爱算卦下载";
        int importance = NotificationManager.IMPORTANCE_LOW;
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //createNotificationChannel(channelId, channelName, importance);
            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            notificationManager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(this)
                    .setChannelId(channelId)
                    .setContentTitle("活动")
                    .setContentText("您有一项新活动")
                    .setSmallIcon(R.mipmap.ziweidoushu).build();
            notificationManager.notify(1, notification);

        }else {
            Notification notification = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ziweidoushu)
                    .setContentTitle("收到一条聊天消息")
                    .setContentText("今天中午吃什么？")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ziweidoushu)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ziweidoushu))
                    .setAutoCancel(true)
                    .build();
            notificationManager.notify(1, notification);
        }*/




        updateNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        mBuilder = new Notification.Builder(this);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            updateNotificationManager.createNotificationChannel(channel);

        }
        mBuilder.setChannelId(channelId);
        //通知图标
        mBuilder.setSmallIcon(R.mipmap.ziweidoushu);
        //通知信息描述
        mBuilder.setContentTitle("正在下载爱算卦");
        //mBuilder.setShowWhen(true);
        //mBuilder.setWhen(System.currentTimeMillis());

        updateIntent = new Intent(this, UpdateService.class);
        updatePendingIntent = PendingIntent.getActivity(this, 0, updateIntent,
                0);
        mBuilder.setContentIntent(updatePendingIntent);
       // mBuilder.setAutoCancel(true);
        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.download_notification);
        // 如果是动态设置值的时候，需要这些操作
        contentView
                .setImageViewResource(R.id.img_user, R.mipmap.ziweidoushu);
        contentView.setTextViewText(R.id.download_notice_speed_tv, " 正在下载:0MB (0%)");
        contentView.setProgressBar(R.id.progressBar, 100, 0, false);

        mBuilder.setContent(contentView);
        //updateNotification.icon = R.mipmap.ziweidoushu;
        //通知信息描述
        //updateNotification.tickerText = "正在下载 " + appName;
        //updateNotification.when = System.currentTimeMillis();

        //updateNotification.contentIntent = updatePendingIntent;
        //updateNotification.contentIntent.cancel();
       // updateNotification.contentView = new RemoteViews(getPackageName(),
                //这个布局很简单，就是一个图片和两个textview，分别是正在下载和下载进度
            //    R.layout.download_notification);
        //updateNotification.contentView.setTextViewText(
        //        R.id.download_notice_name_tv, appName + " 正在下载");
        //updateNotification.contentView.setTextViewText(
           //     R.id.download_notice_speed_tv, "0MB (0%)");
        updateNotification = mBuilder.build();
        updateNotificationManager.notify(0, updateNotification);
        new UpdateThread().execute();
    }

    /**
     * 在这里使用了asynctask异步任务来下载
     */
    class UpdateThread extends AsyncTask<Void, Void, Integer> {
        @Override
        protected Integer doInBackground(Void... params) {
            return downloadUpdateFile(appUrl);
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);

            if (result == DOWNLOAD_COMPLETE) {
                Log.d("update", "下载成功");
                String cmd = "chmod 777 " + updateFile.getPath();
                try {
                    Runtime.getRuntime().exec(cmd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Uri uri = Uri.fromFile(updateFile);
                Uri uri =  FileProvider.getUriForFile(UpdateService.this, "com.example.vkeline.myapplication.fileprovider", updateFile);

                //安装程序
                Intent installIntent = new Intent(Intent.ACTION_VIEW);
                installIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                installIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);//检测是否允许未知来源
                installIntent.setDataAndType(uri,
                        "application/vnd.android.package-archive");
                updatePendingIntent = PendingIntent.getActivity(
                        UpdateService.this, 0, installIntent, 0);
                updateNotification.contentIntent = updatePendingIntent;
                updateNotification.contentView.setTextViewText(
                        R.id.download_notice_speed_tv,
                        getString(R.string.update_notice_finish));
                updateNotification.tickerText = appName + "下载完成";
                updateNotification.when = System.currentTimeMillis();
                updateNotification.defaults = Notification.DEFAULT_SOUND;
                updateNotification.flags |= Notification.FLAG_AUTO_CANCEL;
                updateNotificationManager.notify(0, updateNotification);
                //启动安装程序
                installIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                UpdateService.this.startActivity(installIntent);
                stopSelf();
            } else if (result == DOWNLOAD_NOMEMORY) {
                //如果内存有问题
                updateNotification.tickerText = appName + "下载失败";
                updateNotification.when = System.currentTimeMillis();
                updateNotification.contentView.setTextViewText(
                        R.id.download_notice_speed_tv,
                        getString(R.string.update_notice_nomemory));
                updateNotification.flags |= Notification.FLAG_AUTO_CANCEL;
                updateNotification.defaults = Notification.DEFAULT_SOUND;
                updateNotificationManager.notify(0, updateNotification);
                stopSelf();
            } else if (result == DOWNLOAD_FAIL) {
                //下载失败
                updateNotification.tickerText = appName + "下载失败";
                updateNotification.when = System.currentTimeMillis();
                updateNotification.contentView.setTextViewText(
                        R.id.download_notice_speed_tv,
                        getString(R.string.update_notice_error));
                updateNotification.flags |= Notification.FLAG_AUTO_CANCEL;
                updateNotification.defaults = Notification.DEFAULT_SOUND;
                updateNotificationManager.notify(0, updateNotification);
                stopSelf();
            }
        }

    }

    /**
     * 下载更新程序文件
     * @param downloadUrl   下载地址
     * @return
     */
    private int downloadUpdateFile(String downloadUrl) {
        int count = 0;
        long totalSize = 0;   //总大小
        long downloadSize = 0;   //下载的大小
        URI uri = null;

        //这个已经舍弃了，要用的话，就要加上org.apache.http.legacy.jar这个jar包
        HttpGet httpGet = null;
        try {
            uri = new URI(downloadUrl);
            httpGet = new HttpGet(uri);
        } catch (URISyntaxException e) {
            String encodedUrl = downloadUrl.replace(' ', '+');
            httpGet = new HttpGet(encodedUrl);
            e.printStackTrace();
        }
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = null;
        FileOutputStream fos = null;
        InputStream is = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            if (httpResponse != null) {
                int stateCode = httpResponse.getStatusLine().getStatusCode();
                if (stateCode == HttpStatus.SC_OK) {
                    HttpEntity entity = httpResponse.getEntity();
                    if (entity != null) {
                        totalSize = entity.getContentLength();
                        //如果内存可用
                        if (MemoryAvailable(totalSize)) {
                            is = entity.getContent();
                            if (is != null) {
                                fos = new FileOutputStream(updateFile, false);
                                byte buffer[] = new byte[4096];
                                int readsize = 0;
                                //int b = (new Long((downloadSize/totalSize)*100)).intValue();

                                while ((readsize = is.read(buffer)) > 0) {
                                    fos.write(buffer, 0, readsize);
                                    downloadSize += readsize;
                                    if ((count == 0)
                                            || (int) (downloadSize * 100 / totalSize) >= count) {
                                        count += 5;
                                        updateNotification.contentView
                                                .setTextViewText(
                                                        R.id.download_notice_speed_tv,
                                                        getMsgSpeed(downloadSize,totalSize));
                                        //progressBar
                                         updateNotification.contentView.setProgressBar(R.id.progressBar,new Long(totalSize).intValue(),new Long(downloadSize).intValue(), false);
                                        updateNotificationManager.notify(0,
                                                updateNotification);
                                    }
                                }
                                fos.flush();
                                if (totalSize >= downloadSize) {
                                    return DOWNLOAD_COMPLETE;
                                } else {
                                    return DOWNLOAD_FAIL;
                                }
                            }
                        } else {
                            if (httpGet != null) {
                                httpGet.abort();
                            }
                            return DOWNLOAD_NOMEMORY;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return DOWNLOAD_FAIL;
    }

    /**
     * 可用内存大小
     * @param fileSize
     * @return
     */
    private boolean MemoryAvailable(long fileSize) {
        fileSize += (1024 << 10);
        if (FileSizeUtil.externalMemoryAvailable()) {
            if ((FileSizeUtil.getAvailableExternalMemorySize() <= fileSize)) {
                if ((FileSizeUtil.getAvailableInternalMemorySize() > fileSize)) {
                    createFile(false);
                    return true;
                } else {
                    return false;
                }
            } else {
                createFile(true);
                return true;
            }
        } else {
            if (FileSizeUtil.getAvailableInternalMemorySize() <= fileSize) {
                return false;
            } else {
                createFile(false);
                return true;
            }
        }
    }

    /**
     * 获取下载进度
     * @param downSize
     * @param allSize
     * @return
     */
    public static String getMsgSpeed(long downSize, long allSize) {
        StringBuffer sBuf = new StringBuffer();
        sBuf.append(getSize(downSize));
        sBuf.append("/");
        sBuf.append(getSize(allSize));
        sBuf.append(" ");
        sBuf.append(getPercentSize(downSize, allSize));
        return sBuf.toString();
    }

    /**
     * 获取大小
     * @param size
     * @return
     */
    public static String getSize(long size) {
        if (size >= 0 && size < SIZE_BT) {
            return (double) (Math.round(size * 10) / 10.0) + "B";
        } else if (size >= SIZE_BT && size < SIZE_KB) {
            return (double) (Math.round((size / SIZE_BT) * 10) / 10.0) + "KB";
        } else if (size >= SIZE_KB && size < SIZE_MB) {
            return (double) (Math.round((size / SIZE_KB) * 10) / 10.0) + "MB";
        }
        return "";
    }

    /**
     * 获取到当前的下载百分比
     * @param downSize   下载大小
     * @param allSize    总共大小
     * @return
     */
    public static String getPercentSize(long downSize, long allSize) {
        String percent = (allSize == 0 ? "0.0" : new DecimalFormat("0.0")
                .format((double) downSize / (double) allSize * 100));
        return "(" + percent + "%)";
    }


    /**
     * 创建file文件
     * @param sd_available    sdcard是否可用
     */
    private void createFile(boolean sd_available) {
        if (sd_available) {
            updateDir = new File(Environment.getExternalStorageDirectory(),
                    UpdateInformation.downloadDir);
        } else {
            updateDir = getFilesDir();
        }
        updateFile = new File(updateDir.getPath(), appName + ".apk");
        if (!updateDir.exists()) {
            updateDir.mkdirs();
        }
        if (!updateFile.exists()) {
            try {
                updateFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            updateFile.delete();
            try {
                updateFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
