package com.example.hp.oouattendance;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity
        implements RegFragmentOne.OnFragmentInteractionListener,
                    RegFragmentTwo.OnFragmentInteractionListener{


    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = findViewById(R.id.reg_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        TabLayout tabLayout = new TabLayout(this);
        viewPager = findViewById(R.id.reg_view_pager);
        final RegViewPager regViewPager = new RegViewPager(getSupportFragmentManager(), 2);
        viewPager.setAdapter(regViewPager);
        viewPager.setCurrentItem(0);
        viewPager.canScrollHorizontally(ViewPager.SCROLL_AXIS_NONE);

//        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
////                viewPager.setCurrentItem(tab.getPosition());
//                regViewPager.getItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });


//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//                String message = "Sorry, press \"next\" button or \"back\" button";
//                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
//                viewPager.setCurrentItem(regViewPager.getItemPosition(i1));
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//                viewPager.setCurrentItem(regViewPager.getItemPosition(i));
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
