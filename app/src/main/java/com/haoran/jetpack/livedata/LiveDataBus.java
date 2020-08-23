package com.haoran.jetpack.livedata;


import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

public class LiveDataBus {

    private Map<String, MutableLiveData<Object>> bus;

    private LiveDataBus(){
        bus = new HashMap();
    }

    private static class LiveDataBusHolder{
        private static final LiveDataBus holder = new LiveDataBus();
    }

    public static LiveDataBus getInstance(){
        return LiveDataBusHolder.holder;
    }

    //注册订阅者
    public synchronized <T> MutableLiveData<T> with(String key, Class<T> type) {
        if(!bus.containsKey(key)){
            bus.put(key,new MutableLiveData<Object>());
        }
        return (MutableLiveData<T>)bus.get(key);
    }
}
