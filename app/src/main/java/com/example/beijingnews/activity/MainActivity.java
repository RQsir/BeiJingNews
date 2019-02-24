package com.example.beijingnews.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.beijingnews.R;
import com.example.beijingnews.utils.DensityUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1.configure main page
        setContentView(R.layout.activity_main);

        // 2.configure leftMenu
        setBehindContentView(R.layout.activity_leftmenu);

        // 3.configure rightMenu
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setSecondaryMenu(R.layout.activity_rightmenu);

        // 4.configure display mode: leftMenu + mainPage; leftMenu + mainPage + rightPage; rightMenu + mainPage
        slidingMenu.setMode(SlidingMenu.LEFT);

        // 5.configure sliding mode: slideMargin, slideFullScreen, noSlide
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        // 6.configure the width of the mainPage while sliding
        slidingMenu.setBehindOffset(DensityUtil.dip2px(MainActivity.this,200));
    }
}
