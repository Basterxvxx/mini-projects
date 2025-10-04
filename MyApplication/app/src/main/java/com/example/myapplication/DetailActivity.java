package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // ✅ setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // ปุ่ม Back
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        // ✅ UI ส่วนเนื้อหา
        ImageView imageView = findViewById(R.id.detailImage);
        TextView textName = findViewById(R.id.detailName);
        TextView textDesc = findViewById(R.id.detailDesc);

        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");
        String image = getIntent().getStringExtra("image");

        textName.setText(name);
        textDesc.setText(desc);
        Glide.with(this).load(image).into(imageView);
    }
}
