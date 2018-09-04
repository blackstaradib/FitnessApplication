package com.example.adib.test.FragmentExercise;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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
    private AnimationDrawable animationDrawable;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_exercise_4th, container, false);
        } catch (InflateException e) {
            e.printStackTrace();
        }

        ImageView imageView = view.findViewById(R.id.imageViewAnimation);
        animationDrawable = (AnimationDrawable) imageView.getDrawable();
        imageView.post(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
            }
        });


        bundle=getArguments();

        button=view.findViewById(R.id.button_exercise_current);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment5th = new FragmentExercise5th();
                fragment5th.setArguments(bundle);

                transaction = ((AppCompatActivity) view.getContext()).getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameExercise , fragment5th);
                transaction.addToBackStack("5th");
                transaction.commit();

            }
        });


        return view;

    }


}
