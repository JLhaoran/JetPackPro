package com.haoran.jetpack.lifecycle_mvp.model;

import java.util.List;

/**
 * Created by mac on 2019/3/20.
 */

public interface OrderListListenter {
    public void onSuccess(List<OrderListBean.DataBean> datas);
    public void onError();
}
