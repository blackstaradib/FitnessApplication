package com.example.adib.test.FragmentExercise;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.adib.test.R;

/**
 * Created by ADIB on 12/08/2018.
 */

public class FragmentExercise5th extends Fragment {


    private View view=null;

    private Button button=null;

    private Bundle bundle;

    private int countExercise;

    Fragment fragment4thor6th;
    FragmentTransaction transaction;
    AppCompatActivity activity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_exercise_5th,container,false);

        bundle=getArguments();
        countExercise=bundle.getInt("count_exercise");
        countExercise--;

        button=view.findViewById(R.id.button_exercise_next);
        if (countExercise!=0) {
            button.setText("استمرار");
        }
        else {
            button.setText("انهاء");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (countExercise!=0) {
                    activity = (AppCompatActivity) view.getContext();

                    bundle=new Bundle();
                    bundle.putInt("count_exercise",countExercise);
                    fragment4thor6th = new FragmentExercise4th();
                    fragment4thor6th.setArguments(bundle);

                    transaction=activity.getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.frameExercise , fragment4thor6th);
                    transaction.addToBackStack("4th");
                    transaction.commit();
                }
                else {
                    activity = (AppCompatActivity) view.getContext();

                    activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    FragmentManager fragmentManager=activity.getSupportFragmentManager();
                    String name = fragmentManager.getBackStackEntryAt(0).getName();
                    fragmentManager.popBackStackImmediate(name,FragmentManager.POP_BACK_STACK_INCLUSIVE);

                }

            }
        });

        return view;

    }
}
