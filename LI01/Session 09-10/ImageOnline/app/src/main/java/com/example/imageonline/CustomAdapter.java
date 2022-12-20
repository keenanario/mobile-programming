package com.example.imageonline;

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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<PhotoData> dataList;
    private Context context;

    public CustomAdapter(Context context, List<PhotoData> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); //persiapan inflate layout
        View view = inflater.inflate(R.layout.custom_row, parent, false); // inflate layout
        return new CustomViewHolder(view); //return hasilnya
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Picasso.Builder pBuilder = new Picasso.Builder(context);
        pBuilder.downloader(new OkHttp3Downloader(context));
        pBuilder.build().load(dataList.get(position).getThumbnailUrl()) //get gambar ke posisi i
                .error(R.drawable.ic_launcher_background) //handle error akan load apa gambarnya
                .placeholder(R.drawable.ic_launcher_background) //sebelum di load tampilkan gambar apa
                .into(holder.imgView); //pasang gambar ke placeholder

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        private ImageView imgView;

        CustomViewHolder(View itemView){
            super(itemView);
            mView = itemView;

            imgView = mView.findViewById(R.id.coverImage);
        }
    }
}
