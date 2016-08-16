package com.showcast.showcast.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.showcast.showcast.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by taro on 16/8/15.
 */
public class ProfileHelper {
    @BindView(R.id.civ_profile_avatar)
    CircleImageView mCivAvatar;
    @BindView(R.id.tv_profile_user)
    TextView mTvUser;
    @BindView(R.id.tv_profile_live_channel)
    TextView mTvLiveChannel;
    @BindView(R.id.tv_profile_stream_app)
    TextView mTvStreamApp;
    @BindView(R.id.tv_profile_record_priority)
    TextView mTvRecordPriority;
    @BindView(R.id.tv_profile_devices)
    TextView mTvDevice;
    @BindView(R.id.tv_profile_account)
    TextView mTvAccount;
    @BindView(R.id.tv_profile_help)
    TextView mTvHelp;
    @BindView(R.id.pb_profile_use_hour)
    ProgressBar mPbUseHour;
    @BindView(R.id.tv_profile_used_time)
    TextView mTvUseHour;
    @BindView(R.id.tv_profile_sign_out)
    TextView mTvSignOut;
    @BindView(R.id.tv_profile_terms)
    TextView mTvTerm;

    public ProfileHelper(View contentView) {
        ButterKnife.bind(this, contentView);
    }

    public ProfileHelper(Activity act) {
        ButterKnife.bind(this, act);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        mTvLiveChannel.setOnClickListener(listener);
        mTvStreamApp.setOnClickListener(listener);
        mTvRecordPriority.setOnClickListener(listener);
        mTvDevice.setOnClickListener(listener);
        mTvAccount.setOnClickListener(listener);
        mTvHelp.setOnClickListener(listener);
        mTvSignOut.setOnClickListener(listener);
        mTvTerm.setOnClickListener(listener);
    }

    public void setAvatar(Bitmap bmp) {
        if (bmp != null) {
            mCivAvatar.setImageBitmap(bmp);
        }
    }

    public void setUserName(String name) {
        mTvUser.setText(name);
    }

    public void setProgress(int progress, int max) {
        if (mPbUseHour.getMax() != max) {
            mPbUseHour.setMax(max);
        }
        mPbUseHour.setProgress(progress);
    }

    public void setUseHourText(String text) {
        mTvUseHour.setText(text);
    }
}
