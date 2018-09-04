package com.example.adib.test.FragmentExercise;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.adib.test.R;

/**
 * Created by ADIB on 12/08/2018.
 */


public class FragmentExercise6th extends Fragment {


    private View view = null;

    private Button button = null;

    private Bundle bundle;

    private int countExercise;

    Fragment fragment4thor6th;
    FragmentTransaction transaction;

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_exercise_6th, container, false);

        return view;

    }
}
