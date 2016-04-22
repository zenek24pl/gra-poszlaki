package com.example.zeno.listav3;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    //deklaracja listview
    private ListView lista;
    //pojemniki do ktorych bedziemy pobierac dane
    private String[] jezyki;
    private String[] odmiany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //przypiecie listview do id :D
        lista = (ListView) findViewById(R.id.lista);

        //wywolanie metody inicjalizujacej obiekty
        initResources();
        //inicjalizacja list view jezykow
        initJezykListview();
    }

    private void initJezykListview() {
        JezykiArrayAdapter adapter=new JezykiArrayAdapter(this,jezyki);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        odmiany[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initResources() {
        Resources res=getResources();
        //pobieramy poprzez get resources nasze stringi
        //get przyjmuje int i zwraca element z danym id

        jezyki=res.getStringArray(R.array.jezyki);
        odmiany=res.getStringArray(R.array.odmiany);
    }



}
