package com.example.adib.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.adib.test.Fragment.FragmentLogin;
import com.example.adib.test.Fragment.FragmentSignin;

/**
 * Created by ADIB on 19/05/2018.
 */


public class AdapterStart extends FragmentPagerAdapter
        implements  ViewPager.OnPageChangeListener{



    public AdapterStart(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //Log.e("vivz","Item is "+position);
        switch (position) {
            case 0: return new FragmentSignin();
            case 1: return new FragmentLogin();
        }
        return null;

    }



//    @Override
//    public boolean isViewFromObject(final View view, final Object object) {
//        return view.equals(object);
//    }
//
//    @Override
//    public void destroyItem(final View container, final int position, final Object object) {
//        ((ViewPager) container).removeView((View) object);
//    }

//    @Override
//    public Object instantiateItem(final ViewGroup container, final int position) {
//        final View view = new View(getBaseContext());
//        container.addView(view);
//        return view;
//    }

    @Override
    public int getCount() {
       // Log.e("vivz","Count is 2");
        return 2;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
