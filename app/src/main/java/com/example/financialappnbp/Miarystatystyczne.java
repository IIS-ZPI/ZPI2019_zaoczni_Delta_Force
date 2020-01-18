package com.example.financialappnbp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Miarystatystyczne extends AppCompatActivity {

    private ListView list;
    private ListView listCurr;

    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miarystatystyczne);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);



        ListView lv = (ListView) findViewById(R.id.listViewForSessions);
        final TextView tv = (TextView) findViewById(R.id.tv);

        String[] sessions = new String []{"Tydzień","Dwa tygodnie","Miesiąc","Kwartał","Półrocze","Rok"};

        // Create a List from String Array elements
        List<String> session_list = new ArrayList<String>(Arrays.asList(sessions));

        // Create a ArrayAdapter from List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, session_list);

        // Populate ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

        // Set an item click listener for ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display the selected item text on TextView
                tv.setText(selectedItem);
            }
        });
        //list = (ListView) findViewById(R.id.listViewForSessions);


        //ArrayList<String> sessionSelect = new ArrayList<String>();
       // sessionSelect.addAll(Arrays.asList(sessions));

        //final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sessionSelect);

       // list.setAdapter(arrayAdapter);
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
