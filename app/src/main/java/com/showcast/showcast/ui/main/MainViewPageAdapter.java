package com.showcast.showcast.ui.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.showcast.showcast.base.BaseFragment;
import com.showcast.showcast.ui.discovery.DiscoveryFragment;
import com.showcast.showcast.ui.library.LibraryFragment;
import com.showcast.showcast.ui.live.LiveFragment;

/**
 * Created by taro on 16/8/12.
 */
public class MainViewPageAdapter extends FragmentPagerAdapter {
    private BaseFragment[] mFragments;

    public MainViewPageAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new BaseFragment[3];
        mFragments[0] = new LiveFragment();
        mFragments[1] = new DiscoveryFragment();
        mFragments[2] = new LibraryFragment();
    }

    /**
     * set the tabs' title
     *
     * @param tl
     */
    public void setTabTitles(TabLayout tl) {
        if (tl != null && mFragments != null) {
            for (int i = 0; i < mFragments.length; i++) {
                TabLayout.Tab tab = tl.newTab();
                String title = getItem(i).getFragmentTitle();
                tab.setText(title);
                tl.addTab(tab);
            }
        }
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.length;
    }

    @Override
    public BaseFragment getItem(int position) {
        return mFragments[position];
    }
}
