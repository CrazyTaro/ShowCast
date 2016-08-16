package com.showcast.showcast.ui.live;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.showcast.showcast.R;
import com.showcast.showcast.base.BaseFragment;
import com.showcast.showcast.base.ShowCastApp;
import com.showcast.showcast.ui.showcard.ShowCardActivity;
import com.showcast.showcast.utils.CommonUtil;
import com.showcast.showcast.utils.ResourceUtil;
import com.taro.headerrecycle.adapter.SimpleRecycleAdapter;
import com.taro.headerrecycle.helper.RecycleViewOnClickHelper;

/**
 * Created by taro on 16/8/12.
 */
public class LiveFragment extends BaseFragment implements RecycleViewOnClickHelper.OnItemClickListener {
    RecyclerView mRvBase;

    @Override
    protected void onVisibilityChanged(boolean isVisible, boolean isViewInitial) {
        if (isVisible && isViewInitial && mRvBase.getAdapter() == null) {
            //set data
            mRvBase.setAdapter(new SimpleRecycleAdapter(getActivity(),
                    new LiveNowOption(),
                    CommonUtil.getExampleList()));
        }
    }

    @Override
    public String getFragmentTitle() {
        return ResourceUtil.getString(R.string.main_fragment_title_live);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRvBase = (RecyclerView) inflater.inflate(R.layout.fragment_base, container, false);
        mRvBase.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecycleViewOnClickHelper onClickHelper = new RecycleViewOnClickHelper(ShowCastApp.getContext());
        onClickHelper.setOnItemClickListener(this);
        onClickHelper.attachToRecycleView(mRvBase);
        return mRvBase;
    }

    @Override
    public boolean onItemClick(View view, int position, RecyclerView.ViewHolder holder) {
        Intent actIntent = new Intent(getActivity(), ShowCardActivity.class);
        getActivity().startActivity(actIntent);
        return true;
    }
}
