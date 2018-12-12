package com.rdenq.carhire;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.rdenq.carhire.model.VehAvail;
import com.squareup.picasso.Picasso;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class CarActivity extends AppCompatActivity {

    private VehAvail mVehAvail;
    private TextView vehicleTitle;
    private TextView numOfPassengers;
    private TextView numOfBags;
    private TextView numOfDoors;
    private TextView fuelType;
    private TextView vendor;
    private TextView price;
    private TextView transmission;
    private TextView airCon;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        Intent intent = getIntent();
        mVehAvail  =  (VehAvail) intent.getSerializableExtra("VEHAVAIL");

        vehicleTitle = findViewById(R.id.make_model_name);
        vendor = findViewById(R.id.vendor_name);
        price = findViewById(R.id.price);
        photo = findViewById(R.id.photo);
        numOfPassengers = findViewById(R.id.num_of_passengers);
        numOfBags = findViewById(R.id.num_of_bags);
        numOfDoors = findViewById(R.id.num_of_doors);
        fuelType = findViewById(R.id.fuel_type);
        transmission = findViewById(R.id.transmission);
        airCon = findViewById(R.id.airCon);

        if (mVehAvail != null) {
            vehicleTitle.setText(mVehAvail.getVehicle().getVehMakeModel().getName());
            vendor.setText(mVehAvail.getVendor().getName());
            price.setText(mVehAvail.getTotalCharge().getCurrencyCode() + " " + mVehAvail.getTotalCharge().getRateTotalAmount());
            numOfPassengers.setText(mVehAvail.getVehicle().getPassengerQuantity());
            numOfBags.setText(mVehAvail.getVehicle().getBaggageQuantity());
            numOfDoors.setText(mVehAvail.getVehicle().getDoorCount());
            fuelType.setText(mVehAvail.getVehicle().getFuelType());
            transmission.setText(mVehAvail.getVehicle().getTransmissionType());
            airCon.setText(mVehAvail.getVehicle().getAirConditionInd());
            Picasso.get().load(mVehAvail.getVehicle().getPictureURL()).into(photo);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            setTitle(R.string.title_activity_car);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
