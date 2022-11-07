package com.binus.pertemuan5recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private MyListData[] listData;

    public MyListAdapter(MyListData[] listData){
        this.listData = listData;
    }

    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        final MyListData myListData = listData[position];
        holder.txtView.setText(listData[position].getDescription());
        holder.imgView.setImageResource(listData[position].getImgId());
        holder.rltvLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), SecondActivity.class);
                i.putExtra("description", myListData.getDescription());
                view.getContext().startActivity(i);

                Toast.makeText(view.getContext(), "click on item: " + myListData.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    //mapping item layout
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgView;
        public TextView txtView;
        public RelativeLayout rltvLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgView = itemView.findViewById(R.id.imageView);
            this.txtView = itemView.findViewById(R.id.textView);
            rltvLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}
