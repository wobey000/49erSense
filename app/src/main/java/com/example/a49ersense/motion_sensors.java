package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class motion_sensors extends AppCompatActivity {
        Switch up, main;
        Boolean upState, mainState;
        TextView display;
        Button apply;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_sensors);
        loadData asyncTask=new loadData();

        main= (Switch)findViewById(R.id.mainFloor_switch);
        up = (Switch)findViewById(R.id.upstairsFloor_switch);
        apply = (Button)findViewById(R.id.applymotion_button2);
        display = (TextView)findViewById(R.id.displaymotion_textView);
        progressBar =(ProgressBar) findViewById(R.id.motion_progressBar);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upState = up.isChecked();
                mainState = main.isChecked();

                final Boolean s1 = mainState;
                final Boolean s2 = upState;
                // asyncTask.execute(s1, s2);
                Toast.makeText(getApplicationContext(),"Changes Saved Successfully!", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private class loadData extends AsyncTask<Boolean, String, Void> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar = new ProgressBar(motion_sensors.this);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Boolean... args) {
            //Global uuid = (Global) getApplicationContext();
            //int id = uuid.getGlobalUUID();

            // add states to database


            // if successful return this

            return null;
        }

        @Override
        protected void onPostExecute(Void g) {
            super.onPostExecute(null);
            progressBar.setVisibility(View.INVISIBLE);
            //search database and dispay changes to textview
            Toast.makeText(getApplicationContext(),"Changes Saved Successfully!", Toast.LENGTH_SHORT).show();


        }
    }
}
