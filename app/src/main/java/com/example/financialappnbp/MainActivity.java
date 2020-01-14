package com.example.financialappnbp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button sesjeWzrostowe = findViewById(R.id.sesjeWzrostowe);
        final Button miaryStatystyczne = findViewById(R.id.miaryStatystyczne);
        final Button kursyWalut = findViewById(R.id.kursyWalut);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // All your networking logic
                // should be here
                URL githubEndpoint = null;
                try {
                    githubEndpoint = new URL("https://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                System.out.println("end point:"+githubEndpoint);
                HttpsURLConnection myConnection =
                        null;
                try {
                    myConnection = (HttpsURLConnection) githubEndpoint.openConnection();
                    System.out.println("open conection ok");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("open conection faild");
                }
                myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");
                myConnection.setRequestProperty("Accept",
                  "application/json");
                //System.out.println("bład:" +myConnection.getResponseMessage());
                try {
                    System.out.println("Kod:"+myConnection.getResponseCode());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (myConnection.getResponseCode() == 200) {
                        // Success
                        // Further processing here
                    } else {
                        // Error handling code goes here
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });





        /*
        InputStream is = new URL("http://api.nbp.pl/api/exchangerates/rates/a/usd/2012-01-01/2012-01-31/?format=jsonhttp://api.nbp.pl/api/exchangerates/rates/a/usd/2012-01-01/2012-01-31/?format=json").openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
        }
        finally {
            is.close();
        }*/

                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                };

                sesjeWzrostowe.setOnClickListener(onClickListener);
                miaryStatystyczne.setOnClickListener(onClickListener);
                kursyWalut.setOnClickListener(onClickListener);

                sesjeWzrostowe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SesjeWzrostoweActivity.class);
                        startActivity(intent);
                    }
                });

                miaryStatystyczne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Miarystatystyczne.class);
                        startActivity(intent);
                    }
                });

        /*
        kursyWalut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, *******.class);
                startActivity(intent);
            }
        });*/
            }
        }