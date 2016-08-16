package com.showcast.showcast.helper;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.showcast.showcast.R;
import com.showcast.showcast.utils.ResourceUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taro on 16/8/12.
 */
public class ToolbarHelper {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(flag = false, value = {VIEW_MENU, VIEW_CAST, VIEW_SEARCH, VIEW_TITLE})
    public @interface ViewType {
    }

    /**
     * menu view at left,can also set a back icon
     */
    public static final int VIEW_MENU = R.id.iv_toolbar_menu;
    /**
     * cast view at right
     */
    public static final int VIEW_CAST = R.id.iv_toolbar_cast;
    /**
     * search view at right
     */
    public static final int VIEW_SEARCH = R.id.iv_toolbar_search;
    /**
     * center title view
     */
    public static final int VIEW_TITLE = R.id.tv_toolbar_title;

    @BindView(R.id.iv_toolbar_menu)
    ImageView mIvMenu;
    @BindView(R.id.iv_toolbar_cast)
    ImageView mIvCast;
    @BindView(R.id.iv_toolbar_search)
    ImageView mIvSearch;
    @BindView(R.id.tv_toolbar_title)
    TextView mTvTitle;

    public ToolbarHelper(View contentView) {
        ButterKnife.bind(this, contentView);
    }

    public ToolbarHelper(Activity act) {
        ButterKnife.bind(this, act);
    }

    /**
     * set the center title,if title is null,hide the view
     *
     * @param title
     */
    public void setTitle(String title) {
        if (title == null) {
            mTvTitle.setVisibility(View.INVISIBLE);
        } else {
            mTvTitle.setVisibility(View.VISIBLE);
            mTvTitle.setText(title);
        }
    }

    /**
     * set the center title
     *
     * @param id
     */
    public void setTitle(@StringRes int id) {
        String title = ResourceUtil.getString(id);
        this.setTitle(title);
    }

    /**
     * set menu or cast/search icon,the menu icon can change to back icon
     *
     * @param view
     * @param id
     */
    public void setDrawable(@ViewType int view, @DrawableRes int id) {
        switch (view) {
            case VIEW_MENU:
                mIvMenu.setImageResource(id);
                break;
            case VIEW_CAST:
                mIvCast.setImageResource(id);
                break;
            case VIEW_SEARCH:
                mIvSearch.setImageResource(id);
                break;
        }
    }

    /**
     * set if one of views is enabled;
     *
     * @param view
     * @param isEnable
     */
    public void setEnable(@ViewType int view, boolean isEnable) {
        switch (view) {
            case VIEW_MENU:
                mIvMenu.setEnabled(isEnable);
                break;
            case VIEW_CAST:
                mIvCast.setEnabled(isEnable);
                break;
            case VIEW_SEARCH:
                mIvSearch.setEnabled(isEnable);
                break;
            case VIEW_TITLE:
                mTvTitle.setEnabled(isEnable);
                break;
        }
    }

    /**
     * set view onClickListener,viewId can be matched from {@link ViewType}
     *
     * @param listener
     */
    public void setOnClickListener(View.OnClickListener listener) {
        mIvMenu.setOnClickListener(listener);
        mIvCast.setOnClickListener(listener);
        mIvSearch.setOnClickListener(listener);
        mTvTitle.setOnClickListener(listener);
    }

    /**
     * set menu buttons or title visibility
     *
     * @param view
     * @param isVisible
     */
    public void setVisibility(@ViewType int view, boolean isVisible) {
        int visible = isVisible ? View.VISIBLE : View.INVISIBLE;
        switch (view) {
            case VIEW_MENU:
                mIvMenu.setVisibility(visible);
                break;
            case VIEW_CAST:
                mIvCast.setVisibility(visible);
                break;
            case VIEW_SEARCH:
                mIvSearch.setVisibility(visible);
                break;
            case VIEW_TITLE:
                mTvTitle.setVisibility(visible);
                break;
        }
    }
}
