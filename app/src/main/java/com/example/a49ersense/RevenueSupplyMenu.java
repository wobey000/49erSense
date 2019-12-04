package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RevenueSupplyMenu extends AppCompatActivity
{


    public void goToPastRev(View view)
    {
        Intent intent = new Intent(getApplicationContext(), PastRevenueMenu.class);

        startActivity(intent);
    }

    public void goToMonthRev(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MonthlyRev.class);

        startActivity(intent);

        //SQL Database Stuff Ask John For HELP DISPLAYING
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
        setContentView(R.layout.activity_revenue_supply_menu);


    }
}
