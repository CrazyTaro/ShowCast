package com.showcast.showcast.constant;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by taro on 16/8/15.
 */
public class ConstantView {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = {SHOW_CARD_DATE, SHOW_CARD_SEASON, SHOW_CARD_DETAIL})
    public @interface ShowCardTabType {
    }

    /**
     * tab of show card used for date
     */
    public static final int SHOW_CARD_DATE = 0;
    /**
     * tab of show card used for season
     */
    public static final int SHOW_CARD_SEASON = 1;
    /**
     * tab of show card used for detail
     */
    public static final int SHOW_CARD_DETAIL = 2;
}
