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

public class FragmentExercise4th extends Fragment {


    private View view=null;

    private Button button=null;

    private Bundle bundle;

    Fragment fragment5th;
    FragmentTransaction transaction;
    AppCompatActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_exercise_4th,container,false);

        bundle=getArguments();

        button=view.findViewById(R.id.button_exercise_current);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity = (AppCompatActivity) view.getContext();

                fragment5th = new FragmentExercise5th();
                fragment5th.setArguments(bundle);

                transaction=activity.getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameExercise , fragment5th);
                transaction.addToBackStack("5th");
                transaction.commit();

            }
        });

        return view;

    }
}
