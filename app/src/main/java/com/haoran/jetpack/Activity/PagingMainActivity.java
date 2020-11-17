package com.haoran.jetpack.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.haoran.jetpack.R;
import com.haoran.jetpack.paging.ItemKeyed.ItemKeyedActivity;
import com.haoran.jetpack.paging.PageKeyed.PageKeyedActivity;
import com.haoran.jetpack.paging.positional.PagingActivity;
import com.haoran.jetpack.paging.room.RoomDataActivity;
public class PagingMainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnPositional;
    Button btnItemkeyed;
    Button btnPagekeyed;
    Button btnRoomData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging_main);

        btnPositional = findViewById(R.id.btn_paging_positional);
        btnItemkeyed = findViewById(R.id.btn_itemkeyed);
        btnPagekeyed = findViewById(R.id.btn_pagekeyed);
        btnRoomData = findViewById(R.id.btn_room_data);

        btnPositional.setOnClickListener(this);
        btnItemkeyed.setOnClickListener(this);
        btnPagekeyed.setOnClickListener(this);
        btnRoomData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent mIntent  = new Intent();
        switch (view.getId()){
            case R.id.btn_paging_positional:
                mIntent.setClass(PagingMainActivity.this, PagingActivity.class);
                Log.d("lhr",">>>>>positional-->>>>");
                break;
            case R.id.btn_itemkeyed:
                mIntent.setClass(PagingMainActivity.this, ItemKeyedActivity.class);
                Log.d("lhr",">>>>>itemkeyed-->>>>");

                break;
            case R.id.btn_pagekeyed:
                mIntent.setClass(PagingMainActivity.this, PageKeyedActivity.class);
                Log.d("lhr",">>>>>pagekeyed-->>>>");

                break;
            case R.id.btn_room_data:
                mIntent.setClass(PagingMainActivity.this, RoomDataActivity.class);
                Log.d("lhr",">>>>>room_data-->>>>");
                break;
        }
        startActivity(mIntent);
    }
}