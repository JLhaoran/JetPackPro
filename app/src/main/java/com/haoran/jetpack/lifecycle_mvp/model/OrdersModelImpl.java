package com.haoran.jetpack.lifecycle_mvp.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by mac on 2019/3/20.
 */

public class OrdersModelImpl implements OrdersModel {
    public static final String BASE_URL = "http://mock.fulingjie.com/mock-android/";
    private List<OrderListBean.DataBean> mFruitList = new ArrayList<OrderListBean.DataBean>();

    @Override
    public List<OrderListBean.DataBean> getOrderList() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //获取接口实例
        RetrofitService service = retrofit.create(RetrofitService.class);
        //调用方法得到一个Call
        Call<OrderListBean> call = service.getOrderList();
        //进行网络请求
        call.enqueue(new Callback<OrderListBean>() {
            @Override
            public void onResponse(Call<OrderListBean> call, Response<OrderListBean> response) {
                try {
                    String message = response.body().getMessage();
                    Log.d("rrcc",">>>>>-message---="+message);
                    if (null != message && message.equals("OK")) {
                        mFruitList.clear();
                        mFruitList.addAll(response.body().getData());
                        Log.d("rrcc",">>>>>-OK--onFailure----mFruitList="+mFruitList.size());
                    }
                   } catch (Exception e){
                    e.printStackTrace();
                }
             
            }

            @Override
            public void onFailure(Call<OrderListBean> call, Throwable t) {
                t.printStackTrace();
                Log.d("rrcc",">>>>>---onFailure----");
            }
        });
        return mFruitList;
    }
}
