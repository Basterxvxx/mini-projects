package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarMain);


        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Food> foods = new ArrayList<>();
        foods.add(new Food("ยำหมูยอ", "เมนูแซ่บ ๆ รสจัดจ้าน",
                "https://img.wongnai.com/p/1920x0/2017/07/29/a969fb6cb6404fbbb4a4596ce65ff9d1.jpg"));
        foods.add(new Food("ส้มตำ", "ตำไทยรสเด็ด เผ็ดจัดจ้าน",
                "https://img.wongnai.com/p/1300x640/2016/11/02/aa74497471c54aeba8eb47a011e1354d.jpg"));
        foods.add(new Food("สตอเบอร์รี่", "ผลไม้รสหวานอมเปรี้ยว",
                "https://img.freepik.com/free-photo/fresh-strawberry-fruit_74190-7613.jpg"));

        adapter = new MyAdapter(foods, this, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Food food) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", food.getName());
                intent.putExtra("desc", food.getDescription());
                intent.putExtra("image", food.getImageUrl());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
