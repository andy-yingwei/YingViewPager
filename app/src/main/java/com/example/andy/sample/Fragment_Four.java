package com.example.andy.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.library.RecyclerViewPager;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Four extends Fragment {

    private View myView;
    private RecyclerViewPager myRecyclerViewPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_four, null);
        List<String> myTitleList = new ArrayList<>();
        myTitleList.add("4-1");
        myTitleList.add("4-2");
        myTitleList.add("4-3");
        myTitleList.add("4-4");

        List<Fragment> myFragmentList=new ArrayList<Fragment>();
        myFragmentList.add(new Fragment_1());
        myFragmentList.add(new Fragment_2());
        myFragmentList.add(new Fragment_3());
        myFragmentList.add(new Fragment_4());
        //Fragment嵌套Fragment使用getChildFragmentManager()
        myRecyclerViewPager = (RecyclerViewPager) myView.findViewById(R.id.recyclerViewPager_four);
        myRecyclerViewPager.initView(myTitleList,myFragmentList,getChildFragmentManager());
        myRecyclerViewPager.setTextSize(18);
        myRecyclerViewPager.setTitleBackgruand("#F9FBE9E7");
        myRecyclerViewPager.setCheckTextColor(Color.BLUE);
        myRecyclerViewPager.setUncheckTextColor(Color.GRAY);
        myRecyclerViewPager.setLineColor(Color.BLUE);

        myRecyclerViewPager.setScanScroll(true);
        myRecyclerViewPager.setSmoothScroll(false);
        return myView;
    }
}
