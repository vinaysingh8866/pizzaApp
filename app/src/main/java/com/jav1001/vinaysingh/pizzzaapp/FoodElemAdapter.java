package com.jav1001.vinaysingh.pizzzaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class FoodElemAdapter extends RecyclerView.Adapter<FoodElemAdapter.ListViewHolder>{
    private static View.OnClickListener clickListener;
    private List<FoodElemModel> elemsList;
    private Context context;
    public static final String cartValues = "cartValues";





    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        ImageView image;
        TextView name,cal,price;
        Button addToCart;
        ListViewHolder(View view) {
            super(view);
            view.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            Log.d("RecyclerView", "onClick：" + elemsList.get(getAdapterPosition()).getName());
                            Intent i = new Intent(v.getContext(), MainActivity.class);
                            i.putExtra("image", elemsList.get(getAdapterPosition()).getImage());
                            i.putExtra("name", elemsList.get(getAdapterPosition()).getName());
                            i.putExtra("price", elemsList.get(getAdapterPosition()).getPrice());
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(i);
                        }
                    }
            );
            image = view.findViewById(R.id.foodhlelem_image);
            name = view.findViewById(R.id.foodElemName);
            cal = view.findViewById(R.id.foodElemCal);
            price = view.findViewById(R.id.foodElemPrice);
            addToCart = view.findViewById(R.id.button2);


        }

        @Override
        public void onClick(View v) {
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }
    public FoodElemAdapter(List<FoodElemModel> elemsList, Context context) {
        this.elemsList = elemsList;
        this.context = context;
    }
    @NonNull

    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_food_selection, parent, false);

        return new ListViewHolder(itemView);
    }

    public void onBindViewHolder(ListViewHolder holder, int position) {

        FoodElemModel elem = elemsList.get(position);

        int id = context.getResources().getIdentifier(elem.getImage(), "drawable", context.getPackageName());
        holder.image.setImageResource(id);
        holder.name.setText(elem.getName());
        holder.price.setText(elem.getPrice());

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("",elem.getName());
                String cartJSON = PreferenceManager.getDefaultSharedPreferences(context).getString("cartitems", "");
                if( cartJSON!=""){
                    try {
                        JSONObject obj = new JSONObject(cartJSON);
                        JSONArray cartItems = obj.getJSONArray("items");
                        JSONObject jj = new JSONObject();
                        jj.put("name",elem.getName());
                        jj.put("price",elem.getPrice());
                        jj.put("image",elem.getImage());
                        jj.put("quantity","1");
                        cartItems.put(jj);
                        JSONObject tempJ = new JSONObject();
                        tempJ.put("items",cartItems);
                        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("cartitems", tempJ.toString()).apply();
                        String objJSON = PreferenceManager.getDefaultSharedPreferences(context).getString("cartitems", "");
                        Log.d("json",objJSON);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    JSONObject jj = new JSONObject();
                    JSONArray cartItems = new JSONArray();
                    try {
                        jj.put("name",elem.getName());
                        jj.put("price",elem.getPrice());
                        jj.put("image",elem.getImage());
                        jj.put("quantity","1");
                        cartItems.put(jj);
                        JSONObject tempJ = new JSONObject();
                        tempJ.put("items",cartItems);
                        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("cartitems", tempJ.toString()).apply();
                        String objJSON = PreferenceManager.getDefaultSharedPreferences(context).getString("cartitems", "");
                        Log.d("json",objJSON);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


            }
        });
    }


    public int getItemCount() {
        return elemsList.size();
    }
}
