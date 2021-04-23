package com.example.popularmovies.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.popularmovies.R;
import com.example.popularmovies.databinding.ActivityLoginBinding;
import com.example.popularmovies.model.MovieModel;
import com.example.popularmovies.viewModel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        recyclerView=findViewById(R.id.recyclerview);
        GridLayoutManager layoutManager=new GridLayoutManager(MovieActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        /*adapter = new MovieAdapter(MovieActivity.this, new ArrayList<MovieModel.Movie>());
        recyclerView.setAdapter(adapter);*/
        initView();
    }

    private void initView() {
        MovieViewModel model = new ViewModelProvider(this).get(MovieViewModel.class);

        model.getMovies().observe(this, new Observer<List<MovieModel.Movie>>() {
            @Override
            public void onChanged(@Nullable List<MovieModel.Movie> movies) {
                adapter = new MovieAdapter(MovieActivity.this, movies);
                recyclerView.setAdapter(adapter);

            }
        });

    }
}
