package com.example.actproperty.department.property;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.actproperty.R;
import com.example.actproperty.itemclick_Interface.OnItemClickRecyclerView;

import java.util.ArrayList;

public class History_for_IdCable_Adapter extends RecyclerView.Adapter<History_for_IdCable_Adapter.ViewHolder> {
    String messageCable, messageMaterials;
    ArrayList<ItemUsed> listItemUsedForIdCable;
    Context context;
    private OnItemClickRecyclerView clickRecyclerView;

    public History_for_IdCable_Adapter(ArrayList<ItemUsed> listItemUsedForIdCable,
                                       Context context,
                                       OnItemClickRecyclerView clickRecyclerView) {
        this.listItemUsedForIdCable = listItemUsedForIdCable;
        this.context = context;
        this.clickRecyclerView = clickRecyclerView;
    }

    @NonNull
    @Override
    public History_for_IdCable_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.custom_recycler_info_history,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final History_for_IdCable_Adapter.ViewHolder viewHolder, int i) {
        CreateTextViewHistory(i);
        viewHolder.idCableHistory.setText(listItemUsedForIdCable.get(i).getCableid());
        viewHolder.cableHistory.setText(messageCable);
        viewHolder.materialsHistory.setText(messageMaterials);
        viewHolder.CRHistory.setText(listItemUsedForIdCable.get(i).getCodecr());
        viewHolder.timeHistory.setText(listItemUsedForIdCable.get(i).getDatechange());
        viewHolder.userHistory.setText(listItemUsedForIdCable.get(i).getProvince());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickRecyclerView.onClick(viewHolder.getAdapterPosition());
            }
        });
     }

    @Override
    public int getItemCount() {
        return listItemUsedForIdCable.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idCableHistory, cableHistory, materialsHistory, CRHistory, timeHistory, userHistory;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            idCableHistory = (TextView) itemView.findViewById(R.id.idCableHistory);
            cableHistory = (TextView)itemView.findViewById(R.id.cableHistory);
            materialsHistory = (TextView) itemView.findViewById(R.id.materialsHistory);
            CRHistory = (TextView)itemView.findViewById(R.id.CRHistory);
            timeHistory = (TextView)itemView.findViewById(R.id.timeHistory);
            userHistory = (TextView)itemView.findViewById(R.id.userHistory);
        }
    }
    private void CreateTextViewHistory(int i){
        messageCable = "";
        messageMaterials = "";
            if(listItemUsedForIdCable.get(i).getHanging4fo()!=0){
                messageCable+="C??p quang treo 4fo: "+listItemUsedForIdCable.get(i).getHanging4fo()+"m"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getHanging6fo()!=0){
                messageCable+="C??p quang treo 6fo: "+listItemUsedForIdCable.get(i).getHanging6fo()+"m"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getHanging12fo()!=0){
                messageCable+="C??p quang treo 12fo: "+listItemUsedForIdCable.get(i).getHanging12fo()+"m"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getHanging24fo()!=0){
                messageCable+="C??p quang treo 24fo: "+listItemUsedForIdCable.get(i).getHanging24fo()+"m"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getOdf6fo()!=0){
                messageMaterials+="ODF 6fo "+listItemUsedForIdCable.get(i).getOdf6fo()+" b???"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getOdf12fo()!=0){
                messageMaterials+="ODF 12fo "+listItemUsedForIdCable.get(i).getOdf12fo()+" b???"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getOdf24fo()!=0){
                messageMaterials+="ODF 24fo "+listItemUsedForIdCable.get(i).getOdf24fo()+" b???"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getMx6fo()!=0){
                messageMaterials+="M??ng x??ng quang 6fo "+listItemUsedForIdCable.get(i).getMx6fo()+" b???"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getMx12fo()!=0){
                messageMaterials+="M??ng x??ng quang 12fo "+listItemUsedForIdCable.get(i).getMx12fo()+" b???"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getMx24fo()!=0){
                messageMaterials+="M??ng x??ng quang 24fo "+listItemUsedForIdCable.get(i).getMx24fo()+" b???"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getBl300()!=0){
                messageMaterials+="Buloong ti 300 "+listItemUsedForIdCable.get(i).getBl300()+" b???"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getBl400()!=0){
                messageMaterials+="Buloong ti 400 "+listItemUsedForIdCable.get(i).getBl400()+" b???"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getClamp()!=0){
                messageMaterials+="K???p c??p "+listItemUsedForIdCable.get(i).getClamp()+" b???"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getPoleu8()!=0){
                messageMaterials+="C???t ??i???n d?????i 8m "+listItemUsedForIdCable.get(i).getPoleu8()+" c???t"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getIronpole6()!=0){
                messageMaterials+="C???t s???t 6m "+listItemUsedForIdCable.get(i).getIronpole6()+" c???t"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getSc_lc5()!=0){
                messageMaterials+="D??y nh???y Sc/Lc 5m "+listItemUsedForIdCable.get(i).getSc_lc5()+" s???i"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getSc_lc10()!=0){
                messageMaterials+="D??y nh???y Sc/Lc 10m "+listItemUsedForIdCable.get(i).getSc_lc10()+" s???i"+"\n";
            }
            if(listItemUsedForIdCable.get(i).getSc_sc5()!=0){
                messageMaterials+="D??y nh???y Sc/Sc 5m "+listItemUsedForIdCable.get(i).getSc_sc5()+" s???i"+"\n";
            }
    }
}
