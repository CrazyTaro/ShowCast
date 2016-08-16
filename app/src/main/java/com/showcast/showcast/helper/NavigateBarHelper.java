package com.showcast.showcast.helper;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;

import com.showcast.showcast.R;
import com.showcast.showcast.base.ShowCastApp;
import com.showcast.showcast.utils.ResourceUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taro on 16/8/12.
 */
public class NavigateBarHelper {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(flag = false, value = {VIEW_BACK, VIEW_LEFT_MENU, VIEW_RIGHT_MENU})
    public @interface ViewType {
    }

    /**
     * text of back icon
     */
    public static final int VIEW_BACK = R.id.tv_navigate_back;
    /**
     * text of left menu
     */
    public static final int VIEW_LEFT_MENU = R.id.tv_navigate_left_menu;
    /**
     * text of right menu
     */
    public static final int VIEW_RIGHT_MENU = R.id.tv_navigate_right_menu;

    @BindView(R.id.tv_navigate_back)
    TextView mTvBack;
    @BindView(R.id.tv_navigate_left_menu)
    TextView mTvMenuLeft;
    @BindView(R.id.tv_navigate_right_menu)
    TextView mTvMenuRight;

    public NavigateBarHelper(View contentView) {
        ButterKnife.bind(this, contentView);
    }

    public NavigateBarHelper(Activity act) {
        ButterKnife.bind(this, act);
    }

    /**
     * set the back drawable
     *
     * @param drawable
     */
    public void setBackDrawable(Drawable drawable) {
        mTvBack.setCompoundDrawables(drawable, null, null, null);
    }

    /**
     * set the back drawable
     *
     * @param id
     */
    public void setBackDrawable(@DrawableRes int id) {
        Drawable drawable = ShowCastApp.getContext().getResources().getDrawable(id);
        mTvBack.setCompoundDrawables(drawable, null, null, null);
    }

    /**
     * set the text of view
     *
     * @param view
     * @param text
     */
    public void setText(@ViewType int view, String text) {
        switch (view) {
            case VIEW_BACK:
                mTvBack.setText(text);
                break;
            case VIEW_LEFT_MENU:
                mTvMenuLeft.setText(text);
                break;
            case VIEW_RIGHT_MENU:
                mTvMenuRight.setText(text);
                break;
        }
    }

    /**
     * set the text of view
     *
     * @param view
     * @param id
     */
    public void setText(@ViewType int view, @StringRes int id) {
        String text = ResourceUtil.getString(id);
        this.setText(view, text);
    }

    /**
     * set if the view is visible
     *
     * @param view
     * @param isVisible
     */
    public void setVisibility(@ViewType int view, boolean isVisible) {
        int visible = isVisible ? View.VISIBLE : View.INVISIBLE;
        switch (view) {
            case VIEW_BACK:
                mTvBack.setVisibility(visible);
                break;
            case VIEW_LEFT_MENU:
                mTvMenuLeft.setVisibility(visible);
                break;
            case VIEW_RIGHT_MENU:
                mTvMenuRight.setVisibility(visible);
                break;
        }
    }
}
