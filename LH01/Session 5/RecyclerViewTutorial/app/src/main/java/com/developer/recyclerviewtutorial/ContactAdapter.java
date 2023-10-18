package com.developer.recyclerviewtutorial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    List<ContactData> contactList;
    Context myContext;

    public ContactAdapter(List<ContactData> contactList){
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //persiapan layout
        myContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View myView = inflater.inflate(R.layout.contact_item_layout, parent, false);
        MyViewHolder myHolder = new MyViewHolder(myView);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.MyViewHolder holder, int position) {
        //load data
        String nama = contactList.get(position).getNama();
        String phone = contactList.get(position).getNoHP();
        int gambar = contactList.get(position).getGambar();

        //tampilkan data ke komponen
        holder.namaTV.setText(nama);
        holder.phoneTV.setText(phone);
        holder.gambarIV.setImageResource(gambar);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:"+ phone);
                //klik untuk pindah ke aplikasi call
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                myContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //load sejumlah data di contactList
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //beri reference terhadap komponen di layout
        ImageView gambarIV;
        TextView namaTV, phoneTV;
        ConstraintLayout container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarIV = itemView.findViewById(R.id.itemGambarIV);
            namaTV = itemView.findViewById(R.id.itemNamaTV);
            phoneTV = itemView.findViewById(R.id.itemPhoneTV);
            container = itemView.findViewById(R.id.itemContainer);
        }
    }
}
