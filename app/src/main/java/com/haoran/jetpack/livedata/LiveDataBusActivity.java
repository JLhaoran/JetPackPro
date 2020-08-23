package com.haoran.jetpack.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.TextView;

import com.haoran.jetpack.R;

public class LiveDataBusActivity extends AppCompatActivity {
    TextView textView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_bus);

        textView = findViewById(R.id.tv_liveDataBus_Text);


        LiveDataBusX.getInstance().with("data",String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });


    }
}
