package com.haoran.jetpack.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haoran.jetpack.R;
import com.haoran.jetpack.lifecycle_mvp.adapter.DailyPagerAdapter;
import com.haoran.jetpack.lifecycle_mvp.model.OrderListBean;
import com.haoran.jetpack.lifecycle_mvp.model.OrdersModelImpl;
import com.haoran.jetpack.lifecycle_mvp.presenter.IPresenterImpl;
import com.haoran.jetpack.lifecycle_mvp.presenter.OrdersPresenter;
import com.haoran.jetpack.lifecycle_mvp.view.ISearchView;

import java.util.ArrayList;
import java.util.List;

public class LifecycleActivity extends AppCompatActivity implements ISearchView, View.OnClickListener{
    private RecyclerView mRecyclerView;
    private DailyPagerAdapter mDailyPagerAdapter = null;
    private List<OrderListBean.DataBean> mArrayList = new ArrayList<OrderListBean.DataBean>();
    private Button mSearchBtn = null;
    private Button mCancelBtn = null;
    private OrdersPresenter mIPresenterImpl = null;
    private OrdersModelImpl mOrdersModelImpl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        initView();
        mOrdersModelImpl = new OrdersModelImpl();
//        mIPresenterImpl = new IPresenterImpl(mOrdersModelImpl,this);
        mIPresenterImpl = new OrdersPresenter(mOrdersModelImpl,this);
        //生命周期绑定
        getLifecycle().addObserver(mIPresenterImpl);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                mIPresenterImpl.doSearch();
                break;
            case R.id.btn_search_cancel:
                mIPresenterImpl.cancelSearch();
                break;
        }

    }

    @Override
    public void showResult(List<OrderListBean.DataBean> datas) {
        if(null!=datas)
            setView(datas);
    }

    @Override
    public void cancelShow(List<OrderListBean.DataBean> datas) {
        if(null!=datas)
            setView(datas);
    }

    private void initView(){
        mRecyclerView = findViewById(R.id.pager_shopping_recycler);
        mSearchBtn = findViewById(R.id.btn_search);
        mCancelBtn = findViewById(R.id.btn_search_cancel);

        mSearchBtn.setOnClickListener(this);
        mCancelBtn.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mDailyPagerAdapter = new DailyPagerAdapter(this,mArrayList);
        mRecyclerView.setAdapter(mDailyPagerAdapter);

    }

    private void setView(List<OrderListBean.DataBean> mList){
        if(mArrayList!=null && mArrayList.size()!=0)
        mArrayList.clear();
        Log.d("lhr",">>>>---setView--000-mList.size="+mList.size());
        mArrayList.addAll(mList);
        Log.d("lhr",">>>>---setView--001--mArrayList.size="+mArrayList.size());
        mDailyPagerAdapter.notifyDataSetChanged();
        Log.d("lhr",">>>>---setView---");
    }
}
