package com.showcast.showcast.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.showcast.showcast.R;
import com.showcast.showcast.base.BaseActivity;
import com.showcast.showcast.constant.ConstantStatus;
import com.showcast.showcast.helper.ToolbarHelper;
import com.showcast.showcast.utils.CommonUtil;
import com.taro.headerrecycle.adapter.HeaderRecycleAdapter;
import com.taro.headerrecycle.adapter.SimpleRecycleAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taro on 16/8/15.
 */
public class SettingCommonActivity extends BaseActivity {
    @BindView(R.id.rv_activity_setting_common)
    RecyclerView mRvBase;
    @BindView(R.id.main_toolbar)
    View mToolBar;

    private ToolbarHelper mToolBarHelper;

    /**
     * @param type
     * @param act
     */
    public static final void startSettingActivity(@ConstantStatus.SettingType int type,Activity act){
        if(act!=null) {
            Intent actIntent = new Intent(act, SettingCommonActivity.class);
            actIntent.putExtra(ConstantStatus.INTENT_KEY_SETTING_TYPE, type);
            act.startActivity(actIntent);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_common);

        ButterKnife.bind(this);
        mRvBase.setLayoutManager(new LinearLayoutManager(this));

        mToolBarHelper = new ToolbarHelper(mToolBar);
        mToolBarHelper.setVisibility(ToolbarHelper.VIEW_CAST, false);
        mToolBarHelper.setVisibility(ToolbarHelper.VIEW_SEARCH, false);

        this.initialIntent(getIntent());
    }

    private void initialIntent(Intent fromIntent) {
        if (fromIntent != null) {
            int type = fromIntent.getIntExtra(ConstantStatus.INTENT_KEY_SETTING_TYPE, 0);
            int strId = 0;
            switch (type) {
                case ConstantStatus.INTENT_SETTING_TYPE_LIVE_CHANNELS:
                    strId = R.string.setting_title_live_channel;
                    //TODO: set data
                    mRvBase.setAdapter(new HeaderRecycleAdapter(this,
                            new LiveChannelOption(),
                            CommonUtil.getExampleHeaderList(),
                            CommonUtil.getExampleHeaderMap()));
                    break;
                case ConstantStatus.INTENT_SETTING_TYPE_STREAM_APP:
                    strId = R.string.setting_title_stream_app;
                    mRvBase.setAdapter(new SimpleRecycleAdapter(this,
                            new StreamAppOption(),
                            CommonUtil.getExampleList()));
                    break;
                case ConstantStatus.INTENT_SETTING_TYPE_RECORD_PRIORITY:
                    strId = R.string.setting_title_record_priority;
                    mRvBase.setAdapter(new SimpleRecycleAdapter(this,
                            new RecordPriorityOption(),
                            CommonUtil.getExampleList()));
                    break;
            }
            mToolBarHelper.setTitle(strId);
        }
    }
}
