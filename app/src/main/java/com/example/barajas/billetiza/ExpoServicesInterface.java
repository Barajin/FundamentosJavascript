package com.example.barajas.billetiza;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.Call;

public interface ExpoServicesInterface {
    @GET("Expo")
    Call<List<Vitrina>> listVitrinas();
}
