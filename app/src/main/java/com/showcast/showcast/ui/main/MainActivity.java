package com.showcast.showcast.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.showcast.showcast.R;
import com.showcast.showcast.base.BaseActivity;
import com.showcast.showcast.constant.ConstantStatus;
import com.showcast.showcast.helper.NavigateBarHelper;
import com.showcast.showcast.helper.ProfileHelper;
import com.showcast.showcast.helper.ToolbarHelper;
import com.showcast.showcast.ui.setting.SettingCommonActivity;
import com.showcast.showcast.utils.ViewPagerTabBindUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    @BindView(R.id.tl_main_module)
    TabLayout mTlMain;
    @BindView(R.id.main_toolbar)
    View mToolBar;
    @BindView(R.id.main_profile)
    View mProfileView;
    @BindView(R.id.main_second_navigate_bar)
    View mSecondNavigateBar;

    private ToolbarHelper mToolBarHelper;
    private NavigateBarHelper mNavigateHelper;
    private ProfileHelper mProfileHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mToolBarHelper = new ToolbarHelper(mToolBar);
        mNavigateHelper = new NavigateBarHelper(mSecondNavigateBar);
        mProfileHelper = new ProfileHelper(mProfileView);

        //hide main title and the text of back icon at the second navigate bar
        mToolBarHelper.setTitle(null);
        mNavigateHelper.setVisibility(NavigateBarHelper.VIEW_BACK, false);
        mProfileHelper.setOnClickListener(new ProfileOnClickListener());

        MainViewPageAdapter adapter = new MainViewPageAdapter(getSupportFragmentManager());
        adapter.setTabTitles(mTlMain);
        mVpMain.setAdapter(adapter);
        mVpMain.setOffscreenPageLimit(2);
        ViewPagerTabBindUtil.bind(mVpMain, mTlMain);

        mVpMain.setCurrentItem(1);
    }

    private class ProfileOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent actIntent;
            switch (v.getId()) {
                case R.id.tv_profile_live_channel:
                    SettingCommonActivity.startSettingActivity(ConstantStatus.INTENT_SETTING_TYPE_LIVE_CHANNELS,
                            MainActivity.this);
                    break;
                case R.id.tv_profile_stream_app:
                    SettingCommonActivity.startSettingActivity(ConstantStatus.INTENT_SETTING_TYPE_STREAM_APP,
                            MainActivity.this);
                    break;
                case R.id.tv_profile_record_priority:
                    SettingCommonActivity.startSettingActivity(ConstantStatus.INTENT_SETTING_TYPE_RECORD_PRIORITY,
                            MainActivity.this);
                    break;
                case R.id.tv_profile_devices:
                    break;
                case R.id.tv_profile_account:
                    break;
                case R.id.tv_profile_help:
                    break;
                case R.id.tv_profile_sign_out:
                    break;
                case R.id.tv_profile_terms:
                    break;
            }
        }
    }
}
