package com.example.actproperty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.actproperty.passport.Passport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText edtUser, edtPass;
    ArrayList<Passport> listPassport;
    ArrayList<Passport> listUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        listUser = new ArrayList<>();
        listPassport = new ArrayList<>();
        GetListPassport();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Size "+listPassport.size(), Toast.LENGTH_SHORT).show();
            }
        });
            }
        private void GetListPassport(){
            String url="https://sqlandroid2812.000webhostapp.com/getpassport.php";
            RequestQueue requestQueue = Volley.newRequestQueue(this);
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
        }

    }
