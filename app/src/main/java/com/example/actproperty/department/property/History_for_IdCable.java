package com.example.actproperty.department.property;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.actproperty.R;
import com.example.actproperty.itemclick_Interface.OnItemClickRecyclerView;

import java.util.ArrayList;

public class History_for_IdCable extends AppCompatActivity implements OnItemClickRecyclerView {
    RecyclerView recyclerInfoHistory;
    ArrayList<ItemUsed> listItemUsedForIdCable;
    TextView infoHistory;
    String showMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_for__id_cable);
        recyclerInfoHistory = (RecyclerView)findViewById(R.id.recyclerInfoHistory);
        listItemUsedForIdCable = new ArrayList<>();
        getArraylist();
        createMessage();
        initView();
    }
    private void getArraylist(){
        Intent intent = getIntent();
        listItemUsedForIdCable = (ArrayList<ItemUsed>) intent.getSerializableExtra("listInfoHistory");
    }
    private void initView(){
        recyclerInfoHistory.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerInfoHistory.setLayoutManager(layoutManager);
        History_for_IdCable_Adapter adapter = new History_for_IdCable_Adapter(listItemUsedForIdCable,
                getApplicationContext(),this);
        recyclerInfoHistory.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, listItemUsedForIdCable.get(position).getCableid(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick1(int position) {

    }

    @Override
    public void onClick2(int position) {

    }

    @Override
    public void onClick3(int position) {

    }
    private void createMessage(){
        String showMessage = "T???ng v???t t?? quy???t to??n trong k??? l??: "+"\n";
        int hanging4fo =0;
        int hanging6fo =0;
        int hanging12fo =0;
        int hanging24fo =0;
        int du12fo =0;
        int odf6fo =0;
        int odf12fo=0;
        int odf24fo=0;
        int mx6fo=0;
        int mx12fo=0;
        int mx24fo=0;
        int bl300=0;
        int bl400=0;
        int clamp=0;
        int poleu8=0;
        int ironpole6=0;
        int sc_lc5=0;
        int sc_lc10=0;
        int sc_sc5=0;
        for(int i=0; i<listItemUsedForIdCable.size();i++){
            hanging4fo +=listItemUsedForIdCable.get(i).getHanging4fo();
            hanging6fo +=listItemUsedForIdCable.get(i).getHanging6fo();
            hanging12fo +=listItemUsedForIdCable.get(i).getHanging12fo();
            hanging24fo +=listItemUsedForIdCable.get(i).getHanging24fo();
            du12fo +=listItemUsedForIdCable.get(i).getDu12fo();
            odf6fo +=listItemUsedForIdCable.get(i).getOdf6fo();
            odf12fo +=listItemUsedForIdCable.get(i).getOdf12fo();
            odf24fo +=listItemUsedForIdCable.get(i).getOdf24fo();
            mx6fo +=listItemUsedForIdCable.get(i).getMx6fo();
            mx12fo+=listItemUsedForIdCable.get(i).getMx12fo();
            mx24fo+=listItemUsedForIdCable.get(i).getMx24fo();
            bl300+=listItemUsedForIdCable.get(i).getBl300();
            bl400+=listItemUsedForIdCable.get(i).getBl400();
            clamp+=listItemUsedForIdCable.get(i).getClamp();
            poleu8+=listItemUsedForIdCable.get(i).getPoleu8();
            ironpole6+=listItemUsedForIdCable.get(i).getIronpole6();
            sc_lc5+=listItemUsedForIdCable.get(i).getSc_lc5();
            sc_lc10+=listItemUsedForIdCable.get(i).getSc_lc10();
            sc_sc5+=listItemUsedForIdCable.get(i).getSc_sc5();
        }
        if(hanging4fo>0){
            showMessage+="C??p quang treo 4fo: "+hanging4fo+" m??t"+"\n";
        }
        if(hanging6fo>0){
            showMessage+="C??p quang treo 6fo: "+hanging6fo+" m??t"+"\n";
        }
        if(hanging12fo>0){
            showMessage+="C??p quang treo 12fo: "+hanging12fo+" m??t"+"\n";
        }
        if(hanging24fo>0){
            showMessage+="C??p quang treo 24fo: "+hanging24fo+" m??t"+"\n";
        }
        if(du12fo>0){
            showMessage+="C??p quang lu???n c???ng 212fo: "+du12fo+" m??t"+"\n";
        }
        if(odf6fo>0){
            showMessage+="ODF 6fo: "+odf6fo+" b???"+"\n";
        }
        if(odf12fo>0){
            showMessage+="ODF 12fo: "+odf12fo+" b???"+"\n";
        }
        if(odf24fo>0){
            showMessage+="ODF 24fo: "+odf24fo+" b???"+"\n";
        }
        if(mx6fo>0){
            showMessage+="M??ng x??ng 6fo: "+mx6fo+" b???"+"\n";
        }
        if(mx12fo>0){
            showMessage+="M??ng x??ng 12fo: "+mx12fo+" b???"+"\n";
        }
        if(mx24fo>0){
            showMessage+="M??ng x??ng 24fo: "+mx24fo+" b???"+"\n";
        }
        if(bl300>0){
            showMessage+="Buloong ti 300: "+bl300+" b???"+"\n";
        }
        if(bl400>0){
            showMessage+="Buloong ti 400: "+bl400+" b???"+"\n";
        }
        if(clamp>0){
            showMessage+="K???p c??p 2 r??nh 3 l???: "+clamp+" b???"+"\n";
        }
        if(poleu8>0){
            showMessage+="C???t ??i???n d?????i 8m: "+poleu8+" c???t"+"\n";
        }
        if(ironpole6>0){
            showMessage+="C???t s???t 6 m??t: "+ironpole6+" c???t"+"\n";
        }
        if(sc_lc5>0){
            showMessage+="D??y nh???y quang Sc/lc 5m: "+sc_lc5+" s???i"+"\n";
        }
        if(sc_lc10>0){
            showMessage+="D??y nh???y quang Sc/lc 10m: "+sc_lc10+" s???i"+"\n";
        }
        if(sc_sc5>0){
            showMessage+="D??y nh???y quang Sc/sc 5m: "+sc_sc5+" s???i"+"\n";
        }
        infoHistory = (TextView)findViewById(R.id.infoHistory);
        infoHistory.setText(showMessage);
    }
}