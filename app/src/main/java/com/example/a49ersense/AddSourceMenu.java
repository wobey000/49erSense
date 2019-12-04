package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;
 // test
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSourceMenu extends AppCompatActivity
{
    Button addSource;
    EditText nameSource, powerSupply, outputWatts;

    // async task for storing

    public void addNewSource(View view)
    {

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
        setContentView(R.layout.activity_add_source_menu);

        addSource = (Button)findViewById(R.id.button11);
        nameSource = (EditText)findViewById(R.id.editText);
        powerSupply = (EditText)findViewById(R.id.editText2);
        outputWatts = (EditText)findViewById(R.id.editText3);

        addSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = nameSource.getText().toString();
                String sPowerSupply = powerSupply.getText().toString();
                String sOutputWatt = outputWatts.getText().toString();
                Toast.makeText(getApplicationContext(), "Source Added Successfully :)", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
