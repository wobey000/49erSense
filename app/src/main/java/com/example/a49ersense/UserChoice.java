package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserChoice extends AppCompatActivity
{
    public void gotoGridControl(View view)
    {
        Intent intent = new Intent(getApplicationContext(), GridControllerMenu.class);
        startActivity(intent);
    }

    public void goToSupplier(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);
    }
}
