package com.example.actproperty.passport;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetPassport {
    ArrayList<Passport> listPassport;
    Context context;
    public ArrayList<Passport> GetListPassport(){
        listPassport = new ArrayList<>();
        String url="https://sqlandroid2812.000webhostapp.com/getpassport.php";
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                listPassport.add(new Passport(
                                        jsonObject.getInt("ID"),
                                        jsonObject.getString("USER"),
                                        jsonObject.getString("PASSWORD"),
                                        jsonObject.getString("FULLNAME"),
                                        jsonObject.getString("MOBILE"),
                                        jsonObject.getInt("ADMIN"),
                                        jsonObject.getInt("PROPERTY"),
                                        jsonObject.getInt("NOC"),
                                        jsonObject.getInt("ACCOUNTANT"),
                                        jsonObject.getInt("BDG"),
                                        jsonObject.getInt("HCM_BCH"),
                                        jsonObject.getInt("HCM_BTN"),
                                        jsonObject.getInt("HCM_CCI"),
                                        jsonObject.getInt("HCM_Q12"),
                                        jsonObject.getInt("HCM_HMN"),
                                        jsonObject.getInt("HCM_GVP"),
                                        jsonObject.getInt("DNI"),
                                        jsonObject .getInt("LAN"),
                                        jsonObject.getInt("BTE"),
                                        jsonObject.getInt("TVH"),
                                        jsonObject.getInt("KGG")

                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        return listPassport;
    }

}
