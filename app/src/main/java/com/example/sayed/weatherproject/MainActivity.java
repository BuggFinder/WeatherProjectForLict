package com.example.sayed.weatherproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "https://api.weatherbit.io/v2.0/forecast/";
    private String urlString;
    private String urlStringForHourly;
    private String initialUrl= "&lat=23.8103&lon=90.4125";

    //for hourly record>>>>>
    private RecyclerView hourlyReportRV;
    private ArrayList<HourlyRecord>hourlyRecords;
    HourlyRecordAdapter hourlyRecordAdapter;

    //for weaklyRecord>>>>
    private RecyclerView weaklyReportRV;
    private ArrayList<WeaklyRecord>weaklyRecords;
    WeaklyRecordAdapter weaklyRecordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //For hourly Adapter
        hourlyReportRV = (RecyclerView) findViewById(R.id.hourlyReportRV);
        hourlyRecords = new ArrayList<>();
        addHourlyData();


        //For weakly Adapter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        weaklyReportRV = (RecyclerView) findViewById(R.id.weaklyRecordRV);
        weaklyRecords = new ArrayList<>();
        addWeaklyData();
    }



    //WeaklyData and set Adapter
    private void addWeaklyData() {
        weaklyRecords.add(new WeaklyRecord("Saturday", R.drawable.sunandcloud, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Sunday", R.drawable.sunicon, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Monday", R.drawable.sunandcloud, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Tuesday", R.drawable.sunandcloud, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Wednesday", R.drawable.sunicon, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Thursday", R.drawable.sunandcloud, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Friday", R.drawable.sunandcloud, "70°", "55°"));

        weaklyRecordAdapter = new WeaklyRecordAdapter(this,weaklyRecords);
        LinearLayoutManager weaklln = new LinearLayoutManager(this);
        weaklln.setOrientation(LinearLayoutManager.VERTICAL);

        weaklyReportRV.setLayoutManager(weaklln);
        weaklyReportRV.setAdapter(weaklyRecordAdapter);
    }


    //Hourly Data and Set Adapter
    private void addHourlyData() {

        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"12 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"1 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"2 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"3 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunandcloud,"4 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"5 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"6 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunandcloud,"7 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"8 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"9 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunandcloud,"10 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunandcloud,"11 AM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"12 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"1 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"2 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"3 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"4 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"5 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"6 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"7 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"8 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"9 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"10 PM", "70°"));
        hourlyRecords.add(new HourlyRecord(R.drawable.sunicon,"11 PM", "70°"));


        hourlyRecordAdapter = new HourlyRecordAdapter(this, hourlyRecords);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);

        GridLayoutManager glm = new GridLayoutManager(this, 2);

        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        hourlyReportRV.setLayoutManager(llm);

        hourlyReportRV.setAdapter(hourlyRecordAdapter);
    }
}
