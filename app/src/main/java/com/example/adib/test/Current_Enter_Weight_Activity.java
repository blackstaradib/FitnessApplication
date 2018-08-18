package com.example.adib.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.adib.test.App.FirstActivity;
import com.example.adib.test.App.Level_Activity;

/**
 * Created by ADIB on 25/07/2018.
 */

public class Current_Enter_Weight_Activity extends AppCompatActivity {

    Button buttonNext;
    Button buttonBack;
    NumberPicker numberPicker;

    int target_id;

    boolean isStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_current_weight);


        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        target_id=bundle.getInt("target_id");
        isStart=bundle.getBoolean("isstart");

        buttonNext = findViewById(R.id.buttonNextCurrent);
        buttonBack = findViewById(R.id.buttonBackCurrent);

        numberPicker = findViewById(R.id.numberPickerCurrent);
        numberPicker.setMaxValue(200);
        numberPicker.setMinValue(40);
        numberPicker.setWrapSelectorWheel(false);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putBoolean("isstart",isStart);
                bundle.putInt("target_id", target_id);
                bundle.putInt("current_value_weight",numberPicker.getValue());
                Intent intent=null;
                if (target_id==0&&isStart) {
                    intent = new Intent(Current_Enter_Weight_Activity.this, Level_Activity.class);
                    bundle.putInt("target_value_weight",numberPicker.getValue());
                }
                else if (target_id==0&&!isStart){
                    intent = new Intent(Current_Enter_Weight_Activity.this, FirstActivity.class);
                    bundle.putInt("target_value_weight",numberPicker.getValue());
                }
                else if (target_id==1){
                    intent = new Intent(Current_Enter_Weight_Activity.this, Target_Enter_Weight_Activity.class);
                }
                else if (target_id==2){
                    intent = new Intent(Current_Enter_Weight_Activity.this, Target_Enter_Weight_Activity.class);
                }
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

    }
}