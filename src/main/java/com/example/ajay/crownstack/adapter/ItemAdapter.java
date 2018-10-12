package com.example.ajay.crownstack.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ajay.crownstack.ListItemActivity;
import com.example.ajay.crownstack.R;
import com.example.ajay.crownstack.model.Data;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private List<Data> dataList;
    private ListItemActivity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, collectionName, trackTimeMillis;
        public CircleImageView image;

        public MyViewHolder(View view) {
            super(view);
            image = (CircleImageView)view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);
            collectionName = (TextView) view.findViewById(R.id.collectionName);
            trackTimeMillis = (TextView) view.findViewById(R.id.trackTimeMillis);
        }
    }


    public ItemAdapter(ListItemActivity listItemActivity, List<Data> moviesList) {
        this.activity = listItemActivity;
        this.dataList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Data data = dataList.get(position);

        Glide.with(activity).load(data.getArtworkUrl60()).into((holder.image));
        holder.title.setText(String.valueOf(data.getTrackName()));
        holder.collectionName.setText(String.valueOf(data.getCollectionName()));
        holder.trackTimeMillis.setText(String.valueOf(data.getTrackTimeMillis()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
