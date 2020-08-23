package com.haoran.jetpack.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.haoran.jetpack.R;
import com.haoran.jetpack.livedata.LiveDataBus;
import com.haoran.jetpack.livedata.NameViewModel;

public class LiveDataActivity extends AppCompatActivity {

    private NameViewModel model;
    private TextView nameTextView;
    private Button btn;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        nameTextView=findViewById(R.id.tvText);
        btn=findViewById(R.id.btn);

        model= ViewModelProviders.of(this).get(NameViewModel.class);

        //需要一个观察者来观察数据
        Observer observer=new Observer<String>(){
            @Override
            public void onChanged(String s) {
                nameTextView.setText(s);
            }
        };


        LiveDataBus.getInstance().with("name",String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                nameTextView.setText(s);
                Log.d("lhr",">>>>----LiveDataBus---");
            }
        });

        //订阅
//        model.getCurrentName().observe(this,observer);

        //方案1 直接使用LiveData
//        btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                String anotherName="lhr"+(i++);
//                model.getCurrentName().setValue(anotherName);
//            }
//        });

        //方案2 使用事件总线
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String anotherName="lhr"+(i++);
//                LiveDataBus.getInstance().with("name",String.class).setValue(anotherName);//主线程执行

                //子线程执行
                new Thread(){
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            String anotherName="子线程 lhr"+(i++);
                            //发送消息
                            LiveDataBus.getInstance().with("name",String.class).postValue(anotherName);
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                        }
                    }
                }.start();


            }
        });

    }
}
