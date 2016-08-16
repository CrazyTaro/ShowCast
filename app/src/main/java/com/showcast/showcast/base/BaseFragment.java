package com.showcast.showcast.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by taro on 16/8/11.
 */
public abstract class BaseFragment extends Fragment {
    protected boolean mIsViewInitial = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        onVisibilityChanged(isVisibleToUser, mIsViewInitial);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mIsViewInitial = true;
    }

    /**
     * a callBack for fragment visibility
     *
     * @param isVisible
     * @param isViewInitial
     */
    protected abstract void onVisibilityChanged(boolean isVisible, boolean isViewInitial);

    /**
     * get the fragment's title (for tab)
     *
     * @return
     */
    public abstract String getFragmentTitle();
}
