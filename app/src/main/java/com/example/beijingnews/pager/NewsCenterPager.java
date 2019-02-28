package com.example.beijingnews.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.beijingnews.base.BasePager;
import com.example.beijingnews.utils.LogUtil;

/**
 * homePager 
 */
public class NewsCenterPager extends BasePager {

    public NewsCenterPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();

        LogUtil.e("新闻中心数据初始化了...");

        // 1.set up title
        tv_title.setText("新闻中心");

        // 2.web request to access data, then draw view
        TextView textView = new TextView(context);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);

        // 3.add childView to basePager's FrameLayout
        fl_content.addView(textView);

        // bind data
        textView.setText("新闻中心内容");

    }
}
