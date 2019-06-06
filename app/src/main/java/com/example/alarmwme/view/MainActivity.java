package com.example.alarmwme.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alarmwme.Injection;
import com.example.alarmwme.R;
import com.example.alarmwme.controller.Controller;
import com.example.alarmwme.model.Food;

import java.util.List;

public class MainActivity extends Activity {

    //Déclaration des variables
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instanciation de recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        controller = new Controller(this, Injection.getRestApi());
        controller.onCreate();
    }

    public void showList(List<Food> foodList) {
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        //Instanciation de layoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        //Instanciation de mAdapter
        mAdapter = new Adapter(foodList);
        recyclerView.setAdapter(mAdapter);
    }
}
