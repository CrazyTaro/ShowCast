package com.showcast.showcast.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by taro on 16/8/12.
 */
public class CommonUtil {
    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    public static List<String> getExampleList() {
        ArrayList<String> listItem = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            listItem.add("1");
        }
        return listItem;
    }

    public static List<List<String>> getExampleHeaderList() {
        ArrayList<List<String>> headerItem = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            ArrayList<String> listItem = new ArrayList<>(10);
            for (int j = 0; j < 10; j++) {
                listItem.add("1");
            }
            headerItem.add(listItem);
        }
        return headerItem;
    }

    public static Map<Integer, String> getExampleHeaderMap() {
        HashMap<Integer, String> headerMap = new HashMap<>(5);
        for (int i = 0; i < 5; i++) {
            headerMap.put(i, "header-" + i);
        }
        return headerMap;
    }

    public static void setViewHeight(View view, int newHeight, int maxHeight) {
        if (view != null) {
            if (newHeight > maxHeight) {
                newHeight = maxHeight;
            } else if (newHeight < 0) {
                newHeight = 0;
            }
            int viewWidth = view.getWidth();
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (params == null) {
                params = new ViewGroup.LayoutParams(viewWidth, newHeight);
            } else {
                params.height = newHeight;
            }

            view.setLayoutParams(params);
        }
    }

    public static void setViewOffsetHeight(View view, int offsetHeight, int maxHeight) {
        if (view != null) {
            int viewHeight = view.getHeight();
            viewHeight += offsetHeight;

            setViewHeight(view,viewHeight,maxHeight);
        }
    }
}
