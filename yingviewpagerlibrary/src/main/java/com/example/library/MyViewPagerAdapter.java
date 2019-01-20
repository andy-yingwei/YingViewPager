package com.example.library;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

//处理Fragment和ViewPager的适配器
//FragmentPagerAdapter是PagerAdapter的子类，专门用于处理Fragment翻页的适配器。
//这个适配器最好用于有限个静态fragment页面的管理。尽管不可见的视图有时会被销毁，
//但用户所有访问过的fragment都会被保存在内存中。因此fragment实例会保存大量的各种状态，这就造成了很大的内存开销。
//所以如果要处理大量的页面切换，建议使用FragmentStatePagerAdapter
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> myFragmentList;

    public MyViewPagerAdapter(FragmentManager fragmentManager, List<Fragment> myFragmentList) {
        super(fragmentManager);
        this.myFragmentList=myFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return myFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return myFragmentList.size();
    }

}

