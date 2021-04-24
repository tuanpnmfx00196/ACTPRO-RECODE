package com.example.actproperty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.actproperty.passport.GetPassport;
import com.example.actproperty.passport.Passport;

import java.util.ArrayList;
import java.util.Collections;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText edtUser, edtPass;
    ArrayList listPassport;
    ArrayList<Passport> listUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        listUser = new ArrayList<>();
        final GetPassport getPassport = new GetPassport();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Size "+getPassport.GetListPassport().size(), Toast.LENGTH_SHORT).show();
            }
        });
        /*============================= CHANGE PASSWORD ==============================*/

    }

}