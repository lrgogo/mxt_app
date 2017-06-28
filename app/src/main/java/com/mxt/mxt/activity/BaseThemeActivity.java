package com.mxt.mxt.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mxt.mxt.util.StatusBarUtils;

/**
 * Created by Administrator on 2017/6/27.
 */

public class BaseThemeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
    }

    public void setStatusBar(){
        StatusBarUtils.setDarkFont(mActivity);
    }
}
