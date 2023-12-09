package com.example.webservicelh01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webservicelh01.model.FruitModel;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
    List<FruitModel> listFruit;

    public FruitAdapter(List<FruitModel> modelList){
        listFruit = modelList;
    }

    @NonNull
    @Override
    public FruitAdapter.FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View myView = inflater.inflate(R.layout.item_fruit, parent, false);
        FruitViewHolder holder = new FruitViewHolder(myView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.FruitViewHolder holder, int position) {
        FruitModel itemFruit = listFruit.get(position);

        String fruitName = itemFruit.getName();
        int calories = listFruit.get(position).getNutritions().getCalories();
        double sugar = listFruit.get(position).getNutritions().getSugar();

        holder.fruitNameTV.setText(fruitName);
        holder.caloriesTV.setText("Calories: " + calories);
        holder.sugarTV.setText("Sugar: " + sugar);
    }

    @Override
    public int getItemCount() {
        return listFruit.size();
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder{
        TextView fruitNameTV, sugarTV, caloriesTV;
        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitNameTV = itemView.findViewById(R.id.itemFruitNameTV);
            caloriesTV = itemView.findViewById(R.id.itemCaloriesTV);
            sugarTV = itemView.findViewById(R.id.itemSugarTV);
        }
    }
}
