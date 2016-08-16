package com.showcast.showcast.utils;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

/**
 * Created by taro on 16/8/12.
 */
public class ViewPagerTabBindUtil {


    public static final void bind(final ViewPager vp, final TabLayout tab) {
        if (tab != null && vp != null) {
            tab.setupWithViewPager(vp);
        }
//        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                vp.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
//        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                tab.setScrollPosition(tab.getSelectedTabPosition(), position, true);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }
}
