package com.showcast.showcast.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.showcast.showcast.utils.ResourceUtil;

/**
 * Created by taro on 16/8/12.
 */
public class ShowCastApp extends Application {
    private static Context mInstance;
    private static Toast mToast;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
    }

    public static Context getContext() {
        return mInstance;
    }

    //show short toast
    public static void showShortToast(String text) {
        if (mToast != null && !TextUtils.isEmpty(text)) {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(text);
            mToast.show();
        }
    }

    //show short toast
    public static void showShortToast(@StringRes int id) {
        String text = ResourceUtil.getString(id);
        showShortToast(text);
    }

    //show long toast
    public static void showLongToast(String text) {
        if (mToast != null && !TextUtils.isEmpty(text)) {
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.setText(text);
            mToast.show();
        }
    }

    //show long toast
    public static void showLongToast(@StringRes int id) {
        String text = ResourceUtil.getString(id);
        showLongToast(text);
    }


    public static LayoutInflater getInflater() {
        if (mInstance != null) {
            return LayoutInflater.from(mInstance);
        } else {
            return null;
        }
    }
}
