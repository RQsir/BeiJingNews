package com.example.beijingnews.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.beijingnews.SplashActivity;
import com.example.beijingnews.activity.GuideActivity;

/**
 * storage some cache and parameter for app
 */
public class CacheUtils {

    /**
     * accessing the cache
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {

        SharedPreferences sp = context.getSharedPreferences("example", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    /**
     * storage the cache if the user had entered the app
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {

        SharedPreferences sp = context.getSharedPreferences("example", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }
}
