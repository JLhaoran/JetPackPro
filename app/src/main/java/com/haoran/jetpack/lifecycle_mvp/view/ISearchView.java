package com.haoran.jetpack.lifecycle_mvp.view;


import com.haoran.jetpack.lifecycle_mvp.model.OrderListBean;

import java.util.List;

/**
 * Created by mac on 2019/3/22.
 */

public interface ISearchView {
    void showResult(List<OrderListBean.DataBean> data);
    void cancelShow(List<OrderListBean.DataBean> data);
}
