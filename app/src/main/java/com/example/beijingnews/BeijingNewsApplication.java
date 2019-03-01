package com.example.beijingnews;

import android.app.Application;

import org.xutils.x;

/**
 * represents for the whole app
 */
public class BeijingNewsApplication extends Application {

    /**
     * invoke before all modules
     */
    @Override
    public void onCreate() {
        super.onCreate();

        // init xUtils3
        x.Ext.setDebug(true);
        x.Ext.init(this);
    }
}
