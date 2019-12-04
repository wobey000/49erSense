package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PowerSourcesMenu extends AppCompatActivity
{
    public void goToAddSource(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AddSourceMenu.class);

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
        setContentView(R.layout.activity_power_sources_menu);
    }
}
