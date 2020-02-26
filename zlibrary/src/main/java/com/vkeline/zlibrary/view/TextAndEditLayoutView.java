package com.vkeline.zlibrary.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vkeline.zlibrary.R;
import com.vkeline.zlibrary.util.AutoSizeUtils;

/**
 * @author Zhou
 *         Created on 2017/12/15 8:42.
 *         Email:qishuichixi@163.com
 *         Desc:
 */

public class TextAndEditLayoutView extends LinearLayout {

    private TextView tv;
    private EditText et;
    private TextView right_tv;

    public TextAndEditLayoutView(Context context) {
        this(context, null);

    }

    public TextAndEditLayoutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextAndEditLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {

        View view = LayoutInflater.from(context).inflate(R.layout.view_textandedit, this, true);
        AutoSizeUtils.auto(view);

        tv = (TextView) findViewById(R.id.auto_view_tv);
        et = (EditText) findViewById(R.id.auto_view_et);
        right_tv = (TextView) findViewById(R.id.auto_view_right_tv);


        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TextAndEditLayoutView);
        //在xml中获取设置
        if (attributes != null) {

            String text = attributes.getString(R.styleable.TextAndEditLayoutView_view_et_tv);
            if (!TextUtils.isEmpty(text)) {
                tv.setText(text);
            }

            //是否展示
            Boolean flag = attributes.getBoolean(R.styleable.TextAndEditLayoutView_view_et_enable, true);

            if (flag) {
                et.setVisibility(View.VISIBLE);
                right_tv.setVisibility(View.GONE);
            } else {
                et.setVisibility(View.GONE);
                right_tv.setVisibility(View.VISIBLE);
            }

        }
        attributes.recycle();
    }


    public TextAndEditLayoutView setText(String text) {
        tv.setText(text);
        return this;
    }

    public EditText getEdit() {
        return et;
    }

    public String getEditString() {

        if (et != null) {
            return et.getText().toString().trim();
        }
        return "";
    }

    public TextView getRight_tv() {
        return right_tv;
    }
}
