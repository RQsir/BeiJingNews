package com.example.beijingnews.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.beijingnews.activity.MainActivity;
import com.example.beijingnews.base.BasePager;
import com.example.beijingnews.domain.NewsCenterPagerBean;
import com.example.beijingnews.fragment.LeftMenuFragment;
import com.example.beijingnews.utils.Constants;
import com.example.beijingnews.utils.LogUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


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

        // web request to access data
        getDataFromNet();

    }


    /**
     * web request by xUtils3
     */
    private void getDataFromNet() {

        RequestParams params = new RequestParams(Constants.NEWSCENTER_PAGER_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                LogUtil.e("请求网络成功" + result);
                processData(result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                LogUtil.e("请求网络失败" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

                LogUtil.e("请求网络-onCancelled" + cex.getMessage());
            }

            @Override
            public void onFinished() {

                LogUtil.e("请求网络-onFinished");
            }
        });
    }


    /**
     *  parse json and display
     * @param json
     */
    private void processData(String json) {

        NewsCenterPagerBean bean = parseJson(json);
        String title = bean.getData().get(0).getChildren().get(1).getTitle();
        LogUtil.e("parse json by Gson:"+title);

        // deliver data to LeftMenu
        // 1.get LeftMenuFragment
        MainActivity mainActivity = (MainActivity) context;
        LeftMenuFragment leftMenuFragment = mainActivity.getLeftMenuFragment();

        // 2.set data
        leftMenuFragment.setData(bean.getData());
    }

    /**
     * parse json: 1.use system API ;
     *             2.use third-party framework such as Gson or FastJson;
     * @param json
     * @return
     */
    private NewsCenterPagerBean parseJson(String json) {

        Gson gson = new Gson();
        NewsCenterPagerBean bean = gson.fromJson(json,NewsCenterPagerBean.class);
        return bean;
    }
}
