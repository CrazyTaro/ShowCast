package com.showcast.showcast.ui.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.showcast.showcast.R;
import com.showcast.showcast.base.BaseFragment;
import com.showcast.showcast.utils.CommonUtil;
import com.showcast.showcast.utils.ResourceUtil;
import com.taro.headerrecycle.adapter.SimpleRecycleAdapter;

/**
 * Created by taro on 16/8/15.
 */
public class LibraryFragment extends BaseFragment {
    private RecyclerView mRvBase;

    @Override
    protected void onVisibilityChanged(boolean isVisible, boolean isViewInitial) {
        if (isVisible && isViewInitial && mRvBase.getAdapter() == null) {
            //set data
            mRvBase.setAdapter(new SimpleRecycleAdapter(getActivity(),
                    new SortOption(mRvBase),
                    CommonUtil.getExampleList()));
        }
    }

    @Override
    public String getFragmentTitle() {
        return ResourceUtil.getString(R.string.main_fragment_title_library);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRvBase = (RecyclerView) inflater.inflate(R.layout.fragment_base, container, false);
        //3 columns in each row
        mRvBase.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        return mRvBase;
    }
}
