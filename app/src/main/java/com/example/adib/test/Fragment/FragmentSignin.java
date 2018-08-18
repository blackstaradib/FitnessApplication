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

public class FragmentSignin extends Fragment{

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("Vivz","onAttach Signin");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState==null)
        {
            Log.e("Vivz","onCreate First Time Signin");
        }
        else
        {
            Log.e("Vivz","onCreate SUBSEQUENT Time Signin");
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("Vivz","onCreateView Signin");
        return inflater.inflate(R.layout.activity_signin,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("Vivz","onActivityCreated Signin");
        super.onActivityCreated(savedInstanceState);
    }



    @Override
    public void onStart() {
        super.onStart();
        Log.e("Vivz","onStart Signin");

    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e("Vivz","onResume Signin");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("Vivz","onPause Signin");
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Vivz","onSaveInstanceState Signin");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.e("Vivz","onStop Signin");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("Vivz","onDestroyView Signin");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Vivz","onDestroy Signin");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("Vivz","onDetach Signin");
    }
}
