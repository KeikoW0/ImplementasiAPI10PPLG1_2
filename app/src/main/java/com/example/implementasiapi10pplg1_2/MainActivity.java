package com.example.implementasiapi10pplg1_2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        apiService.getTeams("English Premier League").enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teamList = response.body().getTeams();
                    adapter = new TeamAdapter(MainActivity.this, teamList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }
}
