package com.haoran.jetpack.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameViewModel extends ViewModel{
    private MutableLiveData<String> currentName = null;

    public MutableLiveData<String> getCurrentName(){
        if(currentName==null){
            currentName=new MutableLiveData<>();
        }
        return currentName;
    }
}
