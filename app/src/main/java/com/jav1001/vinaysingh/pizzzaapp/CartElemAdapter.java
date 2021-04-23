package com.jav1001.vinaysingh.pizzzaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartElemAdapter extends RecyclerView.Adapter<CartElemAdapter.ListViewHolder>{

    private List<CartElemModel> cartElemList;
    private Context context;


    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView itemName, itemPrice,itemQuantity;
        Button increItem, decreItem;
        public ListViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cartfoodhlelem_image);
            itemName = itemView.findViewById(R.id.cartFoodElemName);
            itemPrice = itemView.findViewById(R.id.cartFoodElemPrice);
            itemQuantity = itemView.findViewById(R.id.cartElemQuantity);
            increItem = itemView.findViewById(R.id.carElemIncreButton);
            decreItem = itemView.findViewById(R.id.cartElemDecreButton);
        }
    }

    public CartElemAdapter(List<CartElemModel> elemsList, Context context) {
        this.cartElemList = elemsList;
        this.context = context;
    }




    @NonNull
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_elem_view, parent, false);
        return new ListViewHolder(itemView);
    }

    public void onBindViewHolder(ListViewHolder holder, int position) {

        CartElemModel elem = cartElemList.get(position);
        int id = context.getResources().getIdentifier(elem.getImage(), "drawable", context.getPackageName());
        holder.imageView.setImageResource(id);
        holder.itemName.setText(elem.getName());
        holder.itemPrice.setText(elem.getPrice());
        holder.increItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qua = Integer.parseInt(holder.itemQuantity.getText().toString());
                holder.itemQuantity.setText( ""+(qua+1));
            }
        });

        holder.decreItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qua = Integer.parseInt(holder.itemQuantity.getText().toString());
                if(qua==1){

                    cartElemList.remove(0);

                    //cartElemList.notify();
                }
                else{
                    holder.itemQuantity.setText( ""+(qua-1));
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return cartElemList.size();
    }





}





