package com.example.adib.test.FragmentExercise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.adib.test.AdapterCardListExerciseSecond;
import com.example.adib.test.BackEnd.Exercise;
import com.example.adib.test.R;

import java.util.LinkedList;

/**
 * Created by ADIB on 08/08/2018.
 */

public class FragmentExerciseSecond extends Fragment {



    private View view=null;

    private LinkedList<Exercise> ExerciseList = null;

    private Button buttonExercise=null;

    Fragment fragmentThird;
    FragmentTransaction transaction;
    AppCompatActivity activity;

    Bundle bundle;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_exercise_second,container,false);

        ExerciseList=new LinkedList<>();
        ExerciseList.add(new Exercise("AAAAAA",5));
        ExerciseList.add(new Exercise("BBBBBB",8));
        ExerciseList.add(new Exercise("CCCCCC",2));
        ExerciseList.add(new Exercise("DDDDDD",6));
//        ExerciseList.add(new Exercise("EEEEEE",4));
//        ExerciseList.add(new Exercise("FFFFFF",11));
//        ExerciseList.add(new Exercise("AAAAAA",5));
//        ExerciseList.add(new Exercise("BBBBBB",8));
//        ExerciseList.add(new Exercise("CCCCCC",2));
//        ExerciseList.add(new Exercise("DDDDDD",6));
//        ExerciseList.add(new Exercise("EEEEEE",4));
//        ExerciseList.add(new Exercise("FFFFFF",11));

        RecyclerView recyclerView=view.findViewById(R.id.recyclerViewListviewExercise);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        AdapterCardListExerciseSecond adapterCardListExerciseSecond =new AdapterCardListExerciseSecond(ExerciseList);
        recyclerView.setAdapter(adapterCardListExerciseSecond);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.line_listview));
        recyclerView.addItemDecoration(dividerItemDecoration);

        buttonExercise=view.findViewById(R.id.button_exercise_start);
        buttonExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity = (AppCompatActivity) view.getContext();

                bundle=new Bundle();
                bundle.putInt("count_exercise",ExerciseList.size());

                fragmentThird = new FragmentExerciseThird();
                fragmentThird.setArguments(bundle);

                transaction=activity.getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameExercise , fragmentThird);
                transaction.addToBackStack("third");
                transaction.commit();
            }
        });

        return view;
    }

    }
