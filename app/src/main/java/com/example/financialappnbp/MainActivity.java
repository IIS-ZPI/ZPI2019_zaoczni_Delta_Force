package com.example.financialappnbp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Metoda onStart
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//komentarz2
        setContentView(R.layout.activity_main);
        Math math = new Math();//komentarz
        System.out.println("dodawanie"+math.Addition(5,2));
        System.out.println("odejmowanie"+math.Difference(6,2));
        System.out.println("dzielenie"+math.Division(2,3));// displaying division 
        System.out.println("mnozenie"+math.Multiplication(8,3));//komentarz3

    }
}
