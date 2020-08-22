package com.haoran.jetpack.lifecycle_mvp.presenter;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;

import com.haoran.jetpack.lifecycle_mvp.model.OrderListBean;
import com.haoran.jetpack.lifecycle_mvp.model.OrdersModelImpl;
import com.haoran.jetpack.lifecycle_mvp.view.ISearchView;

import java.util.ArrayList;
import java.util.List;

public class OrdersPresenter extends BasePresenter {

    private OrdersModelImpl mOrdersModelImpl = null;
    private ISearchView mSearchView = null;
    private List<OrderListBean.DataBean> mList = null;


    public OrdersPresenter(final OrdersModelImpl ordersModelImpl,final ISearchView searchView) {
        this.mOrdersModelImpl = ordersModelImpl;
        this.mSearchView = searchView;
        mList = new ArrayList<OrderListBean.DataBean>();
    }

    @Override
    public void doSearch() {
        mList = mOrdersModelImpl.getOrderList();
        mSearchView.showResult(mList);
    }

    @Override
    public void cancelSearch() {
        if(mList!=null)
            mList.clear();
        mSearchView.cancelShow(mList);
    }

    @Override
    void onCreateX(LifecycleOwner owner) {
        super.onCreateX(owner);
        Log.d("lhr",">>>>--onCreateX---");
    }

    @Override
    void onDestory(LifecycleOwner owner) {
        super.onDestory(owner);
        Log.d("lhr",">>>>--onDestory---");
    }
}
