package com.shaunhossain.movielist.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.shaunhossain.movielist.R;
import com.shaunhossain.movielist.model.PostItem;
import com.shaunhossain.movielist.network.ApiService;
import com.shaunhossain.movielist.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        makeApiCall();
        return root;
    }

    public void makeApiCall(){
        Log.d("test", "test");
        ApiService apiService = RetrofitInstance.getInterface();
        Call<List<PostItem>> call = apiService.getPostList();

        call.enqueue(new Callback<List<PostItem>>() {
            @Override
            public void onResponse(Call<List<PostItem>> call, Response<List<PostItem>> response) {
                List<PostItem> body = response.body();
                Log.d("Post", String.valueOf(body));
            }

            @Override
            public void onFailure(Call<List<PostItem>> call, Throwable t) {

            }
        });
    }
}