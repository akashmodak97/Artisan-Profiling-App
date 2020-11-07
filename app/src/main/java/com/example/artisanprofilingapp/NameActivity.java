package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

public class NameActivity extends AppCompatActivity {
    TextInputLayout name;
    EditText nam;//to show error msg
    Button submitbtn;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String NameHolder,st,sc,gen,obc;
    SharedPreferences myPref;
    private MediaPlayer mediaPlayer;
    RadioButton yes, no;
    RadioGroup radioGroup1, radioGroup2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        name = (TextInputLayout)findViewById(R.id.name);
        nam = (EditText)findViewById(R.id.nam);//to show error msg
        submitbtn = (Button)findViewById(R.id.submitBtn);
        mediaPlayer = MediaPlayer.create(this, R.raw.nameinst);

        mediaPlayer.start();

        //Initialize of SharedPref
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(NameActivity.this);
        progressDialog = new ProgressDialog(NameActivity.this);

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.gen:
                        gen = "gen";
                        myPref.edit().putString("caste", "gen").apply();
                        break;
                    case R.id.sc:
                        sc = "sc";
                        myPref.edit().putString("caste", "sc").apply();
                        break;
                    case R.id.st:
                        st = "st";
                        myPref.edit().putString("caste", "st").apply();
                        break;
                    case R.id.obc:
                        obc = "obc";
                        myPref.edit().putString("caste", "obc").apply();
                }
            }
            });

        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.male:
//                        gen = "gen";
                        myPref.edit().putString("gender", "male").apply();
                        break;
                    case R.id.female:
//                        sc = "sc";
                        myPref.edit().putString("gender", "female").apply();
                        break;
                    case R.id.others:
//                        st = "st";
                        myPref.edit().putString("gender", "others").apply();
                        break;
//                    case R.id.obc:
//                        obc = "obc";
//                        myPref.edit().putString("caste", "obc").apply();
                }
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ConnectivityManager con = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = con.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    if (!nam.getText().toString().equals("")) {
                        //Toast.makeText(MainActivity.this,"হয়েগেছে",Toast.LENGTH_LONG).show();
                        NameHolder = name.getEditText().getText().toString().trim();
                        Log.d("eirki name->", NameHolder);
                        //myPref.edit().putString("phone", PhoneNoHolder).apply();
                        myPref.edit().putString("name", NameHolder).apply();
                        //regUser();
                        myPref.edit().putString("track", "2").apply();
                        mediaPlayer.stop();
                        Intent i = new Intent(NameActivity.this, AgeActivity.class);
                        startActivity(i);
                    } else {
                        nam.setError("আপনার নাম টাইপ করুন");
                    }
                }
                else{
                    Intent intent = new Intent(NameActivity.this, InternetCheckActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

//            private void regUser() {
//                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
//                progressDialog.show();
//
//                NameHolder = name.getEditText().getText().toString().trim();
//                Log.d("eirki name->",NameHolder);
//                //myPref.edit().putString("phone", PhoneNoHolder).apply();
//                myPref.edit().putString("name",NameHolder).apply();
//
//                //String dataToGet = myPref.getString("phone","No data found");
//                String dataToGet = myPref.getString("id","No data found");
//                Log.d("eirki id->",dataToGet);
//
//                //String myurl = "http://192.168.43.12/Artisans-Profiling/name.php?name=" + NameHolder +"&phoneno="+ dataToGet;
//                String myurl = "http://192.168.43.12/Artisans-Profiling/name.php?name=" + NameHolder +"&id="+ dataToGet;
//
//                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
//                StringRequest stringRequest = new StringRequest(Request.Method.POST, myurl,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String ServerResponse) {
//                                // Hiding the progress dialog after all task complete.
//                                progressDialog.dismiss();
//                                // Showing response message coming from server.
//                                Toast.makeText(NameActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
//                                myPref.edit().putString("track", "2").apply();
//                            }
//                        },
//                        new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError volleyError) {
//                                // Hiding the progress dialog after all task complete.
//                                progressDialog.dismiss();
//                                // Showing error message if something goes wrong.
//                                Toast.makeText(NameActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
//
//                            }
//                        });
//                queue.add(stringRequest);
//
//            }

        });

    }
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }
    @Override
    public void onUserLeaveHint(){
        mediaPlayer.stop();
        super.onUserLeaveHint();
    }
}