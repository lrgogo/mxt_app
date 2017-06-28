package com.mxt.mxt.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mxt.mxt.component.TaskManager;

/**
 * Created by Administrator on 2017/6/27.
 */

public class BaseActivity extends AppCompatActivity {

    protected BaseActivity mActivity;
    protected TaskManager mTaskManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mTaskManager = new TaskManager();
    }

    public TaskManager getTaskManager() {
        return mTaskManager;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTaskManager.onDestroy();
    }

}
