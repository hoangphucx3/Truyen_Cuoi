package com.example.truyencuoi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPageView extends Fragment {
    private TruyenCuoi truyen;

    public FragmentPageView(TruyenCuoi truyen) {
        this.truyen = truyen;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pageview_fragment,container,false);
        TextView tvTenTruyen = view.findViewById(R.id.tvTieuDe);
        TextView tvNoiDung = view.findViewById(R.id.tvNoiDung);
        tvTenTruyen.setText(truyen.getTenTruyen());
        tvNoiDung.setText(truyen.getNoiDung());
        return view;
    }
}
