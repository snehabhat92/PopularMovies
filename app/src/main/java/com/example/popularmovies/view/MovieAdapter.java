package com.example.popularmovies.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.popularmovies.BR;
import com.example.popularmovies.R;
import com.example.popularmovies.databinding.ItemViewBinding;
import com.example.popularmovies.model.MovieModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    Context mCtx;
    List<MovieModel.Movie> movies;
    private static final String IMAGE_PATH = "https://image.tmdb.org/t/p/w500";

    public MovieAdapter(Context mCtx, List<MovieModel.Movie> movies) {
        this.mCtx = mCtx;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         ItemViewBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_view, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModel.Movie movie = movies.get(position);
        holder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        public ItemViewBinding itemRowBinding;

        ImageView imageView;

        public MovieViewHolder(ItemViewBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }
        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.movie, obj);
            itemRowBinding.executePendingBindings();
        }
    }

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String url) {
        String imageURL = IMAGE_PATH + url;

        Glide.with(view.getContext()).load(imageURL).into(view);
    }
}
