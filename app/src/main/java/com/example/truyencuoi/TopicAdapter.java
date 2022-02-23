package com.example.truyencuoi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.AbstractList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    private AbstractList<Topic> list;
    private Context context;


    public TopicAdapter(AbstractList<Topic> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTen.setText(list.get(position).getTen());
        holder.ivHinh.setImageResource(list.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHinh;
        TextView tvTen;
        SendListTruyen sendListTruyen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHinh = (ImageView) itemView.findViewById(R.id.ivHinh);
            tvTen = (TextView) itemView.findViewById(R.id.tvTen);
            sendListTruyen = (SendListTruyen) context;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    sendListTruyen.getData(list.get(position));
                }
            });
        }
    }
}
