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
            AmiibogossYoupi();
        }

        public void AmiibogossYoupi() {
            TextView regionView = findViewById(R.id.amiibogoss_header);
            TextView priceView = findViewById(R.id.amiibogoss_gameseries);
            TextView ratingView = findViewById(R.id.amiibogoss_detail);

            ArrayList<String> AmiibogossFiesta = getIntent().getStringArrayListExtra(SelectedFood);

            regionView.setText(AmiibogossFiesta.get(0));
            priceView.setText(AmiibogossFiesta.get(1));
            ratingView.setText(AmiibogossFiesta.get(2));
        }
    }




