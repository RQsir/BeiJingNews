package com.example.beijingnews.fragment;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.beijingnews.R;
import com.example.beijingnews.base.BaseFragment;
import com.example.beijingnews.utils.LogUtil;

/**
 * Content's fragment
 */
public class ContentFragment extends BaseFragment {

    private ViewPager viewpager;
    private RadioGroup rg_main;


    @Override
    public View initView() {

        LogUtil.e("正文Fragment页面被初始化了");
        View view = View.inflate(context, R.layout.content_fragment,null);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        rg_main = (RadioGroup) view.findViewById(R.id.rg_main);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("正文Fragment数据被初始化了");

        // configure the default selected radiobutton
        rg_main.check(R.id.rb_home);
    }
}
