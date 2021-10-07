package com.android.fury.a30day.food;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by fury on 9/1/2016.
 */
public class food_page_org_viewpager extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{food_page_org.d, food_page_org.c};

    public food_page_org_viewpager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        return food_page_org_1.newInstance(position + 1);

    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}