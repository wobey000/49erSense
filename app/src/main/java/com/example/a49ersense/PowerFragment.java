package com.example.a49ersense;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Arrays;

JSONParser jsonParser = new JSONParser();


//TODO: fix php
private static final String url_getGeneratorData = "127.0.0.1/getGeneratorData.php";

public class PowerFragment extends Fragment {
    TextView dispText;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v= inflater.inflate(R.layout.fragment_power, container, false);

        dispText = v.findViewById(R.id.totalCost_textView);

         loadData1 loading = new loadData1();

         loading.execute();

        return v;
    }

    private class loadData1 extends AsyncTask<Void, Void, String[]>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String[] doInBackground(Void... args) {
            // pull Total Cost data from database and put in string array
                
            String[] str={""};
            return str;
        }

        @Override
        protected void onPostExecute(String[] PFGraphs) {

        /*

         */
            String[] pastRev = {"Month", "Amount"};

            // print nicely
            dispText.setText(Arrays.toString(pastRev));

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
            // pull Cost by device data from database
            String[] str={""};
            return str;
        }

        @Override
        protected void onPostExecute(String[] PFGraphs) {
            //super.onPostExecute(PFGraphs);
        /*
        String[] pastRev; // Displaying past rev
        TextView dispText; // for displaying stuff from data base graphically
         */
            String[] pastRev = {"Month", "Amount"};

            // print nicely
            dispText.setText(Arrays.toString(pastRev));

        }
    }



}
