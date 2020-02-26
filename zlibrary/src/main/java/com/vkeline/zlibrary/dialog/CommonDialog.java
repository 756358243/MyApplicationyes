package com.vkeline.zlibrary.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vkeline.zlibrary.R;
import com.vkeline.zlibrary.util.DensityUtils;


public class CommonDialog extends Dialog {

    // Content View Elements
    private LinearLayout mDialog_common_ll;
    private TextView mDialog_common_tv_title;
    private View mDialog_common_tv_title_view;
    private ImageView mDialog_common_iv;
    private TextView mDialog_common_tv;
    private TextView mDialog_common_tv_left;
    private TextView mDialog_common_tv_right;
    private LinearLayout mDialog_common_tv_ll;
    private TextView mDialog_common_tv_single;
    // End Of Content View Elements
    private Activity context;
    //默认点击外面关闭
    private boolean isClose = true;

    public CommonDialog(Activity context) {
        super(context, R.style.ShadowDialog);
        this.context = context;
    }

    private void bindViews() {

        mDialog_common_ll = (LinearLayout) findViewById(R.id.dialog_common_ll);
        mDialog_common_tv_title = (TextView) findViewById(R.id.dialog_common_tv_title);
        mDialog_common_tv_title_view = findViewById(R.id.dialog_common_tv_title_view);
        mDialog_common_iv = (ImageView) findViewById(R.id.dialog_common_iv);
        mDialog_common_tv = (TextView) findViewById(R.id.dialog_common_tv);
        mDialog_common_tv_left = (TextView) findViewById(R.id.dialog_common_tv_left);
        mDialog_common_tv_right = (TextView) findViewById(R.id.dialog_common_tv_right);
        mDialog_common_tv_single = (TextView) findViewById(R.id.dialog_common_tv_single);
        mDialog_common_tv_ll = (LinearLayout) findViewById(R.id.dialog_common_tv_ll);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_common);
        Window window = getWindow();
        int screenHeight = DensityUtils.getScreenHeight(context);
        int statusBarHeight = DensityUtils.getStatusHeight(context);
        int dialogHeight = screenHeight - statusBarHeight;
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);
        window.setWindowAnimations(R.style.dialogAlpha);

        bindViews();
        initEvents();
    }


    /**
     * 设置点击外面是否关闭
     *
     * @param flag
     * @return
     */
    public CommonDialog setClose(Boolean flag) {
        this.isClose = flag;
        return this;
    }

    public CommonDialog setCancel(Boolean flag) {
        setCancelable(flag);
        return this;
    }

    private void initEvents() {

        mDialog_common_tv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callBack != null) {
                    callBack.left();
                }
                setDisplay(false);
            }
        });

        mDialog_common_tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callBack != null) {
                    callBack.right();
                }
                setDisplay(false);
            }
        });

        mDialog_common_tv_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (singleCallBack != null) {
                    singleCallBack.click();
                }
                setDisplay(false);
            }
        });

        /**
         * 点击外面取消
         */
        mDialog_common_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isClose) {
                    setDisplay(false);
                }
            }
        });


    }


    /**
     * 获取标题
     *
     * @return
     */
    public TextView getTitle() {
        return mDialog_common_tv_title;
    }

    /**
     * 设置标题
     *
     * @param text
     * @return
     */
    public CommonDialog setTitle(String text) {
        this.mDialog_common_tv_title.setVisibility(View.VISIBLE);
        this.mDialog_common_tv_title_view.setVisibility(View.VISIBLE);
        this.mDialog_common_tv_title.setText(text);
        return this;
    }


    /**
     * 设置图标
     *
     * @param res
     * @return
     */
    public CommonDialog setIcon(int res) {
        this.mDialog_common_iv.setVisibility(View.VISIBLE);
        this.mDialog_common_iv.setImageResource(res);
        return this;
    }

    /**
     * 获取内容
     *
     * @return
     */
    public TextView getTv() {
        return mDialog_common_tv;
    }

    /**
     * 设置内容
     *
     * @param text
     * @return
     */
    public CommonDialog setTv(String text) {
        this.mDialog_common_tv.setText(text);
        return this;
    }

    /**
     * 获取左侧文字控件
     *
     * @return
     */
    public TextView getLeft() {
        return mDialog_common_tv_left;
    }

    /**
     * 设置左侧文字
     *
     * @param text
     * @return
     */
    public CommonDialog setLeft(String text) {
        this.mDialog_common_tv_left.setText(text);
        return this;
    }

    /**
     * 获取右边控件
     *
     * @return
     */
    public TextView getRight() {
        return mDialog_common_tv_right;
    }

    /**
     * 设置右边文字
     *
     * @param text
     * @return
     */
    public CommonDialog setRight(String text) {
        this.mDialog_common_tv_right.setText(text);
        return this;
    }

    /**
     * 获取单行控件
     *
     * @return
     */
    public TextView getSingle() {
        return mDialog_common_tv_single;
    }

    /**
     * 设置单行文字
     */
    public CommonDialog setSingle(String text) {
        this.mDialog_common_tv_ll.setVisibility(View.GONE);
        this.mDialog_common_tv_single.setVisibility(View.VISIBLE);
        this.mDialog_common_tv_single.setText(text);
        return this;
    }

    /**
     * 两个按钮时回调
     */
    private CallBack callBack;

    public CommonDialog setCallBack(CallBack callBack) {
        this.callBack = callBack;
        return this;
    }

    public interface CallBack {
        void left();

        void right();
    }

    /**
     * 单个按钮回调
     */
    private SingleCallBack singleCallBack;

    public CommonDialog setSingleCallBack(SingleCallBack singleCallBack) {
        this.singleCallBack = singleCallBack;
        return this;
    }

    public interface SingleCallBack {
        void click();
    }


    /**
     * 设置显示
     *
     * @param flag
     * @return
     */
    public CommonDialog setDisplay(boolean flag) {
        if (flag) {
            show();
        } else {
            if (isShowing()) {
                dismiss();
            }
        }
        return this;
    }


    /**
     * @param activity
     * @param message
     * @return
     */
    public static CommonDialog disPlay(Activity activity, String message) {

        String left = "取消";
        String right = "确认";

        return new CommonDialog(activity).setDisplay(true).setTv(message).setLeft(left).setRight(right);

    }


    /**
     * 不带图标
     *
     * @param activity
     * @param message
     * @param left
     * @param right
     * @return 调用在执行setCallBack
     */
    public static CommonDialog disPlay(Activity activity, String message, String left, String right) {

        return new CommonDialog(activity).setDisplay(true).setTv(message).setLeft(left).setRight(right);

    }

    /**
     * 带图标
     *
     * @param activity
     * @param res
     * @param message
     * @param left
     * @param right
     * @return 调用在执行setCallBack
     */
    public static CommonDialog disPlay(Activity activity, int res, String message, String left, String right) {

        return new CommonDialog(activity).setDisplay(true).setIcon(res).setTv(message).setLeft(left).setRight(right);

    }


    /**
     * 不带图标
     *
     * @param activity
     * @param message
     * @param click
     * @return 执行SingleCallBack
     */
    public static CommonDialog disPlay(Activity activity, String message, String click) {

        return new CommonDialog(activity).setDisplay(true).setTv(message).setSingle(click);

    }


    /**
     * 带图标
     *
     * @param activity
     * @param res
     * @param message
     * @param click
     * @return 执行SingleCallBack
     */
    public static CommonDialog disPlay(Activity activity, int res, String message, String click) {

        return new CommonDialog(activity).setDisplay(true).setIcon(res).setTv(message).setSingle(click);

    }

}
