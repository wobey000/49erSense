
package com.example.a49ersense;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.RadioGroup;

import org.json.JSONObject;



public class CreateAccount extends AppCompatActivity {
    Button submit;
    EditText user, pass, name, email, phone;
    Integer idx;
    RadioGroup radioButtongroup;
    ProgressBar progressBar;
    loadData asyncTask=new loadData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        submit =(Button)findViewById(R.id.submitButton);
        user =(EditText)findViewById(R.id.usernameNew);
        pass =(EditText)findViewById(R.id.passwordNew);
        name =(EditText)findViewById(R.id.nameNew);
        email =(EditText)findViewById(R.id.emailNew);
        phone =(EditText)findViewById(R.id.phoneNew);
        radioButtongroup =(RadioGroup)findViewById(R.id.radioGroup);

        //radioButton index
        int radioButtonID = radioButtongroup.getCheckedRadioButtonId();
        View radioButton = radioButtongroup.findViewById(radioButtonID);
        idx = radioButtongroup.indexOfChild(radioButton);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.INVISIBLE);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = user.getText().toString();
                String p = pass.getText().toString();
                String n = name.getText().toString();
                String e = email.getText().toString();
                String ph = phone.getText().toString();
                String index = idx.toString();

                asyncTask.execute(u,p,n,e,ph,index);
            }
        });
    }
    private class loadData extends AsyncTask<String, String, Integer>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar = new ProgressBar(CreateAccount.this);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(String... args) {
            
            //createAccount.php
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			//TODO: NEEDED VARIABLES
			//username - string
			String username = args[0];
			params.add(new BasicNameValuePair("username", username));
			
			//password - string
			String password = args[1];
			params.add(new BasicNameValuePair("password", password));
			
			//name - string
			String name = args[2];
			params.add(new BasicNameValuePair("name",name));
			
			//phone - string or int (your choice)
			String phone = args[4];
			params.add(new BasicNameValuePair("phone",phone));
			
			//email - string
			String email = args[3];
			params.add(new BasicNameValuePair("email",email));
			
			//accountType - string or int (your choice)
			String accountType = args[5];
			params.add(new BasicNameValuePair("accountType",accountType));
			
            JSONObject json = jsonParser.makeHttpRequest(IP_ADDRESS+"/createAccount.php", "POST", params);
			//json = jParser.makeHttpRequest(IP_ADDRESS+"/login.php", "GET", params);
			//int success = json.getInt("success");//fail if -1
            //TODO: Success or error result.

            int success = 1;

            return success;
        }

        @Override
        protected void onPostExecute(Integer success) {
            super.onPostExecute(success);
            progressBar.setVisibility(View.INVISIBLE);

            if(success == 1) {
                Toast.makeText(getApplicationContext(), "Account Created Successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
            else
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();


        }
    }

}

