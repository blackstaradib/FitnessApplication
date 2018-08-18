package com.example.adib.test.FragmentExercise;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class FragmentExerciseThird extends Fragment {

    private View view=null;
    private Button button=null;

    private Bundle bundle;
    //private int countExercise;

    Fragment fragment4th;
    FragmentTransaction transaction;
    AppCompatActivity activity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_exercise_third,container,false);

        bundle=getArguments();
        //countExercise=bundle.getInt("count_exercise");

        button=view.findViewById(R.id.button_exercise_steady_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity = (AppCompatActivity) view.getContext();

                fragment4th = new FragmentExercise4th();
                fragment4th.setArguments(bundle);

                transaction=activity.getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameExercise , fragment4th);
                transaction.addToBackStack("4th");
                transaction.commit();
            }
        });

        return view;

    }
}
