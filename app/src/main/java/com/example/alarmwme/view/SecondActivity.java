package com.example.alarmwme.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.alarmwme.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final String SelectedFood = "Le Whisky est en approche";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Information();
    }

    public void Information() {
        TextView regionView = findViewById(R.id.region_detail);
        TextView priceView = findViewById(R.id.price_detail);
        TextView ratingView = findViewById(R.id.rating_detail);

        ArrayList<String> Caracteristique = getIntent().getStringArrayListExtra(SelectedFood);

        regionView.setText(Caracteristique.get(0));
        priceView.setText(Caracteristique.get(1));
        ratingView.setText(Caracteristique.get(2));
    }
}




