package com.showcast.showcast.ui.showcard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.showcast.showcast.R;
import com.showcast.showcast.base.BaseActivity;
import com.showcast.showcast.utils.CommonUtil;
import com.showcast.showcast.utils.ResourceUtil;
import com.showcast.showcast.utils.ViewPagerTabBindUtil;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnPageChange;

/**
 * Created by taro on 16/8/15.
 */
public class ShowCardActivity extends BaseActivity {
    //main layout
    @BindView(R.id.main_toolbar)
    View mToolBar;
    @BindView(R.id.v_show_card_play_place)
    View mVPlayPlace;
    @BindView(R.id.tv_show_card_play_1)
    TextView mTvPlayText_1;
    @BindView(R.id.tv_show_card_play_main)
    TextView mTvPlayTextMain;
    @BindView(R.id.tv_show_card_play_2)
    TextView mTvPlayText_2;

    //bottom sliding layout
    //the view for helping the expand list view showing in a correct way
    //without this the expand list view may not scroll(part of view is under the bottom)
    @BindView(R.id.v_show_card_info_place)
    View mVInfoPlace;
    @BindView(R.id.tl_show_card_title)
    TabLayout mTlShowCard;
    @BindView(R.id.vp_show_card_content)
    ViewPager mVpShowCard;
    @BindView(R.id.iv_show_card_follow)
    ImageView mIvFollow;
    @BindView(R.id.iv_show_card_alarm)
    ImageView mIvAlarm;
    @BindView(R.id.tv_show_card_record)
    TextView mTvRecord;

    //sliding viewGroup
    @BindView(R.id.sl_show_card_layer)
    SlidingUpPanelLayout mSlPanel;

    private ShowCardViewPageAdapter mVpAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_card);

        ButterKnife.bind(this);
        mToolBar.setBackgroundResource(R.drawable.shape_show_card_tool_bar);

        mVpAdapter = new ShowCardViewPageAdapter();
        mVpAdapter.setTabTitle(mTlShowCard);
        mVpShowCard.setAdapter(mVpAdapter);
        mVpShowCard.setOffscreenPageLimit(2);
        ViewPagerTabBindUtil.bind(mVpShowCard, mTlShowCard);

        mSlPanel.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                int baseHeight = (int) ResourceUtil.convertDpToPx(150);
                int slideHeight = (int) ResourceUtil.convertDpToPx(200);
                int offsetHeight = (int) (slideOffset * slideHeight);
                int maxHeight = (int) ResourceUtil.convertDpToPx(350);
                int viewHeight = maxHeight - (offsetHeight + baseHeight);
                CommonUtil.setViewHeight(mVInfoPlace, viewHeight, maxHeight);
                Log.i("view_height", viewHeight + "");
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

            }
        });
    }

//    @OnClick(value = {R.id.iv_show_card_follow,
//            R.id.iv_show_card_alarm,
//            R.id.tv_show_card_record,
//            R.id.rl_show_card_play})
//    void showCardClickListener(View view) {
//        ShowCastApp.showShortToast("test click");
//        float height = ResourceUtil.getDimen(R.dimen.height_show_card_info);
//    }


    @OnPageChange(value = R.id.vp_show_card_content, callback = OnPageChange.Callback.PAGE_SELECTED)
    public void onPageSelected(int position) {
        ShowCardViewPageAdapter.ViewHolder viewHolder = mVpAdapter.getView(position);
        ExpandableListView explv = viewHolder.getExpandListView();
        if (explv != null && explv.getAdapter() == null) {
            explv.setAdapter(new DateExpAdapter());
        }
    }
}
