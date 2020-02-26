package com.vkeline.zlibrary.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vkeline.zlibrary.R;
import com.vkeline.zlibrary.util.AutoSizeUtils;

/**
 * Created by Administrator on 2017/12/26.
 */
public class HeadLayoutView extends RelativeLayout {

    // Content View Elements
    private RelativeLayout mHead_rl;
    private ImageView mHead_left_iv;
    private TextView mHead_left_tv;
    private ImageView mHead_middle_iv;
    private TextView mHead_middle_tv;
    private TextView mHead_right_tv;
    private ImageView mHead_right_iv;

    // End Of Content View Elements

    private void bindViews() {

        mHead_rl = (RelativeLayout) findViewById(R.id.head_rl);
        mHead_left_iv = (ImageView) findViewById(R.id.head_left_iv);
        mHead_left_tv = (TextView) findViewById(R.id.head_left_tv);
        mHead_middle_iv = (ImageView) findViewById(R.id.head_middle_iv);
        mHead_middle_tv = (TextView) findViewById(R.id.head_middle_tv);
        mHead_right_tv = (TextView) findViewById(R.id.head_right_tv);
        mHead_right_iv = (ImageView) findViewById(R.id.head_right_iv);
    }


    public HeadLayoutView(Context context) {
        this(context, null);
    }

    public HeadLayoutView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeadLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initEvent(context, attrs);
    }

    /**
     * 初始化标题布局
     */
    private void initEvent(Context context, AttributeSet attrs) {

        View view = LayoutInflater.from(context).inflate(R.layout.view_headlayout, this, true);
        AutoSizeUtils.auto(view);
        bindViews();

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.HeadLayoutView);
        //在xml中获取设置
        if (attributes != null) {

            //左边文字
            String leftText = attributes.getString(R.styleable.HeadLayoutView_left_text);
            if (!TextUtils.isEmpty(leftText)) {
                mHead_left_tv.setText(leftText);
            }
            int leftres = attributes.getInt(R.styleable.HeadLayoutView_left_res, 0);
            if (leftres != 0) {
                mHead_left_iv.setImageResource(leftres);
            }

            //中间文字
            String text = attributes.getString(R.styleable.HeadLayoutView_middle_text);
            if (!TextUtils.isEmpty(text)) {
                mHead_middle_iv.setVisibility(View.INVISIBLE);
                mHead_middle_tv.setVisibility(View.VISIBLE);
                mHead_middle_tv.setText(text);
            }
            int middleres = attributes.getInt(R.styleable.HeadLayoutView_middle_res, 0);
            if (middleres != 0) {
                mHead_middle_tv.setVisibility(View.INVISIBLE);
                mHead_middle_iv.setImageResource(middleres);
            }

            //右边文字
            String righttext = attributes.getString(R.styleable.HeadLayoutView_right_text);
            if (!TextUtils.isEmpty(righttext)) {
                mHead_right_iv.setVisibility(View.INVISIBLE);
                mHead_right_tv.setVisibility(View.VISIBLE);
                mHead_right_tv.setText(righttext);
            }
            int rightres = attributes.getInt(R.styleable.HeadLayoutView_right_res, 0);
            if (rightres != 0) {
                mHead_right_tv.setVisibility(View.INVISIBLE);
                mHead_right_iv.setVisibility(View.VISIBLE);
                mHead_right_iv.setImageResource(middleres);
            }

        }
        attributes.recycle();

        mHead_left_iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callBack != null) {
                    callBack.clickLeft();
                }
            }
        });

        mHead_left_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callBack != null) {
                    callBack.clickLeft();
                }
            }
        });


        mHead_right_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callBack != null) {
                    callBack.clickRight();
                }

            }
        });

        mHead_right_iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callBack != null) {
                    callBack.clickRight();
                }
            }
        });

    }

    public RelativeLayout getmHead_rl() {
        return mHead_rl;
    }


    public ImageView getmHead_left_iv() {
        return mHead_left_iv;
    }

    public HeadLayoutView setmHead_left_iv(int res) {
        this.mHead_left_iv.setImageResource(res);
        return this;
    }


    public TextView getmHead_left_tv() {
        return mHead_left_tv;
    }

    public HeadLayoutView setmHead_left_tv(String text) {
        this.mHead_left_tv.setText(text);
        return this;
    }

    public ImageView getmHead_middle_iv() {
        this.mHead_middle_tv.setVisibility(View.INVISIBLE);
        return mHead_middle_iv;
    }

    public HeadLayoutView setmHead_middle_iv(int res) {
        this.mHead_middle_tv.setVisibility(View.INVISIBLE);
        this.mHead_middle_iv.setImageResource(res);
        return this;
    }

    public TextView getmHead_middle_tv() {
        this.mHead_middle_iv.setVisibility(View.INVISIBLE);
        return mHead_middle_tv;
    }

    public HeadLayoutView setmHead_middle_tv(String text) {
        this.mHead_middle_iv.setVisibility(View.INVISIBLE);
        this.mHead_middle_tv.setText(text);
        return this;
    }

    public TextView getmHead_right_tv() {
        this.mHead_right_iv.setVisibility(View.INVISIBLE);
        return mHead_right_tv;
    }

    public HeadLayoutView setmHead_right_tv(String text) {
        this.mHead_right_tv.setText(text);
        this.mHead_right_iv.setVisibility(View.INVISIBLE);
        return this;
    }

    public ImageView getmHead_right_iv() {
        this.mHead_right_tv.setVisibility(View.INVISIBLE);
        return mHead_right_iv;
    }

    public HeadLayoutView setmHead_right_iv(int res) {
        this.mHead_right_tv.setVisibility(View.INVISIBLE);
        this.mHead_right_iv.setImageResource(res);
        return this;
    }

    private CallBack callBack;

    public HeadLayoutView setCallBack(CallBack callBack) {
        this.callBack = callBack;
        return this;
    }

    public interface CallBack {
        void clickLeft();

        void clickRight();
    }
}
