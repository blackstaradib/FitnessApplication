package com.example.adib.test;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by ADIB on 15/08/2018.
 */

public class AdapterRecyclerViewCalender extends RecyclerView.Adapter<AdapterRecyclerViewCalender.ViewHolder> {


    private View view1=null;

    private int pos;

    private TextView textView1;

    private Dialog dialog;

    public AdapterRecyclerViewCalender(View view,Dialog dialog) {

        this.view1=view;
        this.dialog=dialog;

    }


    @NonNull
    @Override
    public AdapterRecyclerViewCalender.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLayoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_day_calender,null);

        ViewHolder viewHolder=new ViewHolder(itemLayoutView);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerViewCalender.ViewHolder viewHolder, int position) {


        viewHolder.textView.setText(Integer.toString(position+1));

    }

    @Override
    public int getItemCount() {
        return 30;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemLayoutView) {

            super(itemLayoutView);

            textView1 =view1.findViewById(R.id.textview_calender_select_day);

            textView=itemLayoutView.findViewById(R.id.textViewItemDay);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pos=getAdapterPosition();
                    textView1.setText("اليوم "+Integer.toString(pos+1));
                    dialog.hide();
                }
            });

        }

    }


}