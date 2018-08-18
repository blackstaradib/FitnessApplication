package com.example.adib.test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adib.test.BackEnd.Exercise;

import java.util.LinkedList;

/**
 * Created by ADIB on 08/08/2018.
 */

public class AdapterCardListExerciseSecond extends RecyclerView.Adapter<AdapterCardListExerciseSecond.ViewHolder> {



    private LinkedList<Exercise> ExercisesList=null;


    public AdapterCardListExerciseSecond(LinkedList<Exercise> ExercisesList){
        super();
        this.ExercisesList=ExercisesList;
    }

    @NonNull
    @Override
    public AdapterCardListExerciseSecond.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLayoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_listview_exercise,null);

        ViewHolder viewHolder=new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCardListExerciseSecond.ViewHolder viewholder, int position) {

        viewholder.textViewExercise.setText(ExercisesList.get(position).getExercise_name());
        viewholder.textViewCount.setText(Integer.toString(ExercisesList.get(position).getCount()));

    }

    @Override
    public int getItemCount() {
        return ExercisesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewExercise;
        public TextView textViewCount;

        public ViewHolder(View itemLayoutView){

            super(itemLayoutView);
            textViewExercise= itemLayoutView.findViewById(R.id.textViewTitleListviewExercise);
            textViewCount= itemLayoutView.findViewById(R.id.listviewExerciseCount);
        }

    }
}
