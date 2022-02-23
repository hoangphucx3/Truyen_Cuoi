package com.example.truyencuoi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TruyenCuoiAdapter extends RecyclerView.Adapter<TruyenCuoiAdapter.ViewHolder> {
    private ArrayList<TruyenCuoi>  listTruyen;
    private Context context;

    public TruyenCuoiAdapter(ArrayList<TruyenCuoi> listTruyen, Context context) {
        this.listTruyen = listTruyen;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_detail_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTenTruyen.setText(listTruyen.get(position).getTenTruyen());
    }

    @Override
    public int getItemCount() {
        return listTruyen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenTruyen;
        SendNoiDung sendNoiDung;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenTruyen = itemView.findViewById(R.id.tvTenTruyen);
            sendNoiDung = (SendNoiDung) context;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    sendNoiDung.getNoiDung(listTruyen,position);
                }
            });

        }
    }
}
