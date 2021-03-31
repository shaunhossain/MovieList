package com.shaunhossain.movielist.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class IntercepterClient {
    public OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        return client;
    }
}
