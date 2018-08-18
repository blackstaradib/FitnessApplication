package com.example.adib.test;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adib.test.BackEnd.TypeExercise;
import com.example.adib.test.FragmentExercise.FragmentExerciseFirst;
import com.example.adib.test.FragmentExercise.FragmentExerciseSecond;

import java.util.LinkedList;

/**
 * Created by ADIB on 06/08/2018.
 */

public class AdapterCardListExerciseFirst extends RecyclerView.Adapter<AdapterCardListExerciseFirst.ViewHolder> {


    private LinkedList<TypeExercise> typeExercisesList=null;

    Fragment fragmentSecond;
    FragmentTransaction transaction;
    AppCompatActivity activity;

    public AdapterCardListExerciseFirst(LinkedList<TypeExercise> typeExercisesList){
        super();
        this.typeExercisesList=typeExercisesList;
    }


    @NonNull
    @Override
    public AdapterCardListExerciseFirst.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLayoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_listview_typeexercise,null);

        ViewHolder viewHolder=new ViewHolder(itemLayoutView);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {

        viewHolder.imageView.setImageResource(R.drawable.com_facebook_button_icon_blue);
        viewHolder.textView.setText(typeExercisesList.get(position).getName());
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity = (AppCompatActivity) view.getContext();
                fragmentSecond = new FragmentExerciseSecond();
                transaction=activity.getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameExercise , fragmentSecond);
                transaction.addToBackStack("second");
                transaction.commit();
                if(activity.getSupportActionBar()!=null) {
                    activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    activity.getSupportActionBar().setSubtitle("Second Fragment");
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return typeExercisesList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
        public LinearLayout button;


        public ViewHolder(View itemLayoutView) {

            super(itemLayoutView);
            imageView=itemLayoutView.findViewById(R.id.imageViewListview);
            textView=itemLayoutView.findViewById(R.id.textViewTitleListview);
            button=itemLayoutView.findViewById(R.id.buttonListview);
        }

    }


}
