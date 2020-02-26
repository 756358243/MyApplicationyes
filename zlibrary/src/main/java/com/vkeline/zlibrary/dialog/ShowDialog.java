package com.vkeline.zlibrary.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vkeline.zlibrary.R;
import com.vkeline.zlibrary.util.DensityUtils;

/**
 * Created by zhou on 2018/1/12.
 */
public class ShowDialog {

    private ImageView loadingImage;
    private TextView hint;

    public Dialog mDialog;
    private AnimationDrawable animationDrawable = null;

    public ShowDialog(Context context) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_loading, null);

        loadingImage = (ImageView) view.findViewById(R.id.loading_view);
        hint = (TextView) view.findViewById(R.id.loading_message);

        loadingImage.setImageResource(R.drawable.loading_animation);
        animationDrawable = (AnimationDrawable) loadingImage.getDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.start();

        mDialog = new Dialog(context, R.style.ShadowDialog);
        mDialog.setContentView(view);

        int screenHeight = DensityUtils.getScreenHeight(context);
        int statusBarHeight = DensityUtils.getStatusHeight(context);
        int dialogHeight = screenHeight - statusBarHeight;
        mDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);

        mDialog.setCanceledOnTouchOutside(false);


    }

    DialogInterface.OnKeyListener keylistener = new DialogInterface.OnKeyListener() {
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                return true;
            } else {
                return false;
            }
        }
    };

    public void setKey() {
        mDialog.setOnKeyListener(keylistener);

    }

    public ShowDialog setHint(String msg) {
        hint.setText(msg);
        return this;
    }

    public ShowDialog setDisplay(boolean flag) {
        if (flag) {
            mDialog.show();
        } else {
            if (mDialog.isShowing()) {
                mDialog.dismiss();
                animationDrawable.stop();
            }
        }
        return this;
    }

    public void setCanceledOnTouchOutside(boolean cancel) {
        mDialog.setCanceledOnTouchOutside(cancel);
    }
}


