package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

JSONParser jsonParser = new JSONParser();

private static final String url_getDevice = "127.0.0.1/getDevice.php";

public class Locks_Activity extends AppCompatActivity {
    Switch front, back, garage;
    ProgressBar progressBar;
    Boolean frontState ,backState, garageState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locks_);
        Button apply;
        TextView display;


        front = (Switch)findViewById(R.id.frontdoor_switch);
        back = (Switch)findViewById(R.id.backDoor_switch);
        garage = (Switch)findViewById(R.id.garagedoor_switch);
        apply = (Button)findViewById(R.id.apply_button);
        progressBar = (ProgressBar) findViewById(R.id.locks_progressBar);
        progressBar.setVisibility(View.INVISIBLE);


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frontState = front.isChecked();
                backState = back.isChecked();
                garageState = garage.isChecked();
                loadData asyncTask=new loadData();
                Boolean f = frontState;
                Boolean b = backState;
                Boolean g = garageState;
               asyncTask.execute(f, b, g);
                //Toast.makeText(getApplicationContext(),"Changes Saved Successfully!", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private class loadData extends AsyncTask<Boolean, String, Void> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar= new ProgressBar(Locks_Activity.this);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Boolean... args) {
            //updateDevice for 3 locks (front, back, garage)
			
			//TODO: NEEDED VARIABLES
			//UUID - returned to you on login, keep it available always
                //getDevices.php
                //Requires:
                //	uuid
                //	deviceType
                //Returns:
                //      deviceName
                //      deviceStatus
                //      deviceLocation
            Global uuid = (Global) getApplicationContext();
            int id = uuid.getGlobalUUID();

            Boolean device1 = args[0];
            Boolean device2 = args[1];
            Boolean device3 = args[2];

            int deviceStatus1 = device1 ? 1 : 0;
            int deviceStatus2 = device2 ? 1 : 0;
            int deviceStatus3 = device3 ? 1 : 0;

                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("uuid", uuid));
		params.add(new BasicNameValuePair("deviceType", "Lock"));
		params.add(new BasicNameValuePair("deviceName","front door"));
		params.add(new BasicNameValuePair("deviceLocation","1"));
		params.add(new BasicNameValuePair("deviceStatus",deviceStatus1));
                JSONObject json = jsonParser.makeHttpRequest(IP_ADDRESS, "POST", params);
		json = jParser.makeHttpRequest(IP_ADDRESS, "GET", params);
                int success1 = json.getInt("success");//fail if -1
			
			
		params.clear();
		params.add(new BasicNameValuePair("uuid", uuid));
		params.add(new BasicNameValuePair("deviceType", "Lock"));
		params.add(new BasicNameValuePair("deviceName","back door"));
		params.add(new BasicNameValuePair("deviceLocation","1"));
		params.add(new BasicNameValuePair("deviceStatus",deviceStatus2));
		json = jsonParser.makeHttpRequest(IP_ADDRESS, "POST", params);
		json = jParser.makeHttpRequest(IP_ADDRESS, "GET", params);
		int success2 = json.getInt("success");//fail if -1
			
			
                params.clear();
                params.add(new BasicNameValuePair("uuid", uuid));
                params.add(new BasicNameValuePair("deviceType", "Lock"));
                params.add(new BasicNameValuePair("deviceName","garage door"));
                params.add(new BasicNameValuePair("deviceLocation","1"));
                params.add(new BasicNameValuePair("deviceStatus",deviceStatus3));
                json = jsonParser.makeHttpRequest(IP_ADDRESS, "POST", params);
                json = jParser.makeHttpRequest(IP_ADDRESS, "GET", params);
                int success3 = json.getInt("success");//fail if -1
			
                //TODO: Check for success or error
                //if successful, success1 AND success2 AND success3 will all equal 1. Failed = -1 on any of these three.

            return null;
        }

        @Override
        protected void onPostExecute(Void g) {
            super.onPostExecute(null);
            progressBar.setVisibility(View.INVISIBLE);
            //add status to testview
            Toast.makeText(getApplicationContext(),"Changes saved Successfully!", Toast.LENGTH_SHORT).show();


        }
    }
}
