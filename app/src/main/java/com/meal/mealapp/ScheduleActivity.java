package com.meal.mealapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class ScheduleActivity extends AppCompatActivity {

    String incomingIntentDay;
    CardView breakfast, lunch, dinner;
    TextView calories;
    android.support.v7.widget.Toolbar toolbar;


    private String getTotalCalories() {
        int total = 0;
        int breakfastCal, lunchCal, dinnerCal;

        return Integer.toString(total);
    }

    private void startIntent(String meal) {
        Intent intent = new Intent(this, RecipiesActivity.class);
        intent.putExtra("meal", meal);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        getIncomingIntent();


        toolbar = findViewById(R.id.toolbar);
        breakfast = findViewById(R.id.breakfastCard);
        lunch = findViewById(R.id.lunchCard);
        dinner = findViewById(R.id.dinnerCard);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // what do you want here
                finish();
            }
        });

        calories = findViewById(R.id.caloriesNums);

        calories.setText(getTotalCalories());

        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent("breakfast");

            }
        });

        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent("lunch");
            }
        });

        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent("dinner");
            }
        });


    }


    private void getIncomingIntent() {
        if(getIntent().hasExtra("day")) {
            incomingIntentDay = getIntent().getStringExtra("day");
        }
    }




}
