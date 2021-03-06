package com.example.actproperty.department.accounting;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.actproperty.R;
import com.example.actproperty.inventory.TempDeliver;
import com.example.actproperty.passport.Passport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deliver extends AppCompatActivity {
    ArrayList<Passport>listUser;
    LinearLayout rowChosen, rowLock;
    EditText commentDeliver;
    Button btnLock;
    String codeStore, comment,user, time;
    TempDeliver tempDeliver;
    private int id, hanging6fo, hanging12fo, hanging24fo, odf6fo, odf12fo, odf24fo, closure6fo,
            closure12fo, closure24fo, bl300, bl400, clamp, sc_lc5, sc_lc10, flag;
    TextView item1Chosen, item2Chosen,item3Chosen,item4Chosen,item5Chosen, item1Value,
            item2Value,item3Value,item4Value,item5Value;
    LinearLayout row1Chosen,row2Chosen,row3Chosen,row4Chosen,row5Chosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);
        codeStore = "";
        comment = "";
        user = "";
        time = "";
        id = 0;
        hanging6fo = 0;
        hanging12fo = 0;
        hanging24fo = 0;
        odf6fo = 0;
        odf12fo = 0;
        odf24fo = 0;
        closure6fo = 0;
        closure12fo = 0;
        closure24fo = 0;
        bl300 = 0;
        bl400 = 0;
        clamp = 0;
        sc_lc5 = 0;
        sc_lc10 = 0;
        flag = 1;
        tempDeliver = new TempDeliver(id,codeStore, hanging6fo,hanging12fo,hanging24fo,odf6fo,odf12fo,odf24fo,
                closure6fo,closure12fo,closure24fo,bl300,bl400,clamp,sc_lc5,sc_lc10,user,time,comment,flag);
        getUser();
        getStoreDeliver();
        item1Chosen = (TextView)findViewById(R.id.item1Chosen);
        item2Chosen = (TextView)findViewById(R.id.item2Chosen);
        item3Chosen = (TextView)findViewById(R.id.item3Chosen);
        item4Chosen = (TextView)findViewById(R.id.item4Chosen);
        item5Chosen = (TextView)findViewById(R.id.item5Chosen);
        item1Value = (TextView)findViewById(R.id.valueItem1);
        item2Value = (TextView)findViewById(R.id.valueItem2);
        item3Value = (TextView)findViewById(R.id.valueItem3);
        item4Value = (TextView)findViewById(R.id.valueItem4);
        item5Value = (TextView)findViewById(R.id.valueItem5);
        row1Chosen = (LinearLayout)findViewById(R.id.row1Chosen);
        row2Chosen = (LinearLayout)findViewById(R.id.row2Chosen);
        row3Chosen = (LinearLayout)findViewById(R.id.row3Chosen);
        row4Chosen = (LinearLayout)findViewById(R.id.row4Chosen);
        row5Chosen = (LinearLayout)findViewById(R.id.row5Chosen);
        commentDeliver = (EditText)findViewById(R.id.commentDeliver);
        rowLock = (LinearLayout)findViewById(R.id.rowLock);
        rowChosen = (LinearLayout)findViewById(R.id.rowChosen);
        btnLock = (Button)findViewById(R.id.btnLock);
        btnLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(commentDeliver.getText().toString().trim().length()>20) {
                    Deliver();
                    rowLock.setVisibility(View.GONE);
                    rowChosen.setVisibility(View.VISIBLE);
                    comment = commentDeliver.getText().toString();
                    tempDeliver.setCommentDeliver(comment);
                }else{
                    Toast.makeText(Deliver.this, "Vui l??ng di???n gi???i r?? xu???t kho", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void getStoreDeliver(){
        final Spinner spinnerToStore = (Spinner)findViewById(R.id.spinnerToStore);
        List<String> listToStore = new ArrayList<>();
        listToStore.add("B???n Tre");
        listToStore.add("Long An");
        listToStore.add("Tr?? Vinh");
        listToStore.add("Ki??n Giang");
        listToStore.add("B??nh D????ng");
        listToStore.add("?????ng Nai");
        listToStore.add("HCM_B??nh T??n");
        listToStore.add("HCM_B??nh Ch??nh");
        listToStore.add("HCM_C??? Chi");
        listToStore.add("HCM_H??c M??n");
        listToStore.add("HCM_Qu???n 12");
        listToStore.add("HCM_G?? V???p");
        /*======================= CHOICE STORE==========================*/
        ArrayAdapter<String> adapterToStore = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,listToStore);
        adapterToStore.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerToStore.setAdapter(adapterToStore);
        spinnerToStore.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                codeStore = spinnerToStore.getSelectedItem().toString();
                tempDeliver.setStoreCode(codeStore);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void Deliver(){
        List<String> listItem = new ArrayList<>();
        listItem.add("C??p quang treo 6Fo");
        listItem.add("C??p quang treo 12Fo");
        listItem.add("C??p quang treo 24Fo");
        listItem.add("ODF 6fo");
        listItem.add("ODF 12fo");
        listItem.add("ODF 24fo");
        listItem.add("M??ng x??ng 6fo");
        listItem.add("M??ng x??ng 12fo");
        listItem.add("M??ng x??ng 24fo");
        listItem.add("Buloong ti 300");
        listItem.add("Buloong ti 400");
        listItem.add("K???p c??p");
        listItem.add("D??y nh???y Sc/LC 5m");
        listItem.add("D??y nh???y Sc/LC 10m");
        /*======================= GET ITEM==========================*/
        final Spinner spinnerItem1 = (Spinner)findViewById(R.id.spinnerItem1);
        final EditText item1 = (EditText)findViewById(R.id.item1);
        final Button btnAddItem = (Button)findViewById(R.id.btnAddItem);
        ArrayAdapter<String> adapterItem1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,listItem);
        adapterItem1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerItem1.setAdapter(adapterItem1);
        spinnerItem1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextSize(10);
                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLUE);
                btnAddItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(Integer.parseInt(item1.getText().toString().trim())==0){
                            Toast.makeText(Deliver.this, "Vui l??ng nh???p s??? l?????ng "+
                                    spinnerItem1.getSelectedItem().toString()+" xu???t.", Toast.LENGTH_SHORT).show();
                        }else{
                            if(row1Chosen.getVisibility() == View.VISIBLE &&
                                row2Chosen.getVisibility() == View.VISIBLE &&
                                row3Chosen.getVisibility()==View.VISIBLE&&
                                row4Chosen.getVisibility()==View.VISIBLE&&
                                row5Chosen.getVisibility()==View.VISIBLE){
                                Toast.makeText(Deliver.this, "Th??m t???i ??a 5 ch???ng lo???i v???t t??!", Toast.LENGTH_SHORT).show();
                            }else if(row1Chosen.getVisibility() == View.VISIBLE &&
                                    row2Chosen.getVisibility() == View.VISIBLE &&
                                    row3Chosen.getVisibility() == View.VISIBLE&&
                                    row4Chosen.getVisibility() == View.VISIBLE){
                                if(spinnerItem1.getSelectedItem().toString().equals(item1Chosen.getText().toString()) ||
                                        spinnerItem1.getSelectedItem().toString().equals(item2Chosen.getText().toString()) ||
                                        spinnerItem1.getSelectedItem().toString().equals(item3Chosen.getText().toString()) ||
                                        spinnerItem1.getSelectedItem().toString().equals(item4Chosen.getText().toString())){
                                    Toast.makeText(Deliver.this, "V???t t?? n??y ???? ???????c ch???n, h??y ch???n l???i",
                                            Toast.LENGTH_SHORT).show();
                                     }else {
                                    row5Chosen.setVisibility(View.VISIBLE);
                                    item5Chosen.setText(spinnerItem1.getSelectedItem().toString());
                                    item5Value.setText(item1.getText().toString());
                                    getTempDeliver(spinnerItem1.getSelectedItem().toString(),Integer.parseInt(item1.getText().toString()));
                                }
                            }else if(row1Chosen.getVisibility() == View.VISIBLE &&
                                    row2Chosen.getVisibility() == View.VISIBLE &&
                                    row3Chosen.getVisibility() == View.VISIBLE){
                                if(spinnerItem1.getSelectedItem().toString().equals(item1Chosen.getText().toString()) ||
                                        spinnerItem1.getSelectedItem().toString().equals(item2Chosen.getText().toString()) ||
                                        spinnerItem1.getSelectedItem().toString().equals(item3Chosen.getText().toString())){
                                    Toast.makeText(Deliver.this, "V???t t?? n??y ???? ???????c ch???n, h??y ch???n l???i",
                                            Toast.LENGTH_SHORT).show();
                                    }else{
                                row4Chosen.setVisibility(View.VISIBLE);
                                item4Chosen.setText(spinnerItem1.getSelectedItem().toString());
                                item4Value.setText(item1.getText().toString());
                                getTempDeliver(spinnerItem1.getSelectedItem().toString(),Integer.parseInt(item1.getText().toString()));
                                }
                            }else if(row1Chosen.getVisibility() == View.VISIBLE &&
                                    row2Chosen.getVisibility() == View.VISIBLE){
                                if(spinnerItem1.getSelectedItem().toString().equals(item1Chosen.getText().toString()) ||
                                        spinnerItem1.getSelectedItem().toString().equals(item2Chosen.getText().toString())){
                                    Toast.makeText(Deliver.this, "V???t t?? n??y ???? ???????c ch???n, h??y ch???n l???i",
                                            Toast.LENGTH_SHORT).show();
                                }else{
                                row3Chosen.setVisibility(View.VISIBLE);
                                item3Chosen.setText(spinnerItem1.getSelectedItem().toString());
                                item3Value.setText(item1.getText().toString());
                                getTempDeliver(spinnerItem1.getSelectedItem().toString(),Integer.parseInt(item1.getText().toString()));
                                }
                            }else if(row1Chosen.getVisibility() == View.VISIBLE){
                                if(spinnerItem1.getSelectedItem().toString().equals(item1Chosen.getText().toString())){
                                    Toast.makeText(Deliver.this, "V???t t?? n??y ???? ???????c ch???n, h??y ch???n l???i",
                                            Toast.LENGTH_SHORT).show();
                                }else{
                                row2Chosen.setVisibility(View.VISIBLE);
                                item2Chosen.setText(spinnerItem1.getSelectedItem().toString());
                                item2Value.setText(item1.getText().toString());
                                getTempDeliver(spinnerItem1.getSelectedItem().toString(),Integer.parseInt(item1.getText().toString()));
                                }
                            }else{
                                row1Chosen.setVisibility(View.VISIBLE);
                                item1Chosen.setText(spinnerItem1.getSelectedItem().toString());
                                item1Value.setText(item1.getText().toString());
                                getTempDeliver(spinnerItem1.getSelectedItem().toString(),Integer.parseInt(item1.getText().toString()));
                            }
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button btnDeliver = (Button)findViewById(R.id.btnDeliver);
        btnDeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              InsertDeliver("https://sqlandroid2812.000webhostapp.com/insertdeliver.php",codeStore,hanging6fo,hanging12fo,hanging24fo,
                      odf6fo,odf12fo,odf24fo,closure6fo,closure12fo,closure24fo,bl300,bl400,clamp,sc_lc5,sc_lc10,user,
                      "07/07/2020",comment,flag);
            }
        });
    }

    private void getUser(){
        Intent intent = getIntent();
        listUser = (ArrayList<Passport>) intent.getSerializableExtra("Account");
        user = listUser.get(0).getUser();
    }
    private void InsertDeliver(String url, final String codeStore, final int hanging6fo, final int hanging12fo, final int hanging24fo,
                               final int odf6fo, final int odf12fo, final int odf24fo, final int mx6fo, final int mx12fo, final int mx24fo, final int bl300,
                               final int bl400, final int clamp, final int sc_lc5, final int sc_lc10, final String user, final String time, final String comment,final int flag){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        )
            {
                @Override
                protected Map<String,String> getParams() throws AuthFailureError{
                    Map<String, String> params = new HashMap<>();
                    params.put("Codestore",codeStore);
                    params.put("Deliverhanging6fo",String.valueOf(hanging6fo));
                    params.put("Deliverhanging12fo",String.valueOf(hanging12fo));
                    params.put("Deliverhanging24fo",String.valueOf(hanging24fo));
                    params.put("Deliverodf6fo",String.valueOf(odf6fo));
                    params.put("Deliverodf12fo",String.valueOf(odf12fo));
                    params.put("Deliverodf24fo",String.valueOf(odf24fo));
                    params.put("Deliverclosure6fo",String.valueOf(mx6fo));
                    params.put("Deliverclosure12fo",String.valueOf(mx12fo));
                    params.put("Deliverclosure24fo",String.valueOf(mx24fo));
                    params.put("Deliverbuloongti300",String.valueOf(bl300));
                    params.put("Deliverbuloongti400",String.valueOf(bl400));
                    params.put("Deliverclamp",String.valueOf(clamp));
                    params.put("Deliversc_lc5",String.valueOf(sc_lc5));
                    params.put("Deliversc_lc10",String.valueOf(sc_lc10));
                    params.put("Deliveruser",user);
                    params.put("Delivertime",time);
                    params.put("Delivercomment",comment);
                    params.put("Deliverflag",String.valueOf(flag));
                    return params;
                }
            };
        requestQueue.add(stringRequest);
    }
    private void getTempDeliver (String item, int value){
        switch(item){
            case "C??p quang treo 6Fo":
                hanging6fo = value;
                break;
            case "C??p quang treo 12Fo":
                hanging12fo = value;
                break;
            case "C??p quang treo 24Fo":
                hanging24fo = value;
                break;
            case "ODF 6fo":
                odf6fo = value;
                break;
            case "ODF 12fo":
                odf12fo = value;
                break;
            case "ODF 24fo":
                odf24fo = value;
                break;
            case "M??ng x??ng 6fo":
                closure6fo = value;
                break;
            case "M??ng x??ng 12fo":
                closure12fo = value;
                break;
            case "M??ng x??ng 24fo":
                closure24fo = value;
                break;
            case "Buloong ti 300":
                bl300 = value;
                break;
            case "Buloong ti 400":
                bl400 = value;
                break;
            case "K???p c??p":
                clamp = value;
                break;
            case "D??y nh???y Sc/LC 5m":
                sc_lc5 = value;
                break;
            case "D??y nh???y Sc/LC 10m":
                sc_lc10 = value;
                break;
        }
    }
}