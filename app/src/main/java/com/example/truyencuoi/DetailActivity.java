package com.example.truyencuoi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements SendNoiDung{
    ArrayList<TruyenCuoi> truyenCuoiArrayList = new ArrayList<>();
    String tenTopic;
    TruyenCuoiAdapter truyenCuoiAdapter;
    RecyclerView recyclerView;
    ViewPager2 viewPager2;
    PageViewAdapter pageViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        viewPager2.setVisibility(View.GONE);
        customMenu(tenTopic);




    }

    private void customMenu(String title) {
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_ic);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initView() {
        truyenCuoiArrayList = new ArrayList<>();
        Intent intent = getIntent();
        truyenCuoiArrayList = (ArrayList<TruyenCuoi>) intent.getSerializableExtra("listTruyen");
        tenTopic = intent.getStringExtra("tenList");

        recyclerView = findViewById(R.id.listDetail);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        truyenCuoiAdapter = new TruyenCuoiAdapter(truyenCuoiArrayList,this);
        recyclerView.setAdapter(truyenCuoiAdapter);
        viewPager2 = findViewById(R.id.viewPager2);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            if (viewPager2.isShown()) {
                viewPager2.setVisibility(View.GONE);
            } else {
                finish();
            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager2.isShown()) {
            viewPager2.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void getNoiDung(ArrayList<TruyenCuoi> listTruyen, int position) {
        viewPager2.setVisibility(View.VISIBLE);

        pageViewAdapter = new PageViewAdapter(this,listTruyen);
        viewPager2.setAdapter(pageViewAdapter);
        viewPager2.setCurrentItem(position,false);
    }
}