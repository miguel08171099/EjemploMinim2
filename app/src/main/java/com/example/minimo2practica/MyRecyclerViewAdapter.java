package com.example.minimo2practica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minimo2practica.models.Element;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    List<Element> museumsList = new ArrayList<>();
    Context context;

    public MyRecyclerViewAdapter(List<Element> museumsList, Context context) {
        this.museumsList = museumsList;
        this.context = context;
    }


    @NotNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.txtViewTitle.setText(museumsList.get(position).getAdrecaNom());
        Picasso.get().load(museumsList.get(position).getImatge().get(0)).into(viewHolder.imgViewIcon);
        //viewHolder.txtViewPrice.setText(String.valueOf(productList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return museumsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.textView2);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.imageView);
        }
    }
}