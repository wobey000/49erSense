package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity
{
    public void goToNextPower(View view)
    {
        Intent intent = new Intent(getApplicationContext(), PowerSourcesMenu.class);

        startActivity(intent);
    }

    public void goToNextStats(View view)
    {
        Intent intent = new Intent(getApplicationContext(), StatsMenu.class);

        startActivity(intent);
    }

    public void goToUserSelect(View view)
    {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
