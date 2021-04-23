package com.jav1001.vinaysingh.pizzzaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    public List<CartElemModel> cartElemModelList = new ArrayList<CartElemModel>();
    public CartElemAdapter cartElemAdapter;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        sharedpreferences = getSharedPreferences("values", Context.MODE_PRIVATE);






        prepdata();

        RecyclerView cartRecyclerView = findViewById(R.id.cartRecyclerView);
        cartElemAdapter = new CartElemAdapter(cartElemModelList, getApplicationContext());
        LinearLayoutManager cartLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        cartLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartRecyclerView.setLayoutManager(cartLinearLayoutManager);
        cartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        cartRecyclerView.setAdapter(cartElemAdapter);


    }

    private void prepdata() {

        String cartVals = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("cartitems","");
        if(cartVals!=""){
            try {
                JSONObject obj = new JSONObject(cartVals);
                JSONArray cartItems = obj.getJSONArray("items");
                for(int i=0; i<cartItems.length();i++){
                    JSONObject jjj = (JSONObject) cartItems.get(i);

                    Log.d("mmm",jjj.toString());
                    CartElemModel cartElemModel = new CartElemModel(jjj.getString("name"), jjj.getString("price"), jjj.getString("quantity"), jjj.getString("image"));
                    cartElemModelList.add(cartElemModel);

                }
                cartElemAdapter.notifyDataSetChanged();
            }
            catch (Exception e){
                Log.d("mmm",e.getLocalizedMessage());
            }
        }
        else{

            Log.d("mmm","Empty");
        }

    }
}