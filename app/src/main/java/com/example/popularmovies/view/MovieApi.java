package com.example.popularmovies.view;

import com.example.popularmovies.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
        String BASE_URL = "https://api.themoviedb.org/3/movie/";

        @GET("popular")
        Call<MovieModel> getMovies(@Query("api_key") String api_key);

}
