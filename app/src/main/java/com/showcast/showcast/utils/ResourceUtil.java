package com.showcast.showcast.utils;

import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.StringRes;
import android.util.TypedValue;

import com.showcast.showcast.base.ShowCastApp;

/**
 * Created by taro on 16/8/12.
 */
public class ResourceUtil {
    public static final String getString(@StringRes int id) {
        return ShowCastApp.getContext().getString(id);
    }

    public static final int getColor(@ColorRes int id) {
        return ShowCastApp.getContext().getResources().getColor(id);
    }

    public static final float getDimen(@DimenRes int id) {
        return ShowCastApp.getContext().getResources().getDimension(id);
    }

    public static final float convertDpToPx(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp,
                ShowCastApp.getContext().getResources().getDisplayMetrics());
    }
}
