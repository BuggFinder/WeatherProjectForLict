package com.example.sayed.weatherproject;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "https://api.weatherbit.io/v2.0/forecast/";
    private String urlString;
    private String urlStringForHourly;
    private String initialUrl= "&lat=23.8103&lon=90.4125";
    /*private String forDhakaUrl = "https://api.weatherbit.io/v2.0/forecast/hourly?&lat=23.810&lon=90.412&key=827ece656f8b49ce8caf7138e44c1af1";*/
    private String forDhakaUrl = "daily?city=dhaka,bd&key=827ece656f8b49ce8caf7138e44c1af1";
    private String forDhakaUrlhr = "hourly?city=dhaka,bd&key=827ece656f8b49ce8caf7138e44c1af1";
    private WeatherServiceAPI weatherServiceAPI;

    //AllViews
    TextView mainTitle;
    TextView averageTemp;

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
        mainTitle = (TextView) findViewById(R.id.mainTitle);
        averageTemp = (TextView) findViewById(R.id.averageTemp);

        checkNetConnect();
        getHourlyData();
        getDailyData();


        //For hourly Adapter
        hourlyReportRV = (RecyclerView) findViewById(R.id.hourlyReportRV);
        hourlyRecords = new ArrayList<>();
        addHourlyData();


        //For weakly Adapter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        weaklyReportRV = (RecyclerView) findViewById(R.id.weaklyRecordRV);
        weaklyRecords = new ArrayList<>();
    }




/*    //WeaklyData and set Adapter
    private void addWeaklyData() {
 *//*       weaklyRecords.add(new WeaklyRecord("Saturday", R.drawable.sunandcloud, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Sunday", R.drawable.sunicon, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Monday", R.drawable.sunandcloud, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Tuesday", R.drawable.sunandcloud, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Wednesday", R.drawable.sunicon, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Thursday", R.drawable.sunandcloud, "70°", "55°"));
        weaklyRecords.add(new WeaklyRecord("Friday", R.drawable.sunandcloud, "70°", "55°"));*//*

        weaklyRecords.add(new WeaklyRecord(0));
        weaklyRecords.add(new WeaklyRecord(1));
        weaklyRecords.add(new WeaklyRecord(2));
        weaklyRecords.add(new WeaklyRecord(3));
        weaklyRecords.add(new WeaklyRecord(4));
        weaklyRecords.add(new WeaklyRecord(5));
        weaklyRecords.add(new WeaklyRecord(6));




        weaklyRecordAdapter = new WeaklyRecordAdapter(this,weaklyRecords);
        LinearLayoutManager weaklln = new LinearLayoutManager(this);
        weaklln.setOrientation(LinearLayoutManager.VERTICAL);

        weaklyReportRV.setLayoutManager(weaklln);
        weaklyReportRV.setAdapter(weaklyRecordAdapter);
    }*/


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

    //Check and Connect To API
    private void checkNetConnect(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo.isConnected() && networkInfo.isAvailable()){
            connectToWeatherAPI();
        }else {
            //TODO: Give A Message TO user
            Toast.makeText(this, "Ne Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    //Connect To API
    private void connectToWeatherAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherServiceAPI = retrofit.create(WeatherServiceAPI.class);
    }
    private void getHourlyData(){

        Call<ForecastWeatherResponse>weatherArrayListCall = weatherServiceAPI.getWeatherForecastResponses(forDhakaUrl);
        weatherArrayListCall.enqueue(new Callback<ForecastWeatherResponse>() {
            @Override
            public void onResponse(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
                if(response.code() == 200){
                                   addWeaklyData(call, response);
                }
            }

            @Override
            public void onFailure(Call<ForecastWeatherResponse> call, Throwable t) {

                Log.d("url", "onResponse: "+t.getMessage());
                onRestart();
;
            }
        });
    }
    public void getDailyData() {



        Call<ForecastWeatherResponse> responseCall = weatherServiceAPI.getWeatherHourForecastResponses(forDhakaUrlhr);
        responseCall.enqueue(new Callback<ForecastWeatherResponse>() {

            @Override
            public void onResponse(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
                ForecastWeatherResponse weatherData = response.body();
                if(response.code() == 200){
     //               addWeaklyData(call, response);
                }
            }
            @Override
            public void onFailure(Call<ForecastWeatherResponse> call, Throwable t) {
                Log.d("url", "onResponse: "+t.getMessage());
                onRestart();
            }
        });
    }

    private void addWeaklyData(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
        ForecastWeatherResponse forecastWeatherResponse = response.body();

        mainTitle.setText(forecastWeatherResponse.getCityName());
        averageTemp.setText(forecastWeatherResponse.getData().get(0).getTemp().toString()+"°C");

        //WeaklyRecordSet
        weaklyRecords.add(new WeaklyRecord(0));
        weaklyRecords.add(new WeaklyRecord(1));
        weaklyRecords.add(new WeaklyRecord(2));
        weaklyRecords.add(new WeaklyRecord(3));
        weaklyRecords.add(new WeaklyRecord(4));
        weaklyRecords.add(new WeaklyRecord(5));
        weaklyRecords.add(new WeaklyRecord(6));
        weaklyRecords.add(new WeaklyRecord(7));


        for (int i=0; i<8; i++){
            weaklyRecords.get(i).setTemperatureWk(forecastWeatherResponse.getData().get(i).getTemp().toString());
  //          weaklyRecords.get(i).setWindSpeed(forecastWeatherResponse.getData().get(i).getWindSpd().toString());
            weaklyRecords.get(i).setWeatherIcon(R.drawable.sunandcloud);
           weaklyRecords.get(i).setWindSpeed(String.valueOf((forecastWeatherResponse.getData().get(i).getWindSpd()*(1000/60)))+"k/hr");

            String dateFromAPI = forecastWeatherResponse.getData().get(i).getDatetime();

            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateFromAPI);
                String dayName = (String) android.text.format.DateFormat.format("EEEE", date);
                weaklyRecords.get(i).setDayName(dayName);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        weaklyRecords.get(0).setDayName("Today");
        weaklyRecords.get(1).setDayName("Tomorrow");


        //Set adapter
        weaklyRecordAdapter = new WeaklyRecordAdapter(this,weaklyRecords);
        LinearLayoutManager weaklln = new LinearLayoutManager(this);
        weaklln.setOrientation(LinearLayoutManager.VERTICAL);

        weaklyReportRV.setLayoutManager(weaklln);
        weaklyReportRV.setAdapter(weaklyRecordAdapter);
    }
}
