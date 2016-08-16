package com.showcast.showcast.ui.discovery;

import android.support.v7.widget.RecyclerView;

import com.showcast.showcast.R;
import com.showcast.showcast.utils.RecyclerViewUtil;
import com.taro.headerrecycle.adapter.HeaderRecycleViewHolder;
import com.taro.headerrecycle.adapter.SimpleRecycleAdapter;

/**
 * Created by taro on 16/8/15.
 */
public class GenresOption extends SimpleRecycleAdapter.SimpleAdapterOption {
    private RecyclerView mParentView;
    private int mHeight;

    public GenresOption(RecyclerView view) {
        this.setRecycleView(view);
    }

    /**
     * set parent view for calculate the child views height.
     * one page is two columns
     *
     * @param view
     */
    public void setRecycleView(RecyclerView view) {
        mParentView = view;
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public void setViewHolder(Object itemData, int position, HeaderRecycleViewHolder holder) {
        if (mHeight <= 0) {
            mHeight = RecyclerViewUtil.getParentViewHeight(mParentView, 2);
        }
        RecyclerViewUtil.setRootViewHeight(mHeight, holder.getRootView());
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_genrs_list;
    }

}
