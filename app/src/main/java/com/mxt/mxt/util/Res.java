package com.mxt.mxt.util;

import android.support.annotation.ColorRes;

import com.mxt.mxt.App;

/**
 * Created by Administrator on 2017/6/28.
 */

public class Res {

    public static int getColor(@ColorRes int id){
        return App.getContext().getResources().getColor(id);
    }

}
