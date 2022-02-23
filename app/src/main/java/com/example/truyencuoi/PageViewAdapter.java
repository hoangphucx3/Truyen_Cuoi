package com.example.truyencuoi;


import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class PageViewAdapter extends FragmentStateAdapter {
    private ArrayList<TruyenCuoi> list;

    public PageViewAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<TruyenCuoi> list) {
        super(fragmentActivity);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return new FragmentPageView(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
