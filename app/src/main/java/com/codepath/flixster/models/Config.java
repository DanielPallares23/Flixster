package com.codepath.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by danielpb on 6/23/17.
 */

public class Config {

    // the base url for loading images
    String imageBaseUrl;
    // the poster size to use when fetching images, part of the url
    String posterSize;

    public String getBackdropSize() {
        return backdropSize;
    }

    // the backdrop size to use when fetching images, part of the url
    String backdropSize;

    public Config (JSONObject object) throws JSONException{
        JSONObject images = object.getJSONObject("images");
        // get the image base url
        imageBaseUrl = images.getString("secure_base_url");
        //Log.d(" anything ", imageBaseUrl);
        // get the poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // use the option at index 3 o-r w342 as a fallback
        posterSize = posterSizeOptions.optString(3, "w342");
        // parse the backdrop sizes and use index 1 or w780 as fallback
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        backdropSize = backdropSizeOptions.optString(1, "w780");
    }

    // helper method for creating url
    public String getImageUrl(String size, String path) {
        return String.format("%s%s%s", imageBaseUrl, size, path); // concatenate all three
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }
}
