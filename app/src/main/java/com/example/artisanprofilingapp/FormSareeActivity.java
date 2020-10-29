package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

public class FormSareeActivity extends AppCompatActivity {
    TextInputLayout codeno, productid, productname, fabric, measurement, blousepiece, artworktype;
    EditText nam, nam1, nam3,nam4, nam5, nam6;//to show error msg
    Button submitbtn;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String DataHolder1, DataHolder2, DataHolder3, DataHolder4, DataHolder5, DataHolder6, DataHolder7;
    SharedPreferences myPref;
    private MediaPlayer mediaPlayer;
    int potaka=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_saree);

        codeno = findViewById(R.id.codeno);
        productid = findViewById(R.id.productid);
        productname = findViewById(R.id.productname);
        fabric = findViewById(R.id.fabric);
        measurement = findViewById(R.id.measurement);
        blousepiece = findViewById(R.id.blousepiece);
        artworktype = findViewById(R.id.artworktype);

        nam = findViewById(R.id.nam);//to show error msg
        nam1 = findViewById(R.id.nam1);//to show error msg
        nam3 = findViewById(R.id.nam3);//to show error msg
        nam4 = findViewById(R.id.nam4);//to show error msg
        nam5 = findViewById(R.id.nam5);
        nam6 = findViewById(R.id.nam6);
        submitbtn = findViewById(R.id.submitBtn);

        //Initialize of SharedPref
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(FormSareeActivity.this);
        progressDialog = new ProgressDialog(FormSareeActivity.this);
        mediaPlayer = MediaPlayer.create(this, R.raw.addressinst);
        mediaPlayer.start();

        submitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                ConnectivityManager con = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = con.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    if (!nam.getText().toString().equals("")) {
                        potaka = 1;
                        //Toast.makeText(MainActivity.this,"হয়েগেছে",Toast.LENGTH_LONG).show();
//                    regUser();
//                    Intent i=new Intent(AddressActivity.this,ProfilePicActivity.class);
//                    startActivity(i);
                    } else {
                        nam.setError("টাইপ করুন");
                    }

                    if (!nam1.getText().toString().equals("")) {
                        potaka++;
                        //Toast.makeText(MainActivity.this,"হয়েগেছে",Toast.LENGTH_LONG).show();
//                    regUser();
//                    Intent i=new Intent(AddressActivity.this,ProfilePicActivity.class);
//                    startActivity(i);
                    } else {
                        nam1.setError("টাইপ করুন");
                    }
                    if (!nam3.getText().toString().equals("")) {
                        potaka++;
                        //Toast.makeText(MainActivity.this,"হয়েগেছে",Toast.LENGTH_LONG).show();
//                    regUser();
//                    Intent i=new Intent(AddressActivity.this,ProfilePicActivity.class);
//                    startActivity(i);
                    } else {
                        nam3.setError("টাইপ করুন");
                    }
                    if (!nam4.getText().toString().equals("")) {
                        potaka++;
                        //Toast.makeText(MainActivity.this,"হয়েগেছে",Toast.LENGTH_LONG).show();
//                    regUser();
//                    Intent i=new Intent(AddressActivity.this,ProfilePicActivity.class);
//                    startActivity(i);
                    } else {
                        nam4.setError("টাইপ করুন");
                    }
                    if (!nam5.getText().toString().equals("")) {
                        potaka++;
                        //Toast.makeText(MainActivity.this,"হয়েগেছে",Toast.LENGTH_LONG).show();

                    } else {
                        nam5.setError("টাইপ করুন");
                    }

                    if (potaka==5){
                        regUser();
                        mediaPlayer.stop();
                        Intent i = new Intent(FormSareeActivity.this, AudioActivity.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(FormSareeActivity.this,"সব ফিল্ড টাইপ করুন",Toast.LENGTH_LONG).show();
                    }
//                && !nam1.getText().toString().equals("")
//                        && !nam3.getText().toString().equals("") && !nam4.getText().toString().equals("")
//                        && !nam5.getText().toString().equals("")
                }

                else{
                    Intent intent = new Intent(FormSareeActivity.this, InternetCheckActivity.class);
                    startActivity(intent);
                    finish();
                }

            }

            private void regUser() {
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();


                DataHolder1 = codeno.getEditText().getText().toString().trim();
                DataHolder2 = productid.getEditText().getText().toString().trim();
                DataHolder3 = productname.getEditText().getText().toString().trim();
                DataHolder4 = fabric.getEditText().getText().toString().trim();
                DataHolder5 = measurement.getEditText().getText().toString().trim();
                DataHolder6 = blousepiece.getEditText().getText().toString().trim();
                DataHolder7 = artworktype.getEditText().getText().toString().trim();

                Log.d("eirki",DataHolder1);
                //myPref.edit().putString("phone", PhoneNoHolder).apply();
                //String dataToGet = myPref.getString("phone","No data found");
                String idToGet = myPref.getString("id","No data found");
                String nameToGet = myPref.getString("name","No data found");
                String ageToGet = myPref.getString("age","No data found");
                Log.d("eirki id->",idToGet);
                Log.d("eirki name->",nameToGet);
                Log.d("eirki age->",ageToGet);

                //nameToGet = nameToGet.replaceAll(" ","%20");
                DataHolder1 = DataHolder1.replaceAll(" ","%20");
                DataHolder2 = DataHolder2.replaceAll(" ","%20");
                DataHolder3 = DataHolder3.replaceAll(" ","%20");
                DataHolder4 = DataHolder4.replaceAll(" ","%20");
                DataHolder5 = DataHolder5.replaceAll(" ","%20");
                DataHolder6 = DataHolder6.replaceAll(" ","%20");
                idToGet = idToGet.replaceAll(" ","%20");
                DataHolder7 = DataHolder7.replaceAll(" ","%20");
                //ageToGet = ageToGet.replaceAll(" ","%20");

                String characterFilter = "[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]";
                //nameToGet = nameToGet.replaceAll(characterFilter,"");
                DataHolder1 = DataHolder1.replaceAll(characterFilter,"");
                DataHolder2 = DataHolder2.replaceAll(characterFilter,"");
                DataHolder3 = DataHolder3.replaceAll(characterFilter,"");
                DataHolder4 = DataHolder4.replaceAll(characterFilter,"");
                DataHolder5 = DataHolder5.replaceAll(characterFilter,"");
                idToGet = idToGet.replaceAll(characterFilter,"");
                DataHolder6 = DataHolder6.replaceAll(characterFilter,"");
                DataHolder7 = DataHolder7.replaceAll(characterFilter,"");
                //ageToGet = ageToGet.replaceAll(characterFilter,"");


//                String myurl = "http://192.168.43.12/Artisans-Profiling/name_address.php?name=" + nameToGet + "&district=" + AddressHolder1 +"&addressLine1="+ AddressHolder2
//                        +"&addressLine2="+ AddressHolder3 +"&pinCode="+ AddressHolder4 +"&landMark="+ AddressHolder5
//                        +"&id="+ idToGet+ "&addressExp="+ AddressExpHolder + "&age="+ ageToGet;

                String myurl = "https://artisanapp.xyz/productDescriptionForm.php?codeno=" + DataHolder1 + "&productid=" + DataHolder2 +"&productname="+ DataHolder3
                        +"&fabric="+ DataHolder4 +"&measurement="+ DataHolder5 +"&blousepiece="+ DataHolder6
                        +"&artworktype="+ DataHolder7+ "&artisanid="+ idToGet;



                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.GET, myurl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {
                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();
                                // Showing response message coming from server.
                                Toast.makeText(FormSareeActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                                myPref.edit().putString("track", "4").apply();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();
                                // Showing error message if something goes wrong.
                                Toast.makeText(FormSareeActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                queue.add(stringRequest);

            }

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