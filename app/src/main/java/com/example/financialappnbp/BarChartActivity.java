package com.example.financialappnbp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BarChartActivity extends AppCompatActivity {

    SharedPreferences pref;
    List<Float> ratesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        BarChart chart = findViewById(R.id.barchart);

        pref = getApplicationContext().getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        if (pref != null) {
            Gson gson = new Gson();
            Float[] rates = gson.fromJson(pref.getString("rates", null), Float[].class);
            if (ratesList != null) {
                ratesList = new ArrayList<>(Arrays.asList(rates));
            }
        }
        if (ratesList == null) {
            ratesList = new ArrayList<>();
            System.out.println(pref.getString("rates", null));
        }

        System.out.println(ratesList);

        ArrayList rateList = new ArrayList();
        ArrayList<String> year = new ArrayList();
        int i=0;
        for (Float rate: ratesList) {
            rateList.add(new BarEntry(rate, i));
            year.add(String.valueOf(i));
            i++;
        }

        BarDataSet bardataset = new BarDataSet(rateList, "Rates");
        chart.animateY(2000);
        BarData data = new BarData(year, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
        chart.setDescription("");
    }
}
