package com.example.adib.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by ADIB on 15/08/2018.
 */

public class AdapterRecyclerViewCalender extends RecyclerView.Adapter<AdapterRecyclerViewCalender.ViewHolder> {


    private Context context=null;


    public AdapterRecyclerViewCalender(Context context) {

        this.context=context;

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


        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 30;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemLayoutView) {

            super(itemLayoutView);
            textView=itemLayoutView.findViewById(R.id.textViewItemDay);
        }

    }


}