package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatsMenu extends AppCompatActivity
{


    public void goToNextRevSup(View view)
    {
        Intent intent = new Intent(StatsMenu.this, RevenueSupplyMenu.class);

        startActivity(intent);
    }

    public void goToHome(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);
    }

    public void goToBack(View view)
    {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_menu);

        Button expense, revenue;

        expense = findViewById(R.id.button4);
        revenue = findViewById(R.id.button5);

        expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(StatsMenu.this, ExpensesSupplyMenu.class);
                startActivity(intent1);
            }
        });

        revenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(StatsMenu.this, RevenueSupplyMenu.class);
                startActivity(intent2);
            }
        });

    }
}
