package com.example.beijingnews.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.beijingnews.R;
import com.example.beijingnews.SplashActivity;
import com.example.beijingnews.utils.CacheUtils;
import com.example.beijingnews.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {

    private static final String TAG = GuideActivity.class.getSimpleName();
    private ViewPager viewpager;
    private Button btn_enter_main;
    private LinearLayout ll_point_group;
    private ImageView iv_red_point;

    private List<ImageView> imageViews;
    /**
     * the distance between two red points
     */
    private int leftMax;
    private int pxValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        btn_enter_main = (Button) findViewById(R.id.btn_enter_main);
        ll_point_group = (LinearLayout) findViewById(R.id.ll_point_group);
        iv_red_point = (ImageView) findViewById(R.id.iv_red_point);

        //prepare data
        int[] ids = new int[] {
                R.drawable.guide_1,
                R.drawable.guide_2,
                R.drawable.guide_3
        };
        pxValue = DensityUtil.dip2px(GuideActivity.this,10);

        imageViews = new ArrayList<ImageView>();
        for (int i=0; i<ids.length; i++){
            ImageView imageView = new ImageView(this);

            // set bg
            imageView.setBackgroundResource(ids[i]);

            // add to imageViews
            imageViews.add(imageView);

            // create point
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);
            /**
             * unit is pixel, need to fit in later
             */
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(pxValue,pxValue);
            if(i != 0){
                params.leftMargin = pxValue;
            }
            point.setLayoutParams(params);
            // add to LinearLayout
            ll_point_group.addView(point);

        }

        // configure ViewPager's adaptor
        viewpager.setAdapter(new MyPagerAdaptor());

        // according to view's lifecycle, values such as width,height,and margin
        // of view can all be accessing when view runs into onLayout or onDraw
        iv_red_point.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());

        // get the sliding percentage of screen
        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());

        // invoke when the btn_enter_main is pressed
        btn_enter_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1.storage the cache whether had entered the main page
                CacheUtils.putBoolean(GuideActivity.this, SplashActivity.ENTER_MAIN, true);

                // 2.jump to the main page
                Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);

                // 3.close the guide page
                finish();
            }
        });
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /**
         * invoke when the page is scrolled
         * @param position position of the page
         * @param positionOffset the offset percentage of the scrolled page
         * @param positionOffsetPixels
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            // sliding distance of 2 redPoint = positionOffset * max distance of 2 redPoint
            int leftMargin = (int) (positionOffset * leftMax);
//            Log.e(TAG,"position=="+position+",positionOffset=="+positionOffset+",positionOffsetPixels=="+positionOffsetPixels+",leftMax=="+leftMax);

            // coordinate of sliding red point = the position of initial point + sliding distance
            leftMargin = (int) (position * leftMax + positionOffset * leftMax);

            // params.leftMargin = coordinate of sliding red point
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv_red_point.getLayoutParams();
            params.leftMargin = leftMargin;
            iv_red_point.setLayoutParams(params);
        }

        /**
         * invoke when the page is selected
         * @param position the position of the selected page
         */
        @Override
        public void onPageSelected(int position) {

            if(position == imageViews.size()-1){
                // when the last page is selected, show the btn_enter
                btn_enter_main.setVisibility(View.VISIBLE);
            }else{
                // other pages
                btn_enter_main.setVisibility(View.GONE);
            }
        }

        /**
         * invoke when the position of the scrolled page changed
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener{

        @Override
        public void onGlobalLayout() {
            // listener will execute one more time, have to remove it manually
            iv_red_point.getViewTreeObserver().removeGlobalOnLayoutListener(this);

            // margin of the red point = the 2th black point position - the 1th black point position
            leftMax  = ll_point_group.getChildAt(1).getLeft() - ll_point_group.getChildAt(0).getLeft();
        }
    }

    class MyPagerAdaptor extends PagerAdapter{

        /**
         *
         * @return  return the total counts of the data
         */
        @Override
        public int getCount() {
            return imageViews.size();
        }

        /**
         *
         * @param view  current viewpager
         * @param o  the return value of instantiateItem
         * @return
         */
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

            return view == o;
        }

        /**
         * get view
         * @param container viewpager
         * @param position
         * @return  return the values related to page
         */
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            ImageView imageView = imageViews.get(position);
            // add to container
            container.addView(imageView);
            return imageView;
//            return super.instantiateItem(container, position);
        }


        /**
         * destroy page
         * @param container   viewpager
         * @param position  the position of page to be destroyed
         * @param object    the page to be destroyed
         */
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }


    }

}
