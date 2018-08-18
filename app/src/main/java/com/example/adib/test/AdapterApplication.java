package com.example.adib.test;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.example.adib.test.Fragment.FragmentAccont;
import com.example.adib.test.Fragment.FragmentExercise;
import com.example.adib.test.Fragment.FragmentFood;
import com.example.adib.test.Fragment.FragmentLogin;
import com.example.adib.test.Fragment.FragmentSignin;

/**
 * Created by ADIB on 23/07/2018.
 */


public class AdapterApplication extends FragmentPagerAdapter  {


    public AdapterApplication(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: return new FragmentAccont();
            case 1: return new FragmentExercise();
            case 2: return new FragmentFood();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 3;
    }

}



