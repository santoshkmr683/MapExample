package com.maplist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.maplist.fragment.NearPlaceListFragment;

import java.util.ArrayList;

/**
 * Created by santosh on 8/6/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;
    private ArrayList<String> mList;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, ArrayList<String> arrayList) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.mList = arrayList;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                NearPlaceListFragment tab1 = NearPlaceListFragment.getInstance(mList);
                return tab1;
            case 1:
                NearPlaceListFragment tab2 = NearPlaceListFragment.getInstance(mList);
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
