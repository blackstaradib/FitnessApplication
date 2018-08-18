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
 * Created by ADIB on 28/07/2018.
 */

public class Target_Enter_Weight_Activity extends AppCompatActivity {

    Button buttonNext;
    Button buttonBack;
    NumberPicker numberPicker;


    int target_id;

    boolean isStart;

    int currentValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_target_weight);


        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        target_id=bundle.getInt("target_id");
        isStart=bundle.getBoolean("isstart");
        currentValue=bundle.getInt("current_value_weight");

        buttonNext = findViewById(R.id.buttonNextTarget);
        buttonBack = findViewById(R.id.buttonBackTarget);

        numberPicker = findViewById(R.id.numberPickerTarget);
        numberPicker.setMaxValue(200);
        numberPicker.setMinValue(40);
        numberPicker.setWrapSelectorWheel(false);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(target_id==1&&numberPicker.getValue()>currentValue){
                    //error
                }
                else if (target_id==2&&numberPicker.getValue()<currentValue){
                    //error
                }
                else
                {
                    Bundle bundle=new Bundle();
                    bundle.putBoolean("isstart",isStart);
                    bundle.putInt("target_id", target_id);
                    bundle.putInt("current_value_weight",currentValue);
                    bundle.putInt("target_value_weight",numberPicker.getValue());
                    Intent intent;
                    if (isStart) {
                        intent= new Intent(Target_Enter_Weight_Activity.this, Level_Activity.class);
                    }
                    else
                    {
                        intent= new Intent(Target_Enter_Weight_Activity.this, FirstActivity.class);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

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