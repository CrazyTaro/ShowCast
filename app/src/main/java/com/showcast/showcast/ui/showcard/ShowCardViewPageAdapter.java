package com.showcast.showcast.ui.showcard;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.showcast.showcast.R;
import com.showcast.showcast.base.ShowCastApp;
import com.showcast.showcast.constant.ConstantView;
import com.showcast.showcast.utils.ResourceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taro on 16/8/15.
 */
public class ShowCardViewPageAdapter extends PagerAdapter {
    private ViewHolder[] mPageViewHolder;

    public ShowCardViewPageAdapter() {
        mPageViewHolder = new ViewHolder[this.getCount()];
    }

    /**
     * return the view of page,maybe null if the page never be seen
     *
     * @param position
     * @return
     */
    public ViewHolder getView(int position) {
        if (position >= 0 && position < getCount()) {
            ViewHolder view = mPageViewHolder[position];
            return view;
        } else {
            return null;
        }
    }

    /**
     * set tab title
     *
     * @param tl
     */
    public void setTabTitle(TabLayout tl) {
        String[] titles = new String[3];
        titles[0] = ResourceUtil.getString(R.string.show_card_tab_title_date);
        titles[1] = ResourceUtil.getString(R.string.show_card_tab_title_season);
        titles[2] = ResourceUtil.getString(R.string.show_card_tab_title_detail);
        for (int i = 0; i < titles.length; i++) {
            TabLayout.Tab tab = tl.newTab();
            tab.setText(titles[i]);
            tl.addTab(tab);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
//        return object != null && view == ((ViewHolder) object).getRootView();
        return object == view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewHolder viewHolder = mPageViewHolder[position];
        View rootView;
        if (viewHolder == null) {
            rootView = inflateView(position, container);
            mPageViewHolder[position] = new ViewHolder(ConstantView.SHOW_CARD_DATE, rootView);
        } else {
            rootView = viewHolder.getRootView();
        }
        Integer viewTag = (Integer) rootView.getTag();
        if (viewTag == null || viewTag != Integer.MAX_VALUE) {
            container.removeView(rootView);
            container.addView(rootView);
            rootView.setTag(Integer.MAX_VALUE);
        }
        return rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeAllViews();
        mPageViewHolder[position] = null;
    }

    private View inflateView(int position, ViewGroup container) {
        switch (position) {
            case 0:
            case 1:
                return ShowCastApp.getInflater().inflate(R.layout.layout_pager_show_card_date_season,
                        container,
                        false);
            case 2:
            default:
                return ShowCastApp.getInflater().inflate(R.layout.layout_pager_show_card_detail,
                        container,
                        false);
        }
    }

    public static class ViewHolder {
        View mRootView;
        @Nullable
        @BindView(R.id.spn_show_card_season)
        Spinner mSpnSeason;
        @Nullable
        @BindView(R.id.explv_show_card_season)
        ExpandableListView mExplvBase;
        @Nullable
        @BindView(R.id.tv_show_card_detail_desc)
        TextView mTvDetailDesc;
        @Nullable
        @BindView(R.id.iv_show_card_detail_icon)
        ImageView mIvDetailIcon;
        @Nullable
        @BindView(R.id.iv_show_card_detail_recommend_1)
        ImageView mIvRecommand_1;
        @Nullable
        @BindView(R.id.iv_show_card_detail_recommend_2)
        ImageView mIvRecommand_2;
        @Nullable
        @BindView(R.id.iv_show_card_detail_recommend_3)
        ImageView mIvRecommand_3;

        public ViewHolder(@ConstantView.ShowCardTabType int type, View contentView) {
            mRootView = contentView;
            ButterKnife.bind(this, contentView);
        }

        public View getRootView() {
            return mRootView;
        }

        public ExpandableListView getExpandListView() {
            return mExplvBase;
        }

        public Spinner getSpinner() {
            return mSpnSeason;
        }

        public TextView getTvDetailDesc() {
            return mTvDetailDesc;
        }

        public ImageView getIvDetailIcon() {
            return mIvDetailIcon;
        }

        public ImageView getIvDetailRecommand(int which) {
            switch (which) {
                case 0:
                    return mIvRecommand_1;
                case 1:
                    return mIvRecommand_2;
                case 2:
                    return mIvRecommand_3;
                default:
                    return null;
            }
        }
    }
}
