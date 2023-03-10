package com.example.androidretrofitapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidretrofitapi.R;
import com.example.androidretrofitapi.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movies;
    private Context context;

    public MovieAdapter(List<Movie> movie, Context context) {
        this.movies = movie;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_title.setText(movies.get(position).getTitle());
        Glide.with(context).load(movies.get(position).getCoverPage()).into(holder.iv_coverPage);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_coverPage;
        private TextView tv_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_coverPage = itemView.findViewById(R.id.iv_coverPage);
            tv_title = itemView.findViewById(R.id.iv_title);
        }
    }
}
