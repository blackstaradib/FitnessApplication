package com.example.adib.test.Fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adib.test.FragmentExercise.FragmentExerciseFirst;
import com.example.adib.test.FragmentExercise.FragmentExerciseSecond;
import com.example.adib.test.R;

public class FragmentExercise extends Fragment {


    Fragment fragmentFirst;
    FragmentTransaction transaction;
    Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_exercise,container,false);

        fragmentFirst=new FragmentExerciseFirst();
        transaction = getChildFragmentManager().beginTransaction();
        bundle=new Bundle();
        bundle.putInt("index",0);
        fragmentFirst.setArguments(bundle);

        transaction.add(R.id.frameExercise,fragmentFirst,"first");
        transaction.addToBackStack("first");
        transaction.commit();

        return view;
    }


}