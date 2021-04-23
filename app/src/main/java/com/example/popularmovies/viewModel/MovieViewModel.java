package com.example.popularmovies.viewModel;

import android.util.Log;

import com.example.popularmovies.model.MovieModel;
import com.example.popularmovies.view.MovieApi;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieViewModel extends ViewModel {

    private static final String API_KEY = "9a4876fbe8987403c88e44985d66139a";

    public MutableLiveData<List<MovieModel.Movie>> movieList;

    public LiveData<List<MovieModel.Movie>> getMovies() {
        if (movieList == null) {
            movieList = new MutableLiveData<List<MovieModel.Movie>>();
            loadMovies();
        }

        return movieList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApi api = retrofit.create(MovieApi.class);
        Call<MovieModel> call = api.getMovies(API_KEY);


        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                MovieModel movieModel = response.body();
                Log.d("Output", movieModel + "");
                if(movieModel != null && !movieModel.getResults().isEmpty()) {
                    movieList.setValue(movieModel.getResults());
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }
}
