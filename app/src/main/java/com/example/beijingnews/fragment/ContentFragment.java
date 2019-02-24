package com.example.beijingnews.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.beijingnews.base.BaseFragment;
import com.example.beijingnews.utils.LogUtil;

/**
 * Content's fragment
 */
public class ContentFragment extends BaseFragment {

    private TextView textView;

    @Override
    public View initView() {

        LogUtil.e("正文页面被初始化了");
        textView = new TextView(context);
        textView.setTextSize(24);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("正文数据被初始化了");
        textView.setText("正文页面");
    }
}
