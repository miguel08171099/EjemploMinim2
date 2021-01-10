package com.example.minimo2practica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.minimo2practica.models.Element;
import com.example.minimo2practica.models.Museums;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIInterface apiIface;
    MyRecyclerViewAdapter adapter;
    List<Element> museumsList = new ArrayList<>();
    Museums museums = new Museums();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        apiIface = APIClient.getClient().create(APIInterface.class);

        Call<Museums> call = apiIface.getMuseums();
        call.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                if (response.isSuccessful()) {
                    Museums museums = response.body();
                    museumsList = museums.getElements();
                    //showProgress( false );
                    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter (new MyRecyclerViewAdapter(museums.getElements(), getApplicationContext()));
                    adapter = new MyRecyclerViewAdapter(museumsList, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<Museums> call, Throwable throwable) {
                call.cancel();
            }
        });
    }
}