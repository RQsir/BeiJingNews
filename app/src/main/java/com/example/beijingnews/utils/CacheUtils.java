package com.example.beijingnews.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.beijingnews.SplashActivity;

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
}
