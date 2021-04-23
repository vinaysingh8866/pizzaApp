package com.jav1001.vinaysingh.pizzzaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<AddElemModel> elemList = new ArrayList<>();
    private AddElemAdapter lAdapter;
    private List<CartElemModel> cartValues ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");


        String imageName = intent.getStringExtra("image");
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        int imgId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+imageName , null, null);




        setContentView(R.layout.activity_main);
        RecyclerView recyclerViewCat = findViewById(R.id.recyclerView);
        lAdapter = new AddElemAdapter(elemList, this.getApplicationContext());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewCat.setLayoutManager(mLayoutManager);
        recyclerViewCat.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCat.setAdapter(lAdapter);

        ImageView imageView = findViewById(R.id.imageMainViewPizza);

        Log.d("imagename", String.valueOf(imgId));
        imageView.setImageResource(imgId);




        prepareData();
    }
    private void prepareData() {
        AddElemModel elem = new AddElemModel("Cheese", "Action & Adventure");
        elemList.add(elem);
        elem = new AddElemModel("Coke", "Animation, Kids & Family");
        elemList.add(elem);
        elem = new AddElemModel("Ketchup", "Action");
        elemList.add(elem);



    }
}