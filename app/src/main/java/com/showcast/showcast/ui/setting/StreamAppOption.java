package com.showcast.showcast.ui.setting;

import com.showcast.showcast.R;
import com.taro.headerrecycle.adapter.HeaderRecycleViewHolder;
import com.taro.headerrecycle.adapter.SimpleRecycleAdapter;

/**
 * Created by taro on 16/8/15.
 */
public class StreamAppOption extends SimpleRecycleAdapter.SimpleAdapterOption {

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public void setViewHolder(Object itemData, int position, HeaderRecycleViewHolder holder) {

    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_setting_stream;
    }
}
