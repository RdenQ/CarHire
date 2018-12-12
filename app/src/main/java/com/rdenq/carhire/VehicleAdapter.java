package com.rdenq.carhire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rdenq.carhire.model.*;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {

    private Context context;
    private List<VehAvail> vehicleList;
    private static ItemClickListener mClickListener;

    public VehicleAdapter(Context context, List<VehAvail> vehicleList) {
        this.context = context;
        this.vehicleList = vehicleList;
    }

    public void setVehicleList(List<VehAvail> vehicleList) {
        this.vehicleList = vehicleList;
        // sort list here by price
        Collections.sort(this.vehicleList, (VehAvail v1, VehAvail v2) -> Float.valueOf(v1.getTotalCharge().getRateTotalAmount()).compareTo(Float.valueOf(v2.getTotalCharge().getRateTotalAmount())));
        notifyDataSetChanged();
    }

    @Override
    public VehicleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vehicle_item, parent, false);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VehicleViewHolder holder, int position) {
        holder.vehicleTitle.setText(vehicleList.get(position).getVehicle().getVehMakeModel().getName());

        holder.numOfPassengers.setText(vehicleList.get(position).getVehicle().getPassengerQuantity());
        holder.numOfBags.setText(vehicleList.get(position).getVehicle().getBaggageQuantity());
        holder.numOfDoors.setText(vehicleList.get(position).getVehicle().getDoorCount());
        holder.fuelType.setText(vehicleList.get(position).getVehicle().getFuelType());

        holder.vendor.setText(vehicleList.get(position).getVendor().getName());
        holder.price.setText(vehicleList.get(position).getTotalCharge().getCurrencyCode() + " " + vehicleList.get(position).getTotalCharge().getRateTotalAmount());

        Picasso.get().load(vehicleList.get(position).getVehicle().getPictureURL()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        if (vehicleList != null) {
            return vehicleList.size();
        }
        return 0;
    }

    public VehAvail getItem(int id) {
        return vehicleList.get(id);
    }

    static class VehicleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView vehicleTitle;

        TextView numOfPassengers;
        TextView numOfBags;
        TextView numOfDoors;
        TextView fuelType;

        TextView vendor;
        TextView price;

        ImageView photo;

        VehicleViewHolder(View itemView) {
            super(itemView);
            vehicleTitle = itemView.findViewById(R.id.make_model_name);

            numOfPassengers = itemView.findViewById(R.id.num_of_passengers);
            numOfBags = itemView.findViewById(R.id.num_of_bags);
            numOfDoors = itemView.findViewById(R.id.num_of_doors);
            fuelType = itemView.findViewById(R.id.fuel_type);

            vendor = itemView.findViewById(R.id.vendor_name);
            price = itemView.findViewById(R.id.price);

            photo = itemView.findViewById(R.id.photo);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    void setClickListener(ItemClickListener itemClickListener) {
        mClickListener = itemClickListener;
    }

    @FunctionalInterface
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
