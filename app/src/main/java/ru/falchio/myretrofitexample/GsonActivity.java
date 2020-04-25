package ru.falchio.myretrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class GsonActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gson_activity);

        String json = "{\"time_of_year\": \"summer\", \"year\": 2019}";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Season season = gson.fromJson(json,Season.class);

        Log.d(TAG, "onCreate: " + season.getTimeOfYear() + " " + season.getYear());


    }

    private class  Season{
        @SerializedName("time_of_year")
        private String timeOfYear;
        @SerializedName("year")
        private int year;

        private Season(String timeOfYear, int year){
            this.timeOfYear=timeOfYear;
            this.year=year;
        }

        public String getTimeOfYear() {
            return timeOfYear;
        }

        public void setTimeOfYear(String timeOfYear) {
            this.timeOfYear = timeOfYear;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }
}
