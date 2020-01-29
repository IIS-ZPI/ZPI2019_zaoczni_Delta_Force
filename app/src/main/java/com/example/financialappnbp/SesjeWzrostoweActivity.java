package com.example.financialappnbp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.financialappnbp.model.KursWaluty;
import com.example.financialappnbp.model.Waluta;
import com.github.mikephil.charting.charts.BarChart;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

public class SesjeWzrostoweActivity extends AppCompatActivity {

    private ListView list;
    private ListView listCurr;
    public Boolean Usd=false, Gbp=false, Eur=false, Chf=false, Ru=false;
    Boolean ma=false;
    Boolean wz=false;
    Boolean st=false;
    public String currency;
    public Date date;
    public String url;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String selectedItem;
    Button patrykowy;
    Button btnBarChart;
    int malejace, stale, wzrostowe;
    public TextView growth, constant, decreasing;

    public static String getData(final String url) {
        final CountDownLatch latch = new CountDownLatch(1);
        final String[] outputString = {null};
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
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
        BarChart barChart = (BarChart) findViewById(R.id.barchart);
        btnBarChart = findViewById(R.id.btnBarChart);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        final Button patrykowy = (Button)findViewById(R.id.button);
        patrykowy.setEnabled(false);

        btnBarChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(SesjeWzrostoweActivity.this, BarChartActivity.class);
                startActivity(I);
            }
        });

        ListView lv = (ListView) findViewById(R.id.listViewForSessions);
        final TextView tv2 = (TextView) findViewById(R.id.tv2);

        String[] sessions = new String []{"Tydzień","Dwa tygodnie","Miesiąc","Kwartał","Półrocze","Rok"};

        // Create a List from String Array elements
        List<String> session_list = new ArrayList<String>(Arrays.asList(sessions));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, session_list);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) parent.getItemAtPosition(position);
               if(Usd || Gbp || Eur || Chf || Ru){

                   patrykowy.setEnabled(true);
                  tv2.setText(selectedItem);
               }
             else{
              }

            }
        });
    }

    public void onClickPatrykowy(View w) {
        Gson g = new Gson();
        if (Usd == true) {
            currency = "usd";

        } else if (Gbp == true) {
            currency = "gbp";
        } else if (Eur == true) {
            currency="eur";
        } else if (Chf==true){
            currency="chf";
        } else if(Ru==true) {
            currency="ru";
        }
        else {

        }

        String dateToday = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        if(selectedItem=="Tydzień") //ostatne tydzien
        {
            c.add(Calendar.WEEK_OF_MONTH, -1);
        }
        else if(selectedItem=="Dwa tygodnie") //ostatne 2 tyg
        {
            c.add(Calendar.WEEK_OF_MONTH, -2);
        }
        else if(selectedItem=="Miesiąc")  //ostatni miesiąć
        {
            c.add(Calendar.MONTH, -1);
        }
        else if(selectedItem=="Kwartał") //ostatni kwartał
        {
            c.add(Calendar.MONTH, -3);
        }
        else if(selectedItem=="Półrocze") // ostatnie pół roku
        {
            c.add(Calendar.MONTH, -6);
        }
        else if(selectedItem=="Rok")// ostatni rok
        {
            c.add(Calendar.YEAR, -1);
        }
        else {

        }

        Date currentDatePlusOne = c.getTime();
        String dateFrom=dateFormat.format(currentDatePlusOne);
        String date=dateFrom+"/"+dateToday;
        System.out.println("dateFrom"+dateFrom);

        url=("https://api.nbp.pl/api/exchangerates/rates/c/"+currency+"/"+date+"/?format=json");
        System.out.println("url"+url);
        List<Float> lista = new ArrayList<Float>();
        int i=0;
        Waluta data = g.fromJson(getData(url), Waluta.class);
        malejace=0; wzrostowe=0; stale=0;
        for (KursWaluty waluty : data.getRates()){
            System.out.println(waluty.getAsk()+  " + ");
            lista.add(waluty.getAsk());
            if(lista.size()>1) {
                if(lista.get(lista.size()-1)<lista.get(lista.size()-2)) {
                    wz=false;
                    st=false;
                    if(ma!=true){
                        ma=true;
                    malejace++;}
                }
                else if(lista.get(lista.size()-1)>lista.get(lista.size()-2)) {
                    st=false;
                    ma=false;
                }
                    if(wz!=true){
                        wz=true;
                    wzrostowe++;
                }
                else if(lista.get(lista.size()-1)==lista.get(lista.size()-2)) {
                    wz=false;
                    ma=false;
                        if(st!=true){
                            st=true;
                            stale++;
                    }
                }
            }
            i++;
            }
        TextView constant=(TextView) findViewById(R.id.constant);
        TextView growth=(TextView) findViewById(R.id.growth);
        TextView decreasing=(TextView) findViewById(R.id.decreasing);
        constant.setText("Stałe: "+stale);
        decreasing.setText("Malejące: "+malejace);
        growth.setText("Wzrostowe: "+wzrostowe);
        
        }

        // String data1 = getData("https://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json");
        //textview3.setText(data.getCurrency().toString());


    public void onClickCheckBox1(View v) {
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
            Usd=true;
            Gbp=false;
            Eur=false;
            Chf=false;
            Ru=false;

    }

    public void onClickCheckBox2(View v) {
            checkBox1.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
            Usd=false;
            Gbp=true;
            Eur=false;
            Chf=false;
            Ru=false;
    }

    public void onClickCheckBox3(View v) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
            Usd=false;
            Gbp=false;
            Eur=true;
            Chf=false;
            Ru=false;
    }

    public void onClickCheckBox4(View v) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox5.setChecked(false);
            Usd=false;
            Gbp=false;
            Eur=false;
            Chf=true;
            Ru=false;
    }

    public void onClickCheckBox5(View v) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            Usd=false;
            Gbp=false;
            Eur=false;
            Chf=false;
            Ru=true;
    }

}
