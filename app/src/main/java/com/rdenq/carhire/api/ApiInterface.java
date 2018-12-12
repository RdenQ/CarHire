package com.rdenq.carhire.api;

import com.rdenq.carhire.model.VehicleQueryResponse;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

@FunctionalInterface
public interface ApiInterface {
    @GET("cars.json")
    Call<List<VehicleQueryResponse>> getVehicleQueryResponses();
}
