package com.example.financialappnbp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Metoda onStart
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


        kursyWalut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KursyWalut.class);
                startActivity(intent);
            }
        });
    }
}