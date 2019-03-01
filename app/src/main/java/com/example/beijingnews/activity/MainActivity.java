package com.example.beijingnews.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.beijingnews.R;
import com.example.beijingnews.fragment.ContentFragment;
import com.example.beijingnews.fragment.LeftMenuFragment;
import com.example.beijingnews.utils.DensityUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    public static final String MAIN_CONTENT_TAG = "main_content_tag";
    public static final String LEFTMENU_TAG = "leftmenu_tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init SlidingMenu
        initSlidingMenu();

        // init Fragment
        initFragment();
    }

    private void initSlidingMenu() {
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

    private void initFragment() {

        // 1.access FragmentManager
        FragmentManager fm = getSupportFragmentManager();

        // 2.start transaction
        FragmentTransaction ft = fm.beginTransaction();

        // 3.substitution
        ft.replace(R.id.fl_main_content,new ContentFragment(), MAIN_CONTENT_TAG);
        ft.replace(R.id.fl_leftmenu,new LeftMenuFragment(), LEFTMENU_TAG);

        // 4.commit
        ft.commit();
    }

    public LeftMenuFragment getLeftMenuFragment() {

        FragmentManager fm = getSupportFragmentManager();
        LeftMenuFragment leftMenuFragment = (LeftMenuFragment) fm.findFragmentByTag(LEFTMENU_TAG);
        return leftMenuFragment;
    }
}
