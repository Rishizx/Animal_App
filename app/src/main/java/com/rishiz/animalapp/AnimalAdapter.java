package com.rishiz.animalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {
    ArrayList<Animal> animalData;
    Context context;
    MyClickInterface myClickInterface;

    public AnimalAdapter(ArrayList<Animal> animalData, Context context,MyClickInterface myClickInterface){
        this.context=context;
        this.animalData=animalData;
        this.myClickInterface=myClickInterface;
    }

    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.animal_row,parent,false);
        return new AnimalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        holder.animalName.setText(animalData.get(position).getName());
        holder.imgAnimal.setImageResource(animalData.get(position).getImg());
    }

    @Override
    public int getItemCount() { return animalData.size(); }


    class AnimalRowHolder extends RecyclerView.ViewHolder{
       TextView animalName;
       ImageView imgAnimal;
        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);
            animalName=itemView.findViewById(R.id.animal_name);
            imgAnimal=itemView.findViewById(R.id.img_animal);
            itemView.setOnClickListener(view -> myClickInterface.onItemClick(getAdapterPosition()));
        }
    }
    interface  MyClickInterface{
        void onItemClick(int positionOfTheAnimal);
    }
}
