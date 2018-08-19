package com.example.adib.test.FragmentExercise;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.adib.test.AdapterCardListExerciseFirst;
import com.example.adib.test.AdapterRecyclerViewCalender;
import com.example.adib.test.BackEnd.TypeExercise;
import com.example.adib.test.R;

import java.util.LinkedList;

/**
 * Created by ADIB on 04/08/2018.
 */


public class FragmentExerciseFirst extends Fragment {

    private View view=null;

    int index;

    LinkedList<TypeExercise> typeExerciseList = null;

    LinearLayout buttonSelectDay =null;

    Dialog dialog;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        Bundle bundle=getArguments();
        index=bundle.getInt("index");
        view=inflater.inflate(R.layout.fragment_exercise_first,container,false);

        typeExerciseList=new LinkedList<>();
        typeExerciseList.add(new TypeExercise(55,"تمارين الجسم بالكامل"));
        typeExerciseList.add(new TypeExercise(212,"تمارين البطن"));
        typeExerciseList.add(new TypeExercise(545,"تمارين الأرداف"));
        typeExerciseList.add(new TypeExercise(789,"تمارين الذراعين"));
        typeExerciseList.add(new TypeExercise(492,"تمارين الساقين"));
        typeExerciseList.add(new TypeExercise(55,"تمارين الجسم بالكامل"));
        typeExerciseList.add(new TypeExercise(212,"تمارين البطن"));
        typeExerciseList.add(new TypeExercise(545,"تمارين الأرداف"));
        typeExerciseList.add(new TypeExercise(789,"تمارين الذراعين"));
        typeExerciseList.add(new TypeExercise(492,"تمارين الساقين"));

        RecyclerView recyclerView=view.findViewById(R.id.recyclerViewListviewTypeExercise);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        AdapterCardListExerciseFirst adapterCardListExerciseFirst =new AdapterCardListExerciseFirst(typeExerciseList);
        recyclerView.setAdapter(adapterCardListExerciseFirst);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        buttonSelectDay=view.findViewById(R.id.button_calender_select_day);
        buttonSelectDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.dialog_calender);
                RecyclerView recyclerViewDialogCalender =dialog.findViewById(R.id.recyclerViewCalender);
                GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),6);
                recyclerViewDialogCalender.setLayoutManager(gridLayoutManager);
                AdapterRecyclerViewCalender adapterRecyclerViewCalender =new AdapterRecyclerViewCalender(view,dialog);
                recyclerViewDialogCalender.setAdapter(adapterRecyclerViewCalender);
                recyclerViewDialogCalender.setItemAnimator(new DefaultItemAnimator());
                dialog.show();
                Button button = dialog.findViewById(R.id.button_calender_cancel_day);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();
                    }
                });

            }
        });



        return view;

    }


}
