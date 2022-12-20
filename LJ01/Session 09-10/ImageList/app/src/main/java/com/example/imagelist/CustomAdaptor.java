package com.example.imagelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.CustomViewHolder> {
    private List<PhotoData> dataList;
    private Context context;

    public CustomAdaptor(Context context, List<PhotoData> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomAdaptor.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lfInflater = LayoutInflater.from(parent.getContext());
        View view = lfInflater.inflate(R.layout.custom_row, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdaptor.CustomViewHolder holder, int position) {
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background)) //default
                .error(R.drawable.ic_launcher_background) //kalo gagal load apa
                .into(holder.coverImage);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        private ImageView coverImage;

        CustomViewHolder(View viewItem){
            super(viewItem);
            mView = viewItem;

            coverImage = mView.findViewById(R.id.coverImage);
        }
    }
}
