package com.example.adib.test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;


import com.example.adib.test.App.Level_Activity;
import com.example.adib.test.App.Target_Activity;

import java.util.List;

/**
 * Created by ADIB on 25/07/2018.
 */




public class AdapterCardRadio extends RecyclerView.Adapter<AdapterCardRadio.ViewHolder>  {


    private Target_Activity contextTarget=null;
    private Level_Activity contextLevel=null;
    private int lastSelectedPosition = -1;

    private List<String> name=null;

    Button button;

    public AdapterCardRadio(List<String>  name,Target_Activity context)
    {
        super();
        this.name=name;
        this.contextTarget=context;
    }

    public AdapterCardRadio(List<String>  name, Level_Activity context)
    {
        super();
        this.name=name;
        this.contextLevel=context;
    }



    @NonNull
    @Override
    public AdapterCardRadio.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLayoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_radio,null);

        ViewHolder viewHolder=new ViewHolder(itemLayoutView);

        if(contextTarget!=null) {
            button = contextTarget.findViewById(R.id.button2);
        }
        else if(contextLevel!=null)
        {
            button = contextLevel.findViewById(R.id.button3);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCardRadio.ViewHolder viewholder, final int position) {


        viewholder.radioButton.setText(name.get(position));

        viewholder.radioButton.setChecked(lastSelectedPosition==position);

        viewholder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                button.setEnabled(true);
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public RadioButton radioButton;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            radioButton = itemLayoutView.findViewById(R.id.radioButtonCard);

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();

                    if(contextTarget!=null) {
                        contextTarget.setPosition(lastSelectedPosition);
                    }
                    if(contextLevel!=null){
                        contextLevel.setPosition(lastSelectedPosition);
                    }

                }
            });

        }

    }














//    public void show(int index) {
//        dialog = new Dialog(context);
//        dialog.setTitle("NumberPicker");
//        dialog.setContentView(R.layout.activity_enter_current_weight);
//
//        button1 = dialog.findViewById(R.id.button10);
//        button2 = dialog.findViewById(R.id.button20);
//
//        numberPicker = dialog.findViewById(R.id.numberPicker1);
//        numberPicker.setMaxValue(200); // max value 100
//        numberPicker.setMinValue(40);   // min value 0
//        numberPicker.setWrapSelectorWheel(false);
//        //numberPicker.setOnValueChangedListener(this);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //tv.setText(String.valueOf(numberPicker.getValue())); //set the value to textview
//                //button.setClickable(true);
//                dialog.dismiss();
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //button.setClickable(false);
//                dialog.dismiss(); // dismiss the dialog
//            }
//        });
//        dialog.show();
//    }
//





}


