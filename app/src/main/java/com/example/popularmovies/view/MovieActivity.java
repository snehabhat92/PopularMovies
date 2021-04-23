package com.example.popularmovies.view;

import android.os.Bundle;

import com.example.popularmovies.R;
import com.example.popularmovies.databinding.ActivityMovieBinding;
import com.example.popularmovies.model.MovieModel;
import com.example.popularmovies.viewModel.MovieViewModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private ActivityMovieBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MovieActivity.this, R.layout.activity_movie);
        binding.setLifecycleOwner(this);

        GridLayoutManager layoutManager=new GridLayoutManager(MovieActivity.this,2);
                binding.recyclerview.setLayoutManager(layoutManager);
        initView();
    }

    private void initView() {
        MovieViewModel model = new ViewModelProvider(this).get(MovieViewModel.class);

        model.getMovies().observe(this, new Observer<List<MovieModel.Movie>>() {
            @Override
            public void onChanged(@Nullable List<MovieModel.Movie> movies) {
                adapter = new MovieAdapter(MovieActivity.this, movies);
                binding.recyclerview.setAdapter(adapter);

            }
        });

    }
}
