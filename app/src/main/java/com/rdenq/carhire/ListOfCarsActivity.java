package com.rdenq.carhire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;
import retrofit2.internal.EverythingIsNonNull;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.rdenq.carhire.api.ApiClient;
import com.rdenq.carhire.api.ApiInterface;
import com.rdenq.carhire.model.VehAvail;
import com.rdenq.carhire.model.VehVendorAvail;
import com.rdenq.carhire.model.VehicleQueryResponse;

import java.util.ArrayList;
import java.util.List;

public class ListOfCarsActivity extends AppCompatActivity implements VehicleAdapter.ItemClickListener{

    private List<VehicleQueryResponse> mVehicleQueryResponses;
    private List<VehAvail> mListOfVehicles;
    private RecyclerView mRecyclerView;
    private VehicleAdapter mVehicleAdapter;

    private CardView mLegend;
    private TextView mPickUpLocation;
    private TextView mReturnLocation;
    private TextView mPickUpTime;
    private TextView mReturnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_cars);

        mLegend = findViewById(R.id.legend);
        mPickUpLocation = mLegend.findViewById(R.id.pickup_location);
        mReturnLocation = mLegend.findViewById(R.id.return_location);
        mPickUpTime = mLegend.findViewById(R.id.pickup_time);
        mReturnTime = mLegend.findViewById(R.id.return_time);

        mRecyclerView = findViewById(R.id.vehicle_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mVehicleAdapter = new VehicleAdapter(getApplicationContext(), mListOfVehicles);
        mVehicleAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mVehicleAdapter);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<VehicleQueryResponse>> call = apiService.getVehicleQueryResponses();

        call.enqueue(new Callback<List<VehicleQueryResponse>>() {
            @Override
            public void onResponse(@EverythingIsNonNull Call<List<VehicleQueryResponse>> call, Response<List<VehicleQueryResponse>> response) {
                mVehicleQueryResponses = response.body();
                Log.d("TAG_CarHire", "VehicleQuerySuccessResponse = " + response);
                mListOfVehicles = getListOfVehicles(mVehicleQueryResponses);
                mVehicleAdapter.setVehicleList(mListOfVehicles);

                mPickUpLocation.setText(getPickUpLocation(mVehicleQueryResponses));
                mReturnLocation.setText(getReturnLocation(mVehicleQueryResponses));
                mPickUpTime.setText(getPickUpTime(mVehicleQueryResponses));
                mReturnTime.setText(getReturnTime(mVehicleQueryResponses));

            }

            @Override
            public void onFailure(Call<List<VehicleQueryResponse>> call, Throwable t) {
                Log.d("TAG_CarHire", "VehicleQueryFailureResponse = " + t);
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent myIntent = new Intent(ListOfCarsActivity.this, CarActivity.class);
        myIntent.putExtra("key", "13");
        myIntent.putExtra("VEHAVAIL", mVehicleAdapter.getItem(position));
        startActivity(myIntent);
    }

    private List<VehAvail> getListOfVehicles(List<VehicleQueryResponse> vehicleQueryResponses) {
        List<VehAvail> vehicles = new ArrayList<>(1);

        for (VehicleQueryResponse vehicleQueryResponse : vehicleQueryResponses) {
            for (VehVendorAvail vehVendorAvail : vehicleQueryResponse.getVehAvailRSCore().getVehVendorAvails()) {
                for (VehAvail vehAvail : vehVendorAvail.getVehAvails()) {
                    vehAvail.setVendor(vehVendorAvail.getVendor());
                    vehicles.add(vehAvail);
                }
            }
        }
        return vehicles;
    }

    private String getPickUpLocation(List<VehicleQueryResponse> vehicleQueryResponses) {
        String pickUpLocation = "";
        for (VehicleQueryResponse vehicleQueryResponse : vehicleQueryResponses) {
            pickUpLocation =  vehicleQueryResponse.getVehAvailRSCore().getVehRentalCore().getPickUpLocation().getName();
        }
        return pickUpLocation;
    }

    private String getReturnLocation(List<VehicleQueryResponse> vehicleQueryResponses) {
        String returnLocation = "";
        for (VehicleQueryResponse vehicleQueryResponse : vehicleQueryResponses) {
            returnLocation =  vehicleQueryResponse.getVehAvailRSCore().getVehRentalCore().getReturnLocation().getName();
        }
        return returnLocation;
    }

    private String getPickUpTime(List<VehicleQueryResponse> vehicleQueryResponses) {
        String pickUpDate = "";
        for (VehicleQueryResponse vehicleQueryResponse : vehicleQueryResponses) {
            pickUpDate =  vehicleQueryResponse.getVehAvailRSCore().getVehRentalCore().getPickUpDateTime();
        }
        return pickUpDate;
    }

    private String getReturnTime(List<VehicleQueryResponse> vehicleQueryResponses) {
        String returnDate = "";
        for (VehicleQueryResponse vehicleQueryResponse : vehicleQueryResponses) {
            returnDate =  vehicleQueryResponse.getVehAvailRSCore().getVehRentalCore().getReturnDateTime();
        }
        return returnDate;
    }


}
