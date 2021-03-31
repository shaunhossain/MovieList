package com.shaunhossain.movielist.network;

import com.shaunhossain.movielist.model.PostItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("photos")
    Call<List<PostItem>> getPostList();
}
