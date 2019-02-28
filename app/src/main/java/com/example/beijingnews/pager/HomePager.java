package com.example.beijingnews.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.beijingnews.base.BasePager;

/**
 * homePager
 */
public class HomePager extends BasePager {

    public HomePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();

        // 1.set up title
        tv_title.setText("主页面");

        // 2.web request to access data, then draw view
        TextView textView = new TextView(context);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);

        // 3.add childView to basePager's FrameLayout
        fl_content.addView(textView);

        // bind data
        textView.setText("主页面内容");

    }
}
