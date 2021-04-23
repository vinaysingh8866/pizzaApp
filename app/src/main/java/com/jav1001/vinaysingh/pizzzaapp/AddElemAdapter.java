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

public class AddElemAdapter extends RecyclerView.Adapter<AddElemAdapter.ListViewHolder> {
    private List<AddElemModel> elemsList;
    private Context context;





    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        ListViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.hlelem_text);
            image = view.findViewById(R.id.hlelem_image);

        }
    }
    public AddElemAdapter(List<AddElemModel> elemsList, Context context) {
        this.elemsList = elemsList;
        this.context = context;
    }
    @NonNull

    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_hlist, parent, false);
        return new ListViewHolder(itemView);
    }

    public void onBindViewHolder(ListViewHolder holder, int position) {
        AddElemModel elem = elemsList.get(position);
        holder.name.setText(elem.getName());
        holder.image.setImageDrawable((Drawable) context.getResources().getDrawable(R.drawable.cheese));

    }


    public int getItemCount() {
        return elemsList.size();
    }
}
