package com.example.beijingnews.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.beijingnews.base.BaseFragment;
import com.example.beijingnews.utils.LogUtil;

/**
 * left_menu's  fragment
 */
public class LeftMenuFragment extends BaseFragment {

    private TextView textView;

    @Override
    public View initView() {

        LogUtil.e("左侧菜单页面被初始化了");
        textView = new TextView(context);
        textView.setTextSize(24);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("左侧菜单数据被初始化了");
        textView.setText("左侧菜单页面");
    }
}
