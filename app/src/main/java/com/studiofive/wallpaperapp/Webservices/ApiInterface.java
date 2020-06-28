package com.studiofive.wallpaperapp.Webservices;

import com.studiofive.wallpaperapp.Models.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("photos")
    Call<List<Photo>> getPhotos(
            @Query("client_id") String key
    );
}
