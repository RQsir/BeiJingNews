package com.example.beijingnews.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * base fragment, which will be extended by LeftMenuFragment and ContentFragment
 */
public abstract class BaseFragment extends Fragment {

    public Context context;//MainActivity


    /**
     * invoke when Fragment is being created
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity(); // MainActivity
    }

    /**
     * invoke when view is being created
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();

    }


    /**
     * let child class to implement its own method to satisfy specific needs;
     * @return
     */
    public abstract View initView();

    /**
     * invoke after Activity is created
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    /**
     * if this page has no data, request data by net, then bind itself to initView;
     * else bind itself to initView directly
     *
     */
    public void initData() {

    }
}
