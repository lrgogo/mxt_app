package com.mxt.mxt.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.meizu.flyme.reflect.StatusBarProxy;
import com.mxt.mxt.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/28.
 */

public class StatusBarUtils {

    public static void setDarkFont(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams localLayoutParams = activity.getWindow().getAttributes();
        localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        boolean result = false;
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            result = setMiui(window);
        }else if (Build.MANUFACTURER.equalsIgnoreCase("Meizu")){
            result = setFlyme(window);
        }
        if (!result) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //6.0系统
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")){
                    return;
                }
                window.setStatusBarColor(Res.getColor(R.color.bg_gray_light));
            }
        }

    }

    private static boolean setMiui(Window window) {
        boolean result = false;
        Class clazz = window.getClass();
        try {
            int tranceFlag = 0;
            int darkModeFlag = 0;
            Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");

            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT");
            tranceFlag = field.getInt(layoutParams);

            field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);

            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            //只需要状态栏透明
            //extraFlagField.invoke(window, tranceFlag, tranceFlag);

            //状态栏透明且黑色字体
            extraFlagField.invoke(window, tranceFlag | darkModeFlag, tranceFlag | darkModeFlag);

            //清除黑色字体
            //extraFlagField.invoke(window, 0, darkModeFlag);

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean setFlyme(Window window) {
        return StatusBarProxy.setStatusBarDarkIcon(window, true);
    }

}
