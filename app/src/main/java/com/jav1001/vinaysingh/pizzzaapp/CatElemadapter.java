package com.jav1001.vinaysingh.pizzzaapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class CatElemadapter extends RecyclerView.Adapter<CatElemadapter.ListViewHolder> {
    private List<CatElemModel> elemsList;
    private Context context;





    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ListViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.caelem_image);

        }
    }
    public CatElemadapter(List<CatElemModel> elemsList, Context context) {
        this.elemsList = elemsList;
        this.context = context;
    }
    @NonNull

    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_sel, parent, false);
        return new ListViewHolder(itemView);
    }

    public void onBindViewHolder(ListViewHolder holder, int position) {

        CatElemModel elem = elemsList.get(position);

        int id = context.getResources().getIdentifier(elem.getImage(), "drawable", context.getPackageName());

        holder.image.setImageResource(id);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    public int getItemCount() {
        return elemsList.size();
    }
}