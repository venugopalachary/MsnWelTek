package com.playfordeal.msnweltek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class HeartActivity extends AppCompatActivity {

    ImageView heart;
    private RequestQueue mQueue;
    AlertDialog.Builder builder;
    AlertDialog customdialog;
    Button submitbutton;
    ImageView  closebutton,backbutton;
    String personname ,mobilenumber,countryname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);
        heart=findViewById(R.id.heart);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  heart.setImageResource(R.drawable.heartvess);

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(HeartActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.userslayout, null);
                Button skipbutton=mView.findViewById(R.id.skipbutton);
                skipbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent gamelayout=new Intent(getApplicationContext(),GameActivity.class);
                        startActivity(gamelayout);
                    }
                });
                submitbutton=mView.findViewById(R.id.submitbutton);
                final EditText name = (EditText) mView.findViewById(R.id.nameedit);
                final EditText number = (EditText) mView.findViewById(R.id.numberedit);
                final EditText country = (EditText) mView.findViewById(R.id.countryedit);
                mQueue = Volley.newRequestQueue(getApplicationContext());
                mBuilder.setView(mView);

                customdialog = mBuilder.create();
                customdialog.show();
                customdialog.setCanceledOnTouchOutside(false);
                submitbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        personname = name.getText().toString();
                        mobilenumber = number.getText().toString();
                        countryname=country.getText().toString();
                        // Toast.makeText(ScratchGame.this,personname+":"+mobilenumber,Toast.LENGTH_SHORT).show();

                        if (!personname.isEmpty() && !mobilenumber.isEmpty()) {


                            int mobilenumbervalue = mobilenumber.length();
                            int personnamevalue = personname.length();


                            if (mobilenumbervalue < 10 || mobilenumbervalue > 10) {
                                Toast.makeText(getApplicationContext(),"Please Enter a 10-digit  Number.",Toast.LENGTH_LONG).show();
                            //    KToast.warningToast(DynamicSpinGame.this, "Please Enter a 10-digit  Number.", Gravity.TOP, KToast.LENGTH_AUTO);

                            }

                            if (personnamevalue > 1 && mobilenumbervalue == 10 && countryname.length()>1) {
                                // HERE WE WILL SEND NAME,NUMBER TO SERVER
                                //submitbutton.setEnabled(false);
                                if (customdialog != null && customdialog.isShowing()) {
                                    customdialog.dismiss();
                                }
                                sendingUserData();
                                //  showDialog();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(),"Please Fill Form with all details",Toast.LENGTH_LONG).show();


                        }

                    }
                });



            }
        });


        backbutton=findViewById(R.id.backbutton);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }



    private void sendingUserData() {
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, getString(R.string.USER_FORM_URL),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       // Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                        if (response.trim().equalsIgnoreCase("New record created successfully")) {

                            // Display the response string.
                            // HERE WE WILL MOVING FROM Heart Page TO Game PAGE

                            Intent gamelayout=new Intent(getApplicationContext(),GameActivity.class);
                            startActivity(gamelayout);

                        } else {
                            //
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //       Log.i("error",error+"");
            }
        }) {
            //adding parameters to the request
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", personname);
                params.put("number", mobilenumber);
                params.put("country", countryname);

                return params;
            }
        };
        // Add the request to the RequestQueue.
        mQueue.add(stringRequest);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 2, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

}
