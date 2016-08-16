package com.showcast.showcast.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by taro on 16/8/15.
 */
public class RecyclerViewUtil {

    /**
     * calculate the each row's height in recycleView
     *
     * @param view
     * @param rowCount how many row need
     * @return
     */
    public static int getParentViewHeight(RecyclerView view, int rowCount) {
        if (view != null && rowCount > 0) {
            int viewHeight = view.getHeight();
            if (viewHeight <= 0) {
                viewHeight = view.getMeasuredHeight();
            }
            return viewHeight / rowCount;
        } else {
            return 0;
        }
    }

    /**
     * set child view height
     */
    public static void setRootViewHeight(int height, View rootView) {
        ViewGroup.LayoutParams params = rootView.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(-1, 0);
        }
        params.height = height;
        rootView.setLayoutParams(params);
    }
}
