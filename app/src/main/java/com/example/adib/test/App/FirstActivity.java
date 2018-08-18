package com.example.adib.test.App;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.adib.test.AdapterApplication;
import com.example.adib.test.R;

public class FirstActivity extends AppCompatActivity {

    ViewPager ViewPager=null;

    AdapterApplication adapterApplication=null;

    BottomNavigationView navigation;


    int target_id;

    boolean isStart=false;

    int level_id;

    int currentValue;

    int targetValue;

    MenuItem prevMenuItem;

    Toolbar toolbar;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();

        target_id=bundle.getInt("target_id");
        level_id=bundle.getInt("level_id");
        isStart=bundle.getBoolean("isstart");
        currentValue=bundle.getInt("current_value_weight");
        targetValue=bundle.getInt("target_value_weight");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Main Page");
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        toolbar.inflateMenu(R.menu.main_menu);

        navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_accont:
                        ViewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_exercise:
                        ViewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_food:
                        ViewPager.setCurrentItem(2);
                        return true;
                    default:
                        return FirstActivity.super.onOptionsItemSelected(item);
                }
            }
        });


        ViewPager = findViewById(R.id.viewpagerfirst);

        FragmentManager fragmentManager=this.getSupportFragmentManager();

        adapterApplication=new AdapterApplication(fragmentManager);

        ViewPager.setAdapter(adapterApplication);

        ViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }

                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getSupportFragmentManager().getBackStackEntryCount() > 1 ) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    onBackPressed();
                }
                else {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    getSupportActionBar().setSubtitle("");
                    onBackPressed();
                }
            }
        });

//        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
//            @Override
//            public void onBackStackChanged() {
//                if(getSupportFragmentManager().getBackStackEntryCount()>0) {
//                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//                }
//            }
//
//    });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent;
                Bundle bundle;

                switch (item.getItemId()) {
                    case R.id.menu_target:
                        bundle = new Bundle();
                        bundle.putBoolean("isstart", false);
                        intent = new Intent(FirstActivity.this, Target_Activity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        return true;
                    case R.id.menu_level:
                        bundle = new Bundle();
                        bundle.putBoolean("isstart", false);
                        intent = new Intent(FirstActivity.this, Level_Activity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }





}
