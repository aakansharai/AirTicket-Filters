package com.example.searchflight;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.searchflight.FilterFragments.AirlineFilterFragment;
import com.example.searchflight.FilterFragments.ArrivalFilterFragment;
import com.example.searchflight.FilterFragments.DepartureFilterFragment;
import com.example.searchflight.FilterFragments.PriceFilterfragment;
import com.example.searchflight.FilterFragments.StopfilterFragment;

import java.util.HashMap;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private HashMap<Integer, Fragment> mPageReferenceMap = new HashMap<>();

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        // Return the appropriate fragment instance based on the position
        switch (position) {
            case 0:
                return new StopfilterFragment();
            case 1:
                return new DepartureFilterFragment();
            case 2:
                return new ArrivalFilterFragment();
            case 3:
                return new PriceFilterfragment();
            case 4:
                return new AirlineFilterFragment();
            default:
                return new StopfilterFragment();
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mPageReferenceMap.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        mPageReferenceMap.remove(position);
    }

    public Fragment getFragment(int key) {
        return mPageReferenceMap.get(key);
    }

    @Override
    public int getCount() {
        return 5; // Total number of fragments
    }
}