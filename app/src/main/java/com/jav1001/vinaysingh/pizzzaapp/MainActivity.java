package com.jav1001.vinaysingh.pizzzaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

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
        String price = intent.getStringExtra("price");
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

        TextView nameElem = findViewById(R.id.foodElemNameMain);
        nameElem.setText(name);
        Button addToCart = findViewById(R.id.addToCartMain);
        Button incre = findViewById(R.id.increButtonMain);

        TextView quantity = findViewById(R.id.textViewQuantity);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cartJSON = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("cartitems", "");
                if( cartJSON!=""){
                    try {
                        JSONObject obj = new JSONObject(cartJSON);
                        JSONArray cartItems = obj.getJSONArray("items");
                        JSONObject jj = new JSONObject();
                        jj.put("name",name);
                        jj.put("price",price);
                        jj.put("image",imageName);
                        jj.put("quantity",quantity.getText());
                        cartItems.put(jj);
                        JSONObject tempJ = new JSONObject();
                        tempJ.put("items",cartItems);
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("cartitems", tempJ.toString()).apply();
                        String objJSON = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("cartitems", "");
                        Log.d("json",objJSON);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    JSONObject jj = new JSONObject();
                    JSONArray cartItems = new JSONArray();
                    try {
                        jj.put("name",name);
                        jj.put("price",price);
                        jj.put("image",imageName);
                        jj.put("quantity",quantity.getText());
                        cartItems.put(jj);
                        JSONObject tempJ = new JSONObject();
                        tempJ.put("items",cartItems);
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("cartitems", tempJ.toString()).apply();
                        String objJSON = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("cartitems", "");
                        Log.d("json",objJSON);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }});
        incre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity.setText(Integer.parseInt(quantity.getText().toString())+1+"");
            }
        });
        Button decre = findViewById(R.id.decreButtonMain);
        decre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity.setText(Integer.parseInt(quantity.getText().toString())-1+"");
            }
        });
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