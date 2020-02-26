package com.vkeline.zlibrary.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.vkeline.zlibrary.R;
import com.vkeline.zlibrary.adapter.CommonListViewAdapter;

import java.util.List;

/**
 * @author Zhou
 *         Created on 2017/12/12 8:41.
 *         Email:qishuichixi@163.com
 *         Desc:
 */

public class ListDialog extends AlertDialog {

    // Content View Elements

    private ListView mLv_dialog_upload;
    private Activity activity;
    private List mDatas;
    private LinearLayout lv_dialog_ll;
    private TextView tv_dialog_upload ;

    // End Of Content View Elements

    private void bindViews() {

        mLv_dialog_upload = (ListView) findViewById(R.id.lv_dialog_upload);
        lv_dialog_ll = (LinearLayout) findViewById(R.id.lv_dialog_ll);
        tv_dialog_upload= (TextView) findViewById(R.id.tv_dialog_upload);
    }


    public ListDialog(Activity activity, List mDatas) {
        super(activity, R.style.ShadowDialog);
        this.activity = activity;
        this.mDatas = mDatas;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_list);
        Window window = getWindow();

        int screenHeight = getScreenHeight(activity);
        int statusBarHeight = getStatusBarHeight(activity);
        int dialogHeight = screenHeight - statusBarHeight;
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);
        window.setWindowAnimations(R.style.dialogAlpha);

        setCanceledOnTouchOutside(true);

        bindViews();
        initEvents();
    }

    /**
     * 设置点击事件
     */
    private void initEvents() {

        lv_dialog_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setDisplay(false);
            }
        });

        if(mDatas==null){
            mLv_dialog_upload.setVisibility(View.INVISIBLE);
            tv_dialog_upload.setVisibility(View.VISIBLE);
            tv_dialog_upload.setText("暂无网络!");
            return;
        }
        if(mDatas.size()==0){
            mLv_dialog_upload.setVisibility(View.INVISIBLE);
            tv_dialog_upload.setVisibility(View.VISIBLE);
            tv_dialog_upload.setText("暂无数据!");
            return;
        }
        mLv_dialog_upload.setVisibility(View.VISIBLE);
        mLv_dialog_upload.setAdapter(new CommonListViewAdapter<String>(activity, mDatas, R.layout.dialog_list_item) {

            @Override
            public void setData(CommonListViewAdapter.BaseHolder holder, final String item, int position) {

                holder.setText(R.id.dialog_upload_item_tv, item);
                holder.getView(R.id.dialog_upload_item_lv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        setDisplay(false);
                        if (listener != null) {
                            listener.onItemClick(item);
                        }
                    }
                });
            }


        });




    }

    public LinearLayout getLv_dialog_ll() {
        return lv_dialog_ll;
    }

    //禁止回退键
    public ListDialog setCancel(Boolean flag) {
        setCancelable(flag);
        return this;
    }


    public ListDialog setDisplay(boolean flag) {
        if (flag) {
            show();
        } else {
            if (isShowing()) {
                dismiss();
            }
        }
        return this;
    }


    private CallBackListener listener;

    public ListDialog setListener(CallBackListener listener) {
        this.listener = listener;
        return this;
    }

    public interface CallBackListener {

        void onItemClick(String item);
    }


    //获取屏幕的高度
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }

    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }


}

