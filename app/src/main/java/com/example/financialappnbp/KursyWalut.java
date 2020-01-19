package com.example.financialappnbp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class KursyWalut extends AppCompatActivity {

    private ListView list;
    private ListView listCurr;
    private TextView textView3;

    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kursy_walut);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);

        list = (ListView) findViewById(R.id.listViewForSessions);
        String sessions[] = {"Tydzień","Dwa tygodnie","Miesiąc","Kwartał","Półrocze","Rok"};

        ArrayList<String> sessionSelect = new ArrayList<String>();
        sessionSelect.addAll(Arrays.asList(sessions));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sessionSelect);

        list.setAdapter(arrayAdapter);
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
