package com.showcast.showcast.base;

import android.support.v4.app.Fragment;

/**
 * Created by taro on 16/8/11.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        onVisibilityChanged(isVisibleToUser);
    }

    protected abstract void onVisibilityChanged(boolean isVisible);
}
