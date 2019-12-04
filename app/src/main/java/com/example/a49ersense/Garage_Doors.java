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

public class Garage_Doors extends AppCompatActivity {

    Switch garage1, garage2;
    Boolean g1State ,g2State;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage__doors);
        final loadData asyncTask=new loadData();
        Button apply;
        TextView display;
        progressBar = (ProgressBar) findViewById(R.id.garage_progressBar);
        progressBar.setVisibility(View.INVISIBLE);



        garage1 = (Switch)findViewById(R.id.gDoor1_switch);
        garage2 = (Switch)findViewById(R.id.gDoor2_switch);
        apply = (Button)findViewById(R.id.applygarage_button);


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                g1State = garage1.isChecked();
                g2State = garage2.isChecked();

                final Boolean g1 = g1State;
                final Boolean g2 = g2State;
               // asyncTask.execute(g1, g2);
                Toast.makeText(getApplicationContext(),"Changes Saved Successfully!", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private class loadData extends AsyncTask<Boolean, String, Void> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar = new ProgressBar(Garage_Doors.this);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Boolean... args) {
            //updateDevice.php
            //Global uid = (Global) getApplicationContext();
            //int id = uid.getGlobalUUID();
			/*
            List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			//TODO: NEEDED VARIABLES
			//uuid - int, holds the id returned on login
			int uuid = id;//TODO
			params.add(new BasicNameValuePair("uuid", uuid));
			
			//deviceName - string, name of the garage door
			String deviceName = args[0];//TODO
			params.add(new BasicNameValuePair("deviceName", deviceName));
			
			//deviceStatus - string or int (your choice), 1/0 (closed/open)
			String deviceStatus = args[1];
			params.add(new BasicNameValuePair("deviceStatus",deviceStatus));
			
            
			params.add(new BasicNameValuePair("deviceType", "GarageDoor"));
			params.add(new BasicNameValuePair("deviceLocation","1"));
			
            JSONObject json = jsonParser.makeHttpRequest(IP_ADDRESS, "POST", params);
			json = jParser.makeHttpRequest(IP_ADDRESS, "GET", params);
            int success = json.getInt("success");//fail if -1
			
			
			
            // if successful return this
*/
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
