package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

JSONParser jsonParser = new JSONParser();
private static final String url_getRevenue = "127.0.0.1/getExpensesData.php";

public class ExpensesSupplyMenu extends AppCompatActivity
{
    String[] getExpenses = {""}; // Displaying past rev
    TextView dispText; // for displaying stuff from data base graphically


    private class loadData extends AsyncTask<Void, Void, String[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String[] doInBackground(Void... args) {
            // Place infro here for PhP connections server
                //TODO: get UUID
            return getExpenses;
        }

        @Override
        protected void onPostExecute(String[] pastRev) {
            super.onPostExecute(getExpenses);
        /*
        String[] pastRev; // Displaying past rev
        TextView dispText; // for displaying stuff from data base graphically
         */
            //String[] pastRev = {"Month", "Amount"};

            // print nicely
            dispText.setText(Arrays.toString(getExpenses));

        }
    }



    public void goToExpSup(View view)
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
        setContentView(R.layout.activity_expenses_supply_menu);
        dispText=findViewById(R.id.textView7);
    }
}
