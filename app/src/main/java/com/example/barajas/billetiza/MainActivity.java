package com.example.barajas.billetiza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ExpoServicesInterface service;
    ArrayList<String> ListVitrina;
    RecyclerView recycler1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Retrofrit*/
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://museobillete.azurewebsites.net/api/").addConverterFactory(GsonConverterFactory.create()).build();
        service =retrofit.create(ExpoServicesInterface.class);

        Call<List<Vitrina>> vits = service.listVitrinas();

        vits.enqueue(new Callback<List<Vitrina>>() {
            @Override
            public void onResponse(Call<List<Vitrina>> call, Response<List<Vitrina>> response) {
                int statusCode= response.code();
                List<Vitrina> user=response.body();
            }

            @Override
            public void onFailure(Call<List<Vitrina>> call, Throwable t) {


            }
        });
        /*Retrofit*/
        recycler1=(RecyclerView) findViewById(R.id.RecyclerVitrina);
        recycler1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ListVitrina=new ArrayList<String>();


        AdapterVitrina AdapterVitrina =new AdapterVitrina(ListVitrina);
        recycler1.setAdapter(AdapterVitrina);
    }


}
