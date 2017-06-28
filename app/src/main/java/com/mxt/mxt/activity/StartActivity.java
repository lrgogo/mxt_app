package com.mxt.mxt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mxt.mxt.R;

public class StartActivity extends BaseThemeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(mActivity, MainActivity.class));
            }
        }, 2500);
    }
}
