package com.example.beijingnews.fragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.beijingnews.R;
import com.example.beijingnews.base.BaseFragment;
import com.example.beijingnews.base.BasePager;
import com.example.beijingnews.pager.GovaffairPager;
import com.example.beijingnews.pager.HomePager;
import com.example.beijingnews.pager.NewsCenterPager;
import com.example.beijingnews.pager.SettingPager;
import com.example.beijingnews.pager.SmartServicePager;
import com.example.beijingnews.utils.LogUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Content's fragment
 */
public class ContentFragment extends BaseFragment {

    @ViewInject(R.id.viewpager)
    private ViewPager viewpager;

    @ViewInject(R.id.rg_main)
    private RadioGroup rg_main;

    private ArrayList<BasePager> basePagers;

    @Override
    public View initView() {

        LogUtil.e("正文Fragment页面被初始化了");
        View view = View.inflate(context, R.layout.content_fragment,null);

        // let ContentFragment.this associated with view by injecting view into framework
        x.view().inject(ContentFragment.this,view);
//        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
//        rg_main = (RadioGroup) view.findViewById(R.id.rg_main);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("正文Fragment数据被初始化了");

        // init 5 child viewPagers
        basePagers = new ArrayList<>();
        basePagers.add(new HomePager(context));
        basePagers.add(new NewsCenterPager(context));
        basePagers.add(new SmartServicePager(context));
        basePagers.add(new GovaffairPager(context));
        basePagers.add(new SettingPager(context));

        // configure the default selected radiobutton
        rg_main.check(R.id.rb_home);

        viewpager.setAdapter(new ContentFragmentAdaptor());
    }

    class ContentFragmentAdaptor extends PagerAdapter {

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return o == view;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            BasePager basePager = basePagers.get(position);
            View rootView = basePager.rootView;
            container.addView(rootView);
            // manually invoke initData()
            basePager.initData();
            return rootView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
