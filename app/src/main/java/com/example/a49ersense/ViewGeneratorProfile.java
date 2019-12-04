package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
JSONParser jsonParser = new JSONParser();

private static final String url_getGeneratorData = IP_ADDRESS+"/getGeneratorData.php";

public class ViewGeneratorProfile extends AppCompatActivity
{

    loadData getFromDB = new loadData(); // async initialization
    String[] loadGenProf = {"g"}; // Displaying past rev
    TextView dispText; // for displaying stuff from data base graphically


    private class loadData extends AsyncTask<Void, Void, String[]>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String[] doInBackground(Void... args) {
                // Place info here for PhP connections server
                JSONObject json = jsonParser.makeHttpRequest(url_getGeneratorData, "GET");
                
                
                // successfully received product details
                JSONArray generatorObj = json.getJSONArray("details"); // JSON Array
 
                    // looping through All Products
                    for (int i = 0; i < generatorObj.length(); i++) {
                        JSONObject temp = generatorObj.getJSONObject(i);
 
                        // Storing each json item in variable
                        String generatorName = temp.getString("generatorName");
                        String generatorType = temp.getString("generatorType");
                        String powerGenerated = temp.getString("powerGenerated");
                        loadGenProf[(i*3)+0]=generatorName;
                        loadGenProf[(i*3)+1]=generatorType;
                        loadGenProf[(i*3)+2]=powerGenerated;
                    }
                //generatorName
                //generatorType
                //powerGenerated

            return loadGenProf;
        }

        @Override
        protected void onPostExecute(String[] loadGenProf) {
            super.onPostExecute(loadGenProf);
        /*
        String[] pastRev; // Displaying past rev
        TextView dispText; // for displaying stuff from data base graphically
         */
            //String[] pastRev = {"Month", "Amount"};

            // print nicely
            dispText.setText(Arrays.toString(loadGenProf));

        }
    }

    public void goToAllGenOwn(View view)
    {
        loadData getFromDB = new loadData();
        getFromDB.execute();
    }

    public void goToBack(View view)
    {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_generator_profile);
        dispText = findViewById(R.id.textView12);
    }
}
