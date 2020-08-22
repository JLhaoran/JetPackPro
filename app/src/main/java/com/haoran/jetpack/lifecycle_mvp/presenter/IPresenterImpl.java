package com.haoran.jetpack.lifecycle_mvp.presenter;



import androidx.lifecycle.LifecycleObserver;

import com.haoran.jetpack.lifecycle_mvp.model.OrderListBean;
import com.haoran.jetpack.lifecycle_mvp.model.OrdersModelImpl;
import com.haoran.jetpack.lifecycle_mvp.view.ISearchView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2019/3/22.
 */

public class IPresenterImpl implements IPresenter{
    private OrdersModelImpl mOrdersModelImpl = null;
    private ISearchView mSearchView = null;
    private List<OrderListBean.DataBean> mList = null;


    public IPresenterImpl(final OrdersModelImpl ordersModelImpl,final ISearchView searchView) {
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




}
