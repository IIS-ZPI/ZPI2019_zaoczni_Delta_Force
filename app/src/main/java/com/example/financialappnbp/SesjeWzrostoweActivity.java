package com.example.financialappnbp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class SesjeWzrostoweActivity extends AppCompatActivity {

    private ListView list;
    private ListView listCurr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesje_wzrostowe);

        list = (ListView) findViewById(R.id.listViewForSessions);
        String sessions[] = {"Tydzień","Dwa tygodnie","Miesiąc","Kwartał","Półrocze","Rok"};

        ArrayList<String> sessionSelect = new ArrayList<String>();
        sessionSelect.addAll(Arrays.asList(sessions));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sessionSelect);

        list.setAdapter(arrayAdapter);
    }
}
