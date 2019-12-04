package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

public class Thermostat extends AppCompatActivity {
    Switch mode_main, mode_up, operate_main, operate_up;
    Boolean mMode_state, uMode_state, mOperate_state, uOperate_state;
    Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat);
        loadData asyncTask=new loadData();
        //Global uuid = (Global) getApplicationContext();
        //int id = uuid.getGlobalUUID();

        mode_up =(Switch)findViewById(R.id.tempmode_switch1);
        mode_main = (Switch)findViewById(R.id.tempmode_switch2);
        operate_up= (Switch)findViewById(R.id.operate_switch1);
        operate_main = (Switch)findViewById(R.id.operate_switch2);

        apply = (Button)findViewById(R.id.applytemp_button);


        apply.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
               mMode_state = mode_main.isChecked();
               uMode_state = mode_up.isChecked();
               mOperate_state = operate_main.isChecked();
               uOperate_state = operate_up.isChecked();

               final Boolean mm = mMode_state;
               final Boolean um = uMode_state;
               final Boolean mo = mOperate_state;
               final Boolean uo = uOperate_state;
            }
        });
    }

    private class loadData extends AsyncTask<Boolean, String, Void> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Boolean... args) {
          //  Global uuid = (Global) getApplicationContext();
            //int id = uuid.getGlobalUUID();

            // add states to database


            // if successful return this

            return null;
        }

        @Override
        protected void onPostExecute(Void g) {
            super.onPostExecute(null);
            //search database and dispay changes to textview
            Toast.makeText(getApplicationContext(),"Changes Saved Successfully!", Toast.LENGTH_SHORT).show();


        }
    }
}
