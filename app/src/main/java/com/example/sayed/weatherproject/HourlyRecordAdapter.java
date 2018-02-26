package com.example.sayed.weatherproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nurud on 9/22/2017.
 */

public class HourlyRecordAdapter extends RecyclerView.Adapter<HourlyRecordAdapter.HourlyRecorsHolder>{

    private Context context;
    private ArrayList<HourlyRecord>hourlyRecords;

    public HourlyRecordAdapter (Context context, ArrayList<HourlyRecord> hourlyRecords) {
        this.context = context;
        this.hourlyRecords = hourlyRecords;
    }

    @Override
    public HourlyRecorsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.hourly_record_row, parent, false);

        HourlyRecorsHolder hourlyRecorsHolder = new HourlyRecorsHolder(v);
        return hourlyRecorsHolder;
    }

    @Override
    public void onBindViewHolder(HourlyRecorsHolder holder, int position) {
        holder.timeTV.setText(hourlyRecords.get(position).getTime());
        holder.temperatureTV.setText(hourlyRecords.get(position).getTemperature());
        holder.iconIV.setImageResource(hourlyRecords.get(position).getWeatherImgIcon());
    }

    @Override
    public int getItemCount() {
        return hourlyRecords.size();
    }


    //Holder for Adapter

    public class HourlyRecorsHolder extends RecyclerView.ViewHolder{

        TextView timeTV, temperatureTV;
        ImageView iconIV;

        public HourlyRecorsHolder(View itemView) {
            super(itemView);

            timeTV=itemView.findViewById(R.id.hourlyTimeTV);
            temperatureTV=itemView.findViewById(R.id.hourlyTemperatureTV);
            iconIV=itemView.findViewById(R.id.hourlyIconIV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Toast.makeText(context, hourlyRecords.get(position).getTime(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
