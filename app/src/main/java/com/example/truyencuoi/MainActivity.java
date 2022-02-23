package com.example.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements SendListTruyen{
    ArrayList<Topic> listTopic;
    RecyclerView recyclerView;
    TopicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideActionBar();
        Page0Fragment page0Fragment = new Page0Fragment();
        showPage0(page0Fragment);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hidePage0(page0Fragment);
            }
        },2000);

        initView();

        String[] mangTenTopic = getResources().getStringArray(R.array.mangTopic);
        String[] mangTenVN = getResources().getStringArray(R.array.mangTopicVN);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.listTopic);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        listTopic = new ArrayList<>();
        addListData();

        adapter = new TopicAdapter(listTopic,this);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<TruyenCuoi> inputFile(String file) {
        String tenFile = file+".txt";
        ArrayList<TruyenCuoi> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        try {
            InputStream inputStream = getAssets().open(tenFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = bufferedReader.readLine())!=null) {
                builder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringTokenizer stringTokenizer = new StringTokenizer(builder.toString(),";");
        while (stringTokenizer.hasMoreTokens()) {
            String s = stringTokenizer.nextToken();
            String str = "";
            if (s.charAt(0)=='\n') {
                str += s.substring(1);
            } else {
                str += s;
            }
            int index = str.indexOf("\n");
            list.add(new TruyenCuoi(str.substring(0,index),str.substring(index+1)));

        }


        return list;
    }

    private void addListData() {
        String[] mangTenTopic = getResources().getStringArray(R.array.mangTopic);
        String[] mangTenVN = getResources().getStringArray(R.array.mangTopicVN);
        for (int i=0;i< mangTenTopic.length;i++) {
            listTopic.add(new Topic(mangTenVN[i],
                    getResources().getIdentifier(mangTenTopic[i],"drawable",getPackageName()),
                    inputFile(mangTenTopic[i])));
        }
    }

    private void hidePage0(Fragment fragment) {
        if (fragment!=null) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    private void showPage0(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.main_layout,fragment,"page0").commit();
    }

    private void hideActionBar() {
        if (getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
    }

    @Override
    public void getData(Topic topic) {
        Intent intent =  new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("listTruyen",topic.getListTruyen());
        intent.putExtra("tenList",topic.getTen());
        startActivity(intent);
    }
}