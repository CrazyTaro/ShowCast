package com.showcast.showcast.ui.setting;

import com.showcast.showcast.R;
import com.taro.headerrecycle.adapter.HeaderRecycleAdapter;
import com.taro.headerrecycle.adapter.HeaderRecycleViewHolder;

/**
 * Created by taro on 16/8/15.
 */
public class LiveChannelOption implements HeaderRecycleAdapter.IHeaderAdapterOption {
    @Override
    public int getHeaderViewType(int groupId, int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position, int groupId, int childId, boolean isHeaderItem, boolean isShowHeader) {
        if (isHeaderItem) {
            return getHeaderViewType(groupId, position);
        } else {
            return 1;
        }
    }

    @Override
    public int getLayoutId(int viewType) {
        switch (viewType) {
            case 0:
                //header
                return R.layout.item_header_setting_channel;
            case 1:
                //sub item
                return R.layout.item_setting_channel;
            default:
                //default return sub item layout id
                return R.layout.item_setting_channel;
        }
    }

    @Override
    public void setHeaderHolder(int groupId, Object header, HeaderRecycleViewHolder holder) {

    }

    @Override
    public void setViewHolder(int groupId, int childId, int position, Object itemData, HeaderRecycleViewHolder holder) {

    }
}
