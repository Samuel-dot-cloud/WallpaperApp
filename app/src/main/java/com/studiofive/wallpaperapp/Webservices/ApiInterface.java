package com.studiofive.wallpaperapp.Webservices;

import com.studiofive.wallpaperapp.Models.Collection;
import com.studiofive.wallpaperapp.Models.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("photos")
    Call<List<Photo>> getPhotos(
            @Query("client_id") String key
    );

    @GET("collections/featured")
    Call<List<Collection>> getCollections(
            @Query("client_id") String key
    );

    @GET("collections/{id}")
    Call<Collection> getInformationOfCollection(
            @Path("id") int id,
            @Query("client_id") String key
    );

    @GET("collections/{id}/photos")
    Call<List<Photo>> getPhotosOfCollection(
            @Path("id") int id,
            @Query("client_id") String key
    );
    @GET("photos/{id}")
    Call<Photo> getPhoto(
            @Path("id") String id,
            @Query("client_id") String key
    );
}
