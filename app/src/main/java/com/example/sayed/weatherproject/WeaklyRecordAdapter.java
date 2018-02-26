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

public class WeaklyRecordAdapter extends RecyclerView.Adapter<WeaklyRecordAdapter.WeaklyRecordsHolder>{
    private Context context;
    private ArrayList<WeaklyRecord>weaklyRecords;

    public WeaklyRecordAdapter(Context context, ArrayList<WeaklyRecord> weaklyRecords) {
        this.context = context;
        this.weaklyRecords = weaklyRecords;
    }

    @Override
    public WeaklyRecordsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.weakly_record_row, parent, false);

        WeaklyRecordsHolder weaklyRecordsHolder = new WeaklyRecordsHolder(v);
        return weaklyRecordsHolder;
    }

    @Override
    public void onBindViewHolder(WeaklyRecordsHolder holder, int position) {
        holder.dayName.setText(weaklyRecords.get(position).getDayName());
        holder.iconWk.setImageResource(weaklyRecords.get(position).getWeatherIcon());
        holder.temperatureWk.setText(weaklyRecords.get(position).getTemperatureWk());
        holder.humidity.setText(weaklyRecords.get(position).getHumidity());
    }

    @Override
    public int getItemCount() {
        return weaklyRecords.size();
    }

    public class WeaklyRecordsHolder extends RecyclerView.ViewHolder{

        TextView dayName, temperatureWk, humidity;
        ImageView iconWk;

        public WeaklyRecordsHolder(View itemView) {
            super(itemView);
            
            dayName=itemView.findViewById(R.id.weaklyDayNameTV);
            temperatureWk=itemView.findViewById(R.id.weaklyTemperatureTV);
            humidity=itemView.findViewById(R.id.weaklyHumidityTV);
            iconWk=itemView.findViewById(R.id.weaklyIconIV);
            
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Toast.makeText(context, weaklyRecords.get(position).getDayName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
