package com.shaunhossain.movielist.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASE_URL = "https://jsonplaceholder.typicode.com/";  //https://jsonplaceholder.typicode.com/photos


    public static OkHttpClient getIntercepterClient() {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();


            return client;

    }

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getIntercepterClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService getInterface() {
        return retrofit.create(ApiService.class);
    }
}
