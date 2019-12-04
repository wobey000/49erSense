package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    loadData asyncTask=new loadData();
    ProgressBar progressBar;
    EditText usern, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button loginButt = (Button) findViewById(R.id.login);
        final Button create = (Button)findViewById(R .id.createacctButton);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        //progressBar.setVisibility(View.INVISIBLE);
        usern =(EditText)findViewById(R.id.username_editText);
        pass =(EditText)findViewById(R.id.password_editText);
        int place = 1;
       // MyTask myTask = new MyTask();
        //myTask.execute();



        loginButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = usern.getText().toString();
                String p = pass.getText().toString();
                asyncTask.execute(u,p);


            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(MainActivity.this, CreateAccount.class);
                    startActivity(Intent1);


            }
        });


    }

    private class loadData extends AsyncTask<String, Void, Integer> {

        Global userid = ((Global)getApplicationContext());
        Global acctType= ((Global)getApplicationContext());

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar = new ProgressBar(MainActivity.this);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(String... args) {
                
            // check username and password
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            //TODO: NEEDED VARIABLES
            //username - string
            String username = args[0];
            params.add(new BasicNameValuePair("username", username));

            //password - string
            String password = args[1];
            params.add(new BasicNameValuePair("password", password));

        USE mydb;
        UPDATE message FROM pitable WHERE id = 1;

            //send params for DB Query
			JSONObject json = jsonParser.makeHttpRequest(IP_ADDRESS, "POST", params);
			
			//get response from DB
			json = jParser.makeHttpRequest(IP_ADDRESS, "GET", params);
			
			int success = json.getInt("success");
                        int uuid = json.getInt("uuid");
			int aType = json.getInt("accountType");

			String accountType = aType.toString();

            userid.setGlobalUUID(uuid);
            acctType.setGlobalacct(accountType);
            int success =1;


            return success;

        }

        @Override
        protected void onPostExecute(Integer success) {
            super.onPostExecute(success);
          //  progressBar.setVisibility(View.INVISIBLE);
            if (success==1) {
                //Intent Supplier = new Intent(MainActivity.this, )
                Intent consumer = new Intent(MainActivity.this, HomeScreen.class);
                Intent supplier = new Intent(MainActivity.this, UserChoice.class);
                Intent gridControl = new Intent(MainActivity.this, GridControllerMenu.class);
                // pull uuid and assign to global variable

          //      int uuid = userid.getGlobalUUID();
                String acct;
                acct = "1"; /*"0"*/

                if (acct == "0"){
                Toast.makeText(getApplicationContext(), "Log in Successful!", Toast.LENGTH_SHORT).show();
                startActivity(consumer);
                }
                if (acct =="1") {
                    Toast.makeText(getApplicationContext(), "Log in Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(supplier);
                }
                if(acct=="2"){
                    Toast.makeText(getApplicationContext(), "Log in Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(gridControl);
                }
            }
            else
                Toast.makeText(getApplicationContext(), "Log in Failed, Try again", Toast.LENGTH_LONG).show();

        }
    }
}
