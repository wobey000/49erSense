package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GridControllerMenu extends AppCompatActivity
{
    public void goToBusHotspot(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ViewBusHotspots.class);

        startActivity(intent);
    }

    public void goToStateEstimate(View view)
    {
        Intent intent = new Intent(getApplicationContext(), StateEstimation.class);

        startActivity(intent);
    }

    public void goToViewGenProf(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ViewGeneratorProfile.class);

        startActivity(intent);
    }

    public void goToLoadProf(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ViewLoadProfile.class);

        startActivity(intent);
    }

    public void goToUserSelect(View view)
    {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_controller_menu);
    }
}
