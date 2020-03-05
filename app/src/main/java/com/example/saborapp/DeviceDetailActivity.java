package com.example.saborapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DeviceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        String name = getIntent().getStringExtra("listnames");
        TextView textView = findViewById(R.id.textView2);
        textView.setText(name);
    }
}
