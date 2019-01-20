package com.example.library;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewPager extends LinearLayout {

    private MyViewPager myViewPager;
    private RecyclerView myRecyclerView;
    private RecyclerViewAdapter myRecyclerViewAdapter;

    public RecyclerViewPager(Context context) {
        super(context);
    }


    public RecyclerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initView(final List<String> myTitleList, List<Fragment> myFragmentList, FragmentManager fragmentManager){
        LayoutInflater.from(getContext()).inflate(R.layout.recyclerviewpager, this);
        myViewPager = (MyViewPager) findViewById(R.id.recyclerviewpager_myViewPager);
        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewpager_recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerViewAdapter =new RecyclerViewAdapter(myTitleList);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
        MyViewPagerAdapter myViewPagerAdapter =new MyViewPagerAdapter(fragmentManager,myFragmentList);
        myViewPager.setAdapter(myViewPagerAdapter);
        myRecyclerViewAdapter.setOnItemClickLitener(new RecyclerViewAdapter.ViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, TextView textView, int position) {//当标题选中显示指定的ViewPager
                myViewPager.setCurrentItem(position);
            }
        });

        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {//当ViewPager选中改变标题文字颜色
            @Override
            public void onPageSelected(int index) {
                myRecyclerViewAdapter.onPageSelected(index);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) { }

            @Override
            public void onPageScrollStateChanged(int arg0) {}
        });

    }

    //设置标题字体大小
    public void setTextSize(int textSize){
        myRecyclerViewAdapter.setTextSize(textSize);
    }

    //设置标题字体选中时颜色-八位的十六进制：前二位是透明度，后六位是颜色Rgb
    public void setCheckTextColor(String stringCheckTextColor){
        myRecyclerViewAdapter.setCheckTextColor(stringCheckTextColor);
    }

    //设置标题字体选中时颜色-int
    public void setCheckTextColor(int intCheckTextColor){
        myRecyclerViewAdapter.setCheckTextColor(intCheckTextColor);
    }

    //设置标题字体未选中时颜色-八位的十六进制：前二位是透明度，后六位是颜色Rgb
    public void setUncheckTextColor(String stringUncheckTextColor){
        myRecyclerViewAdapter.setUncheckTextColor(stringUncheckTextColor);
    }

    //设置标题字体未选中时颜色-int
    public void setUncheckTextColor(int intUncheckTextColor){
        myRecyclerViewAdapter.setUncheckTextColor(intUncheckTextColor);
    }

    //设置下划线颜色-int
    public void setLineColor(int LineColor){
        myRecyclerViewAdapter.setLineColor(LineColor);
    }

    //设置标题背景色-八位的十六进制：前二位是透明度，后六位是颜色Rgb
    public void setTitleBackgruand(String color){
        myRecyclerView.setBackgroundColor(Color.parseColor(color));
    }

    //设置标题背景色-int
    public void setTitleBackgruand(int color){
        myRecyclerView.setBackgroundColor(color);
    }

    //设置ViewPager是否能滑动
    public void setScanScroll(boolean isCanScroll) {
        myViewPager.setScanScroll(isCanScroll);
    }

    //设置ViewPager是否能具有滑动动画效果
    public void setSmoothScroll(boolean isSmoothScroll) {
        myViewPager.setSmoothScroll(isSmoothScroll);
    }

}


