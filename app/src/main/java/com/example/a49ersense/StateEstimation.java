package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

JSONParser jsonParser = new JSONParser();

private static final String url_getRegionDetails = "127.0.0.1/getRegionDetails.php";

public class StateEstimation extends AppCompatActivity
{


    String[] loadMOR = {""}; // Displaying past rev
    TextView dispText; // for displaying stuff from data base graphically


    private class loadData extends AsyncTask<Void, Void, String[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String[] doInBackground(Void... args) {
                //Requires:
                //	regionName
                //Returns:
                //      locationName
                //      xCoord
                //      yCoord
                //      powerUsage
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("regionName", args[]));//pass region name; TODO: import regionName with args[]
                JSONObject json = jsonParser.makeHttpRequest(url_getRegionDetails, "GET",params);

                
                // successfully received product details
                JSONArray regionData = json.getJSONArray("details"); // JSON Array
 
                    // looping through All Products
                    for (int i = 0; i < regionData.length(); i++) {
                        JSONObject temp = regionData.getJSONObject(i);
 
                        // Storing each json item in variable
                        String locationName = temp.getString("locationName");
                        String xCoord = temp.getString("xCoord");
                        String yCoord = temp.getString("yCoord");
                        String powerUsage = temp.getString("powerUsage");
                        loadMOR[(i*3)+0]=locationName;
                        loadMOR[(i*3)+1]=xCoord;
                        loadMOR[(i*3)+2]=yCoord;
                        loadMOR[(i*4)+3]=powerUsage;
                    }
                
            return loadMOR;
        }

        @Override
        protected void onPostExecute(String[] loadMOR) {
            super.onPostExecute(loadMOR);
        /*
        String[] pastRev; // Displaying past rev
        TextView dispText; // for displaying stuff from data base graphically
         */
            //String[] pastRev = {"Month", "Amount"};

            // print nicely
            dispText.setText(Arrays.toString(loadMOR));

        }
    }

    public void goToMOR(View view) // Goes to Map of Region
    {
        loadData getFromDB = new loadData(); // async initialization
        getFromDB.execute();

    }



    public void goToBack(View view)
    {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_estimation);

        dispText = findViewById(R.id.textView11);
    }
}
