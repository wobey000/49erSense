package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

JSONParser jsonParser = new JSONParser();
private static final String url_getRevenue = "127.0.0.1/getRevenueData.php";

public class PastRevenueMenu extends AppCompatActivity {
    String[] pastRev = {""}; // Displaying past rev
    TextView dispText; // for displaying stuff from data base graphically


    private class loadData extends AsyncTask<Void, Void, String[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String[] doInBackground(Void... args) {
            // Place infro here for PhP connections server

            return pastRev;
        }

        @Override
        protected void onPostExecute(String[] pastRev) {
            super.onPostExecute(pastRev);
        /*
        String[] pastRev; // Displaying past rev
        TextView dispText; // for displaying stuff from data base graphically
         */
            //String[] pastRev = {"Month", "Amount"};

            // print nicely
            dispText.setText(Arrays.toString(pastRev));

        }
    }

    public void goToPastMonthRev(View view)
    {

        loadData getFromDB = new loadData(); // async initialization
        getFromDB.execute();


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
        setContentView(R.layout.activity_past_revenue_menu);
        dispText = findViewById(R.id.textView6);
    }
}
