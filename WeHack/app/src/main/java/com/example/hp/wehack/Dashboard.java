package com.example.hp.wehack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard2);

        LinearLayout llStudy = findViewById(R.id.study);
        LinearLayout llSpa = findViewById(R.id.spa);
        LinearLayout llParlour = findViewById(R.id.parlour);
        LinearLayout llRestaurant = findViewById(R.id.restraunt);
        LinearLayout llScience = findViewById(R.id.science);
        LinearLayout llMobileComputing = findViewById(R.id.mobileComputing);
        LinearLayout llMehendi = findViewById(R.id.mehendi);
        LinearLayout llMicrosoft = findViewById(R.id.microsoft);
        LinearLayout llbio = findViewById(R.id.bio);
        LinearLayout llChem = findViewById(R.id.chem);
        LinearLayout llComputer = findViewById(R.id.computer);
        LinearLayout llElectrician = findViewById(R.id.electrician);
        LinearLayout llEmbroidery = findViewById(R.id.embroidery);
        LinearLayout llStitching = findViewById(R.id.Stitching);
        LinearLayout llCooking = findViewById(R.id.cooking);

        llCooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,ListOfVideos.class);
                startActivity(i);
            }
        });


    }
}