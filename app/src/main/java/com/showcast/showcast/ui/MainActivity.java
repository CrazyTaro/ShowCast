package com.showcast.showcast.ui;

import android.os.Bundle;

import com.showcast.showcast.R;
import com.showcast.showcast.base.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
