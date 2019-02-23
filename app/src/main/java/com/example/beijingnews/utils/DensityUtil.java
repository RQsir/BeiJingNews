package com.example.beijingnews.utils;

import android.content.Context;

public class DensityUtil {

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     * according to screen's resolution, transfer dp to px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     * according to screen's resolution, transfer px to dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}