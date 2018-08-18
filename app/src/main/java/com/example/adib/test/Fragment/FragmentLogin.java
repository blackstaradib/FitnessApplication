package com.example.adib.test.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adib.test.R;


/**
 * Created by ADIB on 18/05/2018.
 */

public class FragmentLogin extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("Vivz","onAttach Login");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState==null)
        {
            Log.e("Vivz","onCreate First Time Login");
        }
        else
        {
            Log.e("Vivz","onCreate SUBSEQUENT Time Login");
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("Vivz","onCreateView Login");
        return inflater.inflate(R.layout.activity_login,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("Vivz","onActivityCreated Login");
        super.onActivityCreated(savedInstanceState);
    }



    @Override
    public void onStart() {
        super.onStart();
        Log.e("Vivz","onStart Login");

    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e("Vivz","onResume Login");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("Vivz","onPause Login");
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Vivz","onSaveInstanceState Login");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.e("Vivz","onStop Login");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("Vivz","onDestroyView Login");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Vivz","onDestroy Login");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("Vivz","onDetach Login");
    }
}
