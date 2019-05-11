package com.test.androidretrofit2example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiUtil.getServiceClass().getAllPost().enqueue(new Callback<List<ApiObject>>() {

            @Override
            public void onResponse(Call<List<ApiObject>> call, Response<List<ApiObject>> response) {
                if(response.isSuccessful()){
                    List<ApiObject> postList = response.body();
                    Log.d(TAG, "Returned count " + postList.size());
                    NewsAdapter adapter = new NewsAdapter(getApplicationContext(), postList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ApiObject>> call, Throwable t) {
                //showErrorMessage();
                Log.d(TAG, "error loading from API");
            }

        });

    }
}
