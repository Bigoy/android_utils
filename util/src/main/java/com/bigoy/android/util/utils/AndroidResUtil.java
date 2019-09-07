package com.bigoy.android.util.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

@SuppressWarnings("WeakerAccess")
public class AndroidResUtil {

    public static String getString(Context context, @StringRes int resId) {
        return getString(context, resId, null);
    }

    public static String getString(Context context, @StringRes int resId, ResourceProcessor<String> resourceProcessor) {
        String resStr = null;
        if (context != null) {
            resStr = context.getString(resId);
        }
        return resourceProcessor == null ? resStr : resourceProcessor.processResource(resStr);
    }

    public static int getColor(Context context, @ColorRes int resId, Resources.Theme theme, ResourceProcessor<Integer> resourceProcessor) {
        int color = 0;
        if (context != null) {
            Resources r = context.getResources();
            if (Build.VERSION.SDK_INT >= 23) {
                if (theme != null) {
                    color = r.getColor(resId, theme);
                } else {
                    color = r.getColor(resId, null);
                }
            } else {
                color = r.getColor(resId);
            }

            if (resourceProcessor != null) {
                color = resourceProcessor.processResource(color);
            }
        }

        if (color <= 0) {
            throw new IllegalArgumentException("can not found color by the special resId:" + resId);
        }

        return color;
    }

    public static int getColor(Context context, @ColorRes int resId) {
        return getColor(context, resId, null, null);
    }

    public static int getColor(Context context, @ColorRes int resId, ResourceProcessor<Integer> resourceProcessor) {
        return getColor(context, resId, null, resourceProcessor);
    }

    public static int getColor(Context context, @ColorRes int resId, Resources.Theme theme) {
        return getColor(context, resId, theme, null);
    }

}
