package com.jav1001.vinaysingh.pizzzaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FoodSelection extends AppCompatActivity {

    private List<CatElemModel> catElemList = new ArrayList<CatElemModel>();
    private CatElemadapter catAdapter;



    private List<FoodElemModel> foodElemList = new ArrayList<>();
    private FoodElemAdapter foodElemAdapter;
    private List<CartElemModel> cartValues = new ArrayList<CartElemModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);
        Button cart = findViewById(R.id.cart_button);
        ImageView allFood = findViewById(R.id.allFood);
        ImageView pizza = findViewById(R.id.pizza);
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodElemList.clear();

                FoodElemModel ff = new FoodElemModel("p3","Margherita","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("p1","Margherita","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("p2","Margherita","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("p4","Margherita","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                foodElemAdapter.notifyDataSetChanged();
            }
        });
        allFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodElemList.clear();

                FoodElemModel ff = new FoodElemModel("p3","Margherita","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("p1","Margherita","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("p2","Margherita","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("p4","Margherita","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("burger1","BIG B","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("burger2","Cheese Burger","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("burger3","Cheese Burger","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("burger4","Cheese Burger","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                foodElemAdapter.notifyDataSetChanged();
            }
        });

        ImageView burgers = findViewById(R.id.burger);
        burgers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodElemList.clear();
                FoodElemModel ff = new FoodElemModel("burger1","BIG B","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("burger2","Cheese Burger","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("burger3","Cheese Burger","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                ff = new FoodElemModel("burger4","Cheese Burger","500 gr - 3000cal","$24","~ 15min");
                foodElemList.add(ff);
                foodElemAdapter.notifyDataSetChanged();
            }
        });


        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),Cart.class);
                final Bundle bundle = new Bundle();

                i.putExtra("cartValues",(Serializable) cartValues);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
            }
        });



        RecyclerView catrecyclerView = findViewById(R.id.recyclerViewCat);
        catAdapter = new CatElemadapter(catElemList, this.getApplicationContext());
        LinearLayoutManager catLayoutManager = new LinearLayoutManager(getApplicationContext());
        catLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        catrecyclerView.setLayoutManager(catLayoutManager);
        catrecyclerView.setItemAnimator(new DefaultItemAnimator());
        catrecyclerView.setAdapter(catAdapter);


        RecyclerView recyclerViewFoodElem = findViewById(R.id.recyclerViewFoodItems);
        foodElemAdapter = new FoodElemAdapter(foodElemList, this.getApplicationContext());
        LinearLayoutManager foodElemLayoutManager = new LinearLayoutManager(getApplicationContext());
        foodElemLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFoodElem.setLayoutManager(foodElemLayoutManager);
        recyclerViewFoodElem.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFoodElem.setAdapter(foodElemAdapter);

        prepdata();



    }

    private void prepdata(){
        CatElemModel catelem = new CatElemModel("burger");
        catElemList.add(catelem);
        catelem = new CatElemModel("fastfood");
        catElemList.add(catelem);
        FoodElemModel ff = new FoodElemModel("p1","Margherita","500 gr - 3000cal","$24","~ 15min");
        foodElemList.add(ff);
        ff = new FoodElemModel("p2","Margherita","500 gr - 3000cal","$24","~ 15min");
        foodElemList.add(ff);
        ff = new FoodElemModel("p3","Margherita","500 gr - 3000cal","$24","~ 15min");
        foodElemList.add(ff);
        ff = new FoodElemModel("p4","Margherita","500 gr - 3000cal","$24","~ 15min");
        foodElemList.add(ff);

        catAdapter.notifyDataSetChanged();
        foodElemAdapter.notifyDataSetChanged();

    }
}