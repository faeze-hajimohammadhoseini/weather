package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import javax.security.auth.login.LoginException;

public class WeatherSampleActivity extends AppCompatActivity {
    private static final String TAG = "WeatherSampleActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_sample);

        Button btnSendRequest=(Button) findViewById(R.id.btn_send_request);
        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentWeather("Tehran");
            }
        });


    }
    private void getCurrentWeather(String cityName){

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,
                "http://api.openweathermap.org/data/2.5/weather?q=London&appid=97d6954a493b91e3dcee4f676338ed34",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i(TAG,"onResponse"+response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,"onResponse"+error.toString());
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(8000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}