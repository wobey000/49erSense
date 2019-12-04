package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

public class ViewBusHotspots extends AppCompatActivity
{
    String[] PFGraphs = {"Yes"}; //
    String[] ViewRegionMP = {""}; //
    TextView dispText; // for displaying stuff from data base graphical


    private class loadData1 extends AsyncTask<Void, Void, String[]>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String[] doInBackground(Void... args) {
            // Place infro here for PhP connections server
                //

            return PFGraphs;
        }

        @Override
        protected void onPostExecute(String[] PFGraphs) {
            //super.onPostExecute(PFGraphs);
        /*
        String[] pastRev; // Displaying past rev
        TextView dispText; // for displaying stuff from data base graphically
         */
            //String[] pastRev = {"Month", "Amount"};

            // print nicely
            dispText.setText(Arrays.toString(PFGraphs));

        }
    }

    private class loadData2 extends AsyncTask<Void, Void, String[]>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String[] doInBackground(Void... args) {
            // Place infro here for PhP connections server

            return ViewRegionMP;
        }

        @Override
        protected void onPostExecute(String[] ViewRegionMP) {
            super.onPostExecute(ViewRegionMP);
        /*
        String[] pastRev; // Displaying past rev
        TextView dispText; // for displaying stuff from data base graphically
         */
            //String[] pastRev = {"Month", "Amount"};

            // print nicely
            dispText.setText(Arrays.toString(ViewRegionMP));

        }
    }

    public void goToPowerFlowGraphs(View view)
    {
        /*
        Query:  Search
                Call List(fake list) of things power is going and coming from grid?
                basically list of places the grid controller controls
         */
        loadData1 getFromDBPFG = new loadData1(); // async initialization
        getFromDBPFG.execute();
    }

    public void goToRegionMostPower(View view)
    {
        /*
        Query:  Search
                Call List(fake list) of Regions with Most Power consumption
                from above we have the total list from power flow graphs. We
                are basically taking that list and displaying the places with the highest
                In/Out flow? (I think)
         */
        loadData2 getFromDBViewRegions= new loadData2();
        getFromDBViewRegions.execute();
    }

    public void goToBack(View view)
    {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bus_hotspots);

        dispText = findViewById(R.id.textView10);

    }
}
