package com.example.hp.oouattendance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class RegViewPager extends FragmentStatePagerAdapter {
    int noOfPages;

    public RegViewPager(FragmentManager fm, int noOfPages) {
        super(fm);
        this.noOfPages = noOfPages;
    }


    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                RegFragmentOne regFragOne = new RegFragmentOne();
                return regFragOne;
            case 1:
                RegFragmentTwo regFragTwo = new RegFragmentTwo();
                return regFragTwo;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noOfPages;
    }
}
