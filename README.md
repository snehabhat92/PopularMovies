# PopularMovies

Screen1:

1. Form contains two text fields : one is email and other one is password

2. Password size is between 6 - 12 characters

3. Submit button is enabled only in case of email & password are valid otherwise it will be disabled

4. Once Submit button is active move to movie screen without any Remote API Call.

Screen2:

1. Using Restful Web APIs, loaded the list of popular Movies on this screen in a grid view with number of columns as 2.

2. Each Item contains the name and image. Name is taken from the “title” and image from “poster_path” from the response.

 
For Screen 2, created a free account on https://www.themoviedb.org and used their APIs to load the list of Popular Movies.

https://developers.themoviedb.org/3/movies/get-popular-movies
