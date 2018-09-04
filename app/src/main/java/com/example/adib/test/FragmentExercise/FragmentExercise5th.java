package com.example.adib.test.FragmentExercise;

import android.annotation.SuppressLint;
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
import android.widget.TextView;

import com.example.adib.test.R;

/**
 * Created by ADIB on 12/08/2018.
 */

@SuppressLint("ValidFragment")
public class FragmentExercise5th extends Fragment {


    private View view=null;

    private Button button=null;

    private Bundle bundle;

    private int countExercise;

    Fragment fragment4thor6th;
    FragmentTransaction transaction;

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_exercise_5th,container,false);

        bundle=getArguments();
        countExercise=bundle.getInt("count_exercise");
        countExercise--;

        button=view.findViewById(R.id.button_exercise_next);
        textView = view.findViewById(R.id.textView_exercise_next);
        if (countExercise!=0) {
            button.setText("استمرار");
            textView.setText("التمرين التالي");
        }
        else {
            button.setText("انهاء");
            textView.setText("تم إنهاء التمارين");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (countExercise!=0) {
                    bundle=new Bundle();
                    bundle.putInt("count_exercise",countExercise);
                    fragment4thor6th = new FragmentExercise4th();
                    fragment4thor6th.setArguments(bundle);

                    transaction = ((AppCompatActivity) view.getContext()).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameExercise, fragment4thor6th);
                    transaction.commit();

                }
                else {
                    ((AppCompatActivity) view.getContext()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    FragmentManager fragmentManager = ((AppCompatActivity) view.getContext()).getSupportFragmentManager();
                    String name = fragmentManager.getBackStackEntryAt(0).getName();
                    fragmentManager.popBackStackImmediate(name,FragmentManager.POP_BACK_STACK_INCLUSIVE);

                    fragment4thor6th = new FragmentExercise6th();

                    transaction = ((AppCompatActivity) view.getContext()).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameExercise, fragment4thor6th);
                    transaction.commit();

                }

            }
        });

        return view;

    }
}
