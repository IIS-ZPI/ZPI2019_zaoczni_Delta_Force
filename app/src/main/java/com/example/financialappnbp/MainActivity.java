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