package com.mxt.mxt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mxt.mxt.R;
import com.mxt.mxt.util.StatusBarUtils;

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mActivity, MainActivity.class));
                finish();
            }
        }, 2500);
    }

    @Override
    public void setStatusBar() {
        StatusBarUtils.setImmerseFullscreen(getWindow());
    }

    @Override
    public void onBackPressed() {

    }
}
