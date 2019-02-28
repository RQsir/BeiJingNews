package com.example.beijingnews.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.beijingnews.R;

public class BasePager {

    public Context context;//MainActivity

    /**
     * view that represents different pages
     */
    public View rootView;

    /**
     * represent title
     */
    public TextView tv_title;

    /**
     * represent menu for side_sliding
     */
    public ImageButton ib_menu;

    /**
     * load child pages
     */
    public FrameLayout fl_content;

    public BasePager(Context context) {
        this.context = context;
        this.rootView = initView();
    }

    /**
     *
     * @return view to display
     */
    private View initView() {
        View view = View.inflate(context, R.layout.base_pager,null);

        tv_title = (TextView) view.findViewById(R.id.tv_title);
        ib_menu = (ImageButton) view.findViewById(R.id.ib_menu);
        fl_content = (FrameLayout) view.findViewById(R.id.fl_content);
        return view;
    }

    /**
     * init data; refactor this method when childClass need
     */
    public void initData() {

    }
}
