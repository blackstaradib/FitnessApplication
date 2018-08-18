package com.example.adib.test.App;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.adib.test.AdapterCardRadio;
import com.example.adib.test.R;

import java.util.LinkedList;

public class Level_Activity extends AppCompatActivity {

    Button button;

    LinkedList<String> levelname = null;

    int target_id;

    boolean isStart;

    private int level_id=-1;

    int currentValue;

    int targetValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        isStart=bundle.getBoolean("isstart");
        target_id=bundle.getInt("target_id");
        currentValue=bundle.getInt("current_value_weight");
        targetValue=bundle.getInt("target_value_weight");


        levelname=new LinkedList<>();
        levelname.add("مستوى سهل 1");
        levelname.add("مستوى سهل 2");
        levelname.add("مستوى متوسط 1");
        levelname.add("مستوى متوسط 2");
        levelname.add("مستوى صعب 1");
        levelname.add("مستوى صعب 2");


        RecyclerView recyclerView = findViewById(R.id.recyclerViewRadioLevel);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdapterCardRadio adapterCardRadio = new AdapterCardRadio(levelname, this);

        recyclerView.setAdapter(adapterCardRadio);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle=new Bundle();
                bundle.putBoolean("isstart",isStart);
                bundle.putInt("target_id", target_id);
                bundle.putInt("current_value_weight",currentValue);
                bundle.putInt("target_value_weight",targetValue);
                bundle.putInt("level_id",level_id);
                Intent intent = new Intent(Level_Activity.this, FirstActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });


    }



    public void setPosition(int position){
        this.level_id=position;
    }


}
