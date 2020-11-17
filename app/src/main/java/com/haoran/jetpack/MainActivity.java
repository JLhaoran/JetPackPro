package com.haoran.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.haoran.jetpack.Activity.LifecycleActivity;
import com.haoran.jetpack.Activity.LiveDataActivity;
import com.haoran.jetpack.Activity.NavigationActivity;
import com.haoran.jetpack.Activity.PagingMainActivity;
import com.haoran.jetpack.Activity.RoomActivity;
import com.haoran.jetpack.Activity.ViewModelActivity;
import com.haoran.jetpack.Activity.WorkManagerActivity;
import com.haoran.jetpack.paging.positional.PagingActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Intent mIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLifecycle = findViewById(R.id.btn_lifecycle);
        Button btnLiveData = findViewById(R.id.btn_livedata);
        Button btnNavigation = findViewById(R.id.btn_navigation);
        Button btnRoom = findViewById(R.id.btn_room);
        Button btnWorkManager = findViewById(R.id.btn_workmanager);
        Button btnPaging= findViewById(R.id.btn_paging);

        btnLifecycle.setOnClickListener(this);
        btnLiveData.setOnClickListener(this);
        btnNavigation.setOnClickListener(this);
        btnRoom.setOnClickListener(this);
        btnWorkManager.setOnClickListener(this);
        btnPaging.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mIntent = new Intent();
        switch (view.getId()){
           case R.id.btn_lifecycle:
               mIntent.setClass(MainActivity.this, LifecycleActivity.class);
               System.out.println(">>>>>lifecycle--001-->>>>");
               break;
           case R.id.btn_livedata:
               mIntent.setClass(MainActivity.this, LiveDataActivity.class);
               System.out.println(">>>>>livedata>>>>>");
               break;
           case R.id.btn_navigation:
               mIntent.setClass(MainActivity.this, NavigationActivity.class);
               System.out.println(">>>>>navigation>>>>>");
               break;
           case R.id.btn_room:
               mIntent.setClass(MainActivity.this, RoomActivity.class);
               System.out.println(">>>>>room>>>>>");
               break;
           case R.id.btn_viewmode:
               mIntent.setClass(MainActivity.this, ViewModelActivity.class);
               System.out.println(">>>>>viewmode>>>>>");
               break;
           case R.id.btn_workmanager:
               mIntent.setClass(MainActivity.this, WorkManagerActivity.class);
               System.out.println(">>>>>workmanager>>>>>");
               break;
            case R.id.btn_paging:
                mIntent.setClass(MainActivity.this, PagingMainActivity.class);
                System.out.println(">>>>>PagingActivity>>>>>");
                break;
       }
       startActivity(mIntent);

    }
}
