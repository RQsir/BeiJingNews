package com.example.beijingnews.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *  custom ViewPager to forbid scrolling
 */
public class NoScrollViewPager extends ViewPager {

    /**
     * use this method when instantiation
     * @param context
     */
    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }

    /**
     * use in Layout, use this constructor when instantiation; it will lead to crash when neglect it;
     * @param context
     * @param attrs
     */
    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * rewrite this method to digest the TouchEvent
     * @param ev
     * @return true means the touchEvent has handled
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }
}
