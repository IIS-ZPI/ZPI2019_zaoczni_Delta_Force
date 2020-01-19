package com.example.financialappnbp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.financialappnbp.model.Waluta;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class SesjeWzrostoweActivity extends AppCompatActivity {

    private ListView list;
    private ListView listCurr;
    private TextView textView3;

    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    public static String getData(final String url) {
        final CountDownLatch latch = new CountDownLatch(1);
        final String[] outputString = {null};
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                String responseString = null;
                OkHttpGetSender okHttpGetSender = new OkHttpGetSender();
                try {
                    responseString = okHttpGetSender.sendGet(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                outputString[0] = responseString;
                latch.countDown();
            }
        });
        thread.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return outputString[0];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesje_wzrostowe);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);

        textView3 = findViewById(R.id.textView3);

        list = (ListView) findViewById(R.id.listViewForSessions);
        String sessions[] = {"Tydzień","Dwa tygodnie","Miesiąc","Kwartał","Półrocze","Rok"};

        ArrayList<String> sessionSelect = new ArrayList<String>();
        sessionSelect.addAll(Arrays.asList(sessions));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sessionSelect);

        list.setAdapter(arrayAdapter);
    }

    public void onClickPatrykowy(View w) {
        Gson g = new Gson();
        Waluta data = g.fromJson(getData("https://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json"), Waluta.class);

        System.out.println(data);
        textView3.setText("Waluta: " + data.getCurrency().toString() + "Data: " + data.getRates().get(0).getEffectiveDate().toString());
    }

    public void onClickCheckBox1(View v) {
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
    }

    public void onClickCheckBox2(View v) {
            checkBox1.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
    }

    public void onClickCheckBox3(View v) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
    }

    public void onClickCheckBox4(View v) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox5.setChecked(false);
    }

    public void onClickCheckBox5(View v) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
    }

}
