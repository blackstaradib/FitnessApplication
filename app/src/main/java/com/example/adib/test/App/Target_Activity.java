package com.example.adib.test.App;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.adib.test.AdapterCardRadio;
import com.example.adib.test.Current_Enter_Weight_Activity;
import com.example.adib.test.R;

import java.util.LinkedList;

public class Target_Activity extends FragmentActivity {


    Button button;

    LinkedList<String> targetname=null;

    private int target_id=-1;

    boolean isStart;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);


        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        isStart=bundle.getBoolean("isstart");

        targetname=new LinkedList<>();
        targetname.add("الحفاظ على الوزن");
        targetname.add("انقاص الوزن");
        targetname.add("زيادة الوزن");


        RecyclerView recyclerView=findViewById(R.id.recyclerViewRadioTarget);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdapterCardRadio adapterCardRadio=new AdapterCardRadio(targetname,this);

        recyclerView.setAdapter(adapterCardRadio);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        button=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle=new Bundle();
                bundle.putInt("target_id",target_id);
                bundle.putBoolean("isstart",isStart);

                Intent intent = new Intent(Target_Activity.this, Current_Enter_Weight_Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        dialog = new Dialog(this, R.style.Theme_Dialog);
        dialog.setContentView(R.layout.dialog_prediction);
        dialog.show();
        Button button = dialog.findViewById(R.id.button_prediction_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });


    }

    public void setPosition(int position){
        this.target_id=position;
    }


}
