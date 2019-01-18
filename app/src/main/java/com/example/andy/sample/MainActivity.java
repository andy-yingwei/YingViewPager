package com.example.andy.sample;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.library.GridViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridViewPager myGridViewPagerr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> myTitleList = new ArrayList<>();
        myTitleList.add("1");
        myTitleList.add("2");
        myTitleList.add("3");
        myTitleList.add("4");

        List<Fragment> myFragmentList=new ArrayList<Fragment>();
        myFragmentList.add(new Fragment_One());
        myFragmentList.add(new Fragment_Two());
        myFragmentList.add(new Fragment_Three());
        myFragmentList.add(new Fragment_Four());
        myGridViewPagerr = (GridViewPager) findViewById(R.id.gridViewPager);
        myGridViewPagerr.initView(MainActivity.this,myTitleList,myFragmentList,getSupportFragmentManager());
        myGridViewPagerr.setGridViewColumnsNumber(4);
        myGridViewPagerr.setTextSize(18);
        myGridViewPagerr.setTitleBackgruand("#F9FBE9E7");
        myGridViewPagerr.setCheckTextColor(Color.BLUE);
        myGridViewPagerr.setUncheckTextColor(Color.GRAY);
        myGridViewPagerr.setLineColor(Color.BLUE);

        myGridViewPagerr.setScanScroll(false);
        myGridViewPagerr.setSmoothScroll(false);
    }
}