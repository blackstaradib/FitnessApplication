package com.example.adib.test;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.adib.test.App.FirstActivity;
import com.example.adib.test.App.Target_Activity;
import com.gigamole.navigationtabstrip.NavigationTabStrip;


public class Start_Activity extends FragmentActivity {

    ViewPager ViewPager=null;

    AdapterStart myadapter=null;

    NavigationTabStrip nts=null;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_);

        ViewPager =  findViewById(R.id.viewpager);

        FragmentManager fragmentManager=getSupportFragmentManager();

        myadapter=new AdapterStart(fragmentManager);

        ViewPager.setAdapter(myadapter);


        ViewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                IBinder binder = view.getWindowToken();
                inputManager.hideSoftInputFromWindow(binder,InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        nts =  findViewById(R.id.nts);

        nts.setViewPager(ViewPager, 2);

//        final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts);
//        navigationTabStrip.setTitles("Nav", "Tab", "Strip");
//        navigationTabStrip.setTabIndex(0, true);
        nts.setTitleSize(40);
//        navigationTabStrip.setStripColor(Color.RED);
//        navigationTabStrip.setStripWeight(6);
//        navigationTabStrip.setStripFactor(2);
//        navigationTabStrip.setStripType(NavigationTabStrip.StripType.LINE);
//        navigationTabStrip.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
//        navigationTabStrip.setTypeface("fonts/typeface.ttf");
//        navigationTabStrip.setCornersRadius(3);
        nts.setAnimationDuration(250);
//        navigationTabStrip.setInactiveColor(Color.GRAY);
//        navigationTabStrip.setActiveColor(Color.WHITE);
//        navigationTabStrip.setOnPageChangeListener(...);
      //  nts.setOnTabStripSelectedIndexListener(mViewPager.);

    }


    public void clicksigninbut(View view)
    {
        Bundle bundle=new Bundle();
        bundle.putBoolean("isstart",true);
        Intent intent = new Intent(this,Target_Activity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }


    public void clickloginbut(View view)
    {
        Bundle bundle=new Bundle();
        bundle.putBoolean("isstart",false);
        Intent intent = new Intent(this,FirstActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }


}

