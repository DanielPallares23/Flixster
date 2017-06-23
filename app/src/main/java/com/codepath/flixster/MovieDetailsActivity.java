package com.codepath.flixster;

import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    // movie to display
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
        // unwrap the movie passed in via intent, using its simple name as a key
        movie = Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        //Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.));

    }
}
