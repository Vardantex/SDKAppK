package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView citiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citiesList = findViewById(R.id.citiesList);

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Zurich");
        cities.add("New York");
        cities.add("Berlin");
        cities.add("Moscow");
        cities.add("Modrid");

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cities );

        citiesList.setAdapter(citiesAdapter);

        //make a item click listener
        cities.onItemClickListener(AdapterView<?> parent,)

    }

}