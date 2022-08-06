package com.rishiz.animalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface {
    RecyclerView recyclerView;
    ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        animals=new ArrayList<>();

        animals.add(new Animal("Lion",R.drawable.lion));
        animals.add(new Animal("Tiger",R.drawable.tiger));
        animals.add(new Animal("Gorrila",R.drawable.gorilla));
        animals.add(new Animal("Dove",R.drawable.dove));
        animals.add(new Animal("IceLand",R.drawable.iceland));
        animals.add(new Animal("Parrot",R.drawable.parrot));
        animals.add(new Animal("Cat",R.drawable.cat));

        AnimalAdapter animalAdapter=new AnimalAdapter(animals,this,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalAdapter);

    }

    @Override
    public void onItemClick(int positionOfTheAnimal) {
        Intent intent=new Intent(this,AnimalInfo.class);
        intent.putExtra("image",animals.get(positionOfTheAnimal).getImg());
        intent.putExtra("name",animals.get(positionOfTheAnimal).getName());
        startActivity(intent);

    }
}

