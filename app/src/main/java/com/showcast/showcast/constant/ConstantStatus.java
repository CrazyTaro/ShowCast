package com.showcast.showcast.constant;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by taro on 16/8/15.
 */
public class ConstantStatus {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = {INTENT_SETTING_TYPE_LIVE_CHANNELS, INTENT_SETTING_TYPE_RECORD_PRIORITY, INTENT_SETTING_TYPE_STREAM_APP})
    public @interface SettingType {
    }

    /**
     * live tv channel setting page
     */
    public static final int INTENT_SETTING_TYPE_LIVE_CHANNELS = -1;
    /**
     * stream app setting page
     */
    public static final int INTENT_SETTING_TYPE_STREAM_APP = -2;
    /**
     * record priority setting page
     */
    public static final int INTENT_SETTING_TYPE_RECORD_PRIORITY = -3;

    /**
     * intent key of setting type
     */
    public static final String INTENT_KEY_SETTING_TYPE = "key_setting_type";
}
