package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

JSONParser jsonParser = new JSONParser();

private static final String url_getLoadProfileData = "127.0.0.1/getLoadProfileData.php";

public class ViewLoadProfile extends AppCompatActivity
{

    String[] loadProf = {""}; // Displaying past rev
    TextView dispText; // for displaying stuff from data base graphically


    private class loadData extends AsyncTask<Void, Void, String[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String[] doInBackground(Void... args) {
                // Place infro here for PhP connections server
                //Requires:
                //	clientName
                //		OR
                //	NONE

                //Returns:
                //	clientName
                //	powerConsumed
                //	powerGenerated

                // getting product details by making HTTP request
                // Note that product details url will use GET request
                JSONObject json = jsonParser.makeHttpRequest(url_getLoadProfileData, "GET");

                
                // successfully received product details
                JSONArray loadProfileObj = json.getJSONArray("details"); // JSON Array
 
                    // looping through All Products
                    for (int i = 0; i < loadProfileObj.length(); i++) {
                        JSONObject temp = loadProfileObj.getJSONObject(i);
 
                        // Storing each json item in variable
                        String clientName = temp.getString("clientName");
                        String powerConsumed = temp.getString("powerConsumed");
                        String powerGenerated = temp.getString("powerGenerated");
                        loadProf[(i*3)+0]=clientName;
                        loadProf[(i*3)+1]=powerConsumed;
                        loadProf[(i*3)+2]=powerGenerated;
                    }
            return loadProf;
        }

        @Override
        protected void onPostExecute(String[] loadProf) {
            super.onPostExecute(loadProf);
        /*
        String[] pastRev; // Displaying past rev
        TextView dispText; // for displaying stuff from data base graphically
         */
            //String[] pastRev = {"Month", "Amount"};

            // print nicely
            dispText.setText(Arrays.toString(loadProf));

        }
    }


    public void goToUsersSupplied(View view)
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
        setContentView(R.layout.activity_view_load_profile);

        dispText = findViewById(R.id.textView13);
    }
}
