package com.example.library;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.List;

public class GridViewPager extends LinearLayout {

    private MyViewPager myViewPager;
    private GridView myGridView;
    private GridViewAdapter myGridViewAdapter;

    public GridViewPager(Context context) {
        super(context);
    }


    public GridViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initView(Context context, final List<String> myTitleList, List<Fragment> myFragmentList, FragmentManager fragmentManager){
        LayoutInflater.from(getContext()).inflate(R.layout.gridviewpager, this);
        myViewPager = (MyViewPager) findViewById(R.id.gridviewpager_myViewPager);
        myGridView = (GridView) findViewById(R.id.gridviewpager_gridView);
        myGridViewAdapter=new GridViewAdapter(context,myTitleList);
        myGridView.setAdapter(myGridViewAdapter);
        MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter(fragmentManager,myFragmentList);
        myViewPager.setAdapter(myViewPagerAdapter);
        myGridViewAdapter.setOnItemClickLitener(new GridViewAdapter.ViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {//当标题选中显示指定的ViewPager
                myViewPager.setCurrentItem(position);
            }
        });

        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {//当ViewPager选中改变标题文字颜色
            @Override
            public void onPageSelected(int index) {
                myGridViewAdapter.onPageSelected(index);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) { }

            @Override
            public void onPageScrollStateChanged(int arg0) {}
        });

    }

    public void setGridViewColumnsNumber(int columnsNumber){
        myGridView.setNumColumns(columnsNumber);
    }

    //设置标题字体大小
    public void setTextSize(int textSize){
        myGridViewAdapter.setTextSize(textSize);
    }

    //设置标题字体选中时颜色-八位的十六进制：前二位是透明度，后六位是颜色Rgb
    public void setCheckTextColor(String stringCheckTextColor){
        myGridViewAdapter.setCheckTextColor(stringCheckTextColor);
    }

    //设置标题字体选中时颜色-int
    public void setCheckTextColor(int intCheckTextColor){
        myGridViewAdapter.setCheckTextColor(intCheckTextColor);
    }

    //设置标题字体未选中时颜色-八位的十六进制：前二位是透明度，后六位是颜色Rgb
    public void setUncheckTextColor(String stringUncheckTextColor){
        myGridViewAdapter.setUncheckTextColor(stringUncheckTextColor);
    }

    //设置标题字体未选中时颜色-int
    public void setUncheckTextColor(int intUncheckTextColor){
        myGridViewAdapter.setUncheckTextColor(intUncheckTextColor);
    }

    //设置下划线颜色-int
    public void setLineColor(int LineColor){
        myGridViewAdapter.setLineColor(LineColor);
    }

    //设置标题背景色-八位的十六进制：前二位是透明度，后六位是颜色Rgb
    public void setTitleBackgruand(String color){
        myGridView.setBackgroundColor(Color.parseColor(color));
    }

    //设置标题背景色-int
    public void setTitleBackgruand(int color){
        myGridView.setBackgroundColor(color);
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


