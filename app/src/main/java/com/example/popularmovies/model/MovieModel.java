package com.example.popularmovies.model;

import java.util.List;

public class MovieModel {
   List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "results=" + results +
                '}';
    }

    public class Movie {
        private String poster_path;
        private String title;

        public Movie(String poster_path, String title) {
            this.poster_path = poster_path;
            this.title = title;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "poster_path='" + poster_path + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}


