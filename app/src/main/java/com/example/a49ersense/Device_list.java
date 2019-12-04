package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

//JSONParser jsonParser = new JSONParser();
//private static final String url_getDevice = "127.0.0.1/getDevice.php";
//private static final String url_newDevice = "127.0.0.1/newDevice.php";

public class Device_list extends AppCompatActivity {
    loadData asyncTask=new loadData();
    storeData storeTask= new storeData();
    Button add, back;
    int success;
    private String m_Text;
    ListView devicelist;
    ProgressBar progressBar;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);
        devicelist = (ListView)findViewById(R.id.device_listView);

        add = (Button)findViewById(R.id.addDev_button);
        back = findViewById(R.id.go_backDev_button);
        asyncTask.execute();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBuild = new AlertDialog.Builder(Device_list.this);
                alertBuild.setTitle("Add Device");
                alertBuild.setMessage("Add name of device");

                final EditText input = new EditText(Device_list.this);
                alertBuild.setView(input);
                alertBuild.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        storeTask = new storeData();
                        m_Text = input.getText().toString();
                        dialog.dismiss();
                        storeTask.execute(m_Text);
                    }
                });

                alertBuild.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertBuild.create();
                alertDialog.show();


            }
        });

    }

    private class loadData extends AsyncTask<Void, Void, String[]> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();


        }

        @Override
        protected String[] doInBackground(Void... args) {
            // need to make connections and pull devices from database
            //String [] devices = {"Device 1", "Device 2"};
                //Requires:
                //	uuid
                //	deviceType
                //Returns:
                //      deviceName
                //      deviceStatus
                //      deviceLocation
  /*
            Global uid = (Global) getApplicationContext();
            int id = uid.getGlobalUUID();
                List<NameValuePair> params = new ArrayList<NameValuePair>();//TODO: import UUID using args[]
                params.add(new BasicNameValuePair("uuid",id));
                params.add(new BasicNameValuePair("deviceType","*");//TODO: import deviceType using args[] or use wildcard (*)
                
                JSONObject json = jsonParser.makeHttpRequest(url_getDevice, "GET",params);

                // successfully received product details
                JSONArray deviceObj = json.getJSONArray("details"); // JSON Array
 
                    // looping through All Products
                    for (int i = 0; i < deviceObj.length(); i++) {
                        JSONObject temp = deviceObj.getJSONObject(i);
 
                        // Storing each json item in variable
                        String deviceName = temp.getString("deviceName");
                        String deviceStatus = temp.getString("deviceStatus");
                        String deviceLocation = temp.getString("deviceLocation");
                        devices[(i*3)+0]=deviceName;
                        devices[(i*3)+1]=deviceStatus;
                        devices[(i*3)+2]=deviceLocaton;
                    }
            */
      // set devices from database to device array
            return devices;
        }

        @Override
        protected void onPostExecute(String[] devices) {
            super.onPostExecute(devices);
            listAdapter = new ArrayAdapter<String>(Device_list.this, android.R.layout.simple_list_item_1, devices);
            devicelist.setAdapter(listAdapter);


        }
    }
    private class storeData extends AsyncTask<String, String, Integer> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }

        @Override
        protected Integer doInBackground(String... args) {
            // Add name of device to database
            //String deviceName = args[0];
                 Global uid = (Global) getApplicationContext();
            int id = uid.getGlobalUUID();
                List<NameValuePair> params = new ArrayList<NameValuePair>();//TODO: import UUID using args[]
                params.add(new BasicNameValuePair("uuid",id));
                params.add(new BasicNameValuePair("deviceType","*");//TODO: import deviceType using args[] or use wildcard (*)
                params.add(new BasicNameValuePair("deviceName",args[0]);
                params.add(new BasicNameValuePair("deviceLocation",args[1]);
                //newDevice.php
                //Requires:
                //	uuid
                //	deviceType
                //	deviceName
                //	deviceLocation
                //	other stuff for Thermostat
                
                JSONObject json = jsonParser.makeHttpRequest(url_newDevice, "POST",params);
            // return success variable
            success = 1;
            return success;
        }

        @Override
        protected void onPostExecute(Integer success) {
            super.onPostExecute(success);

            if (success ==1) {
                asyncTask = new loadData();
                asyncTask.execute();
                Toast.makeText(getApplicationContext(), "Device Added!", Toast.LENGTH_SHORT).show();
            }

            else
                Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_SHORT).show();

        }
    }
}

