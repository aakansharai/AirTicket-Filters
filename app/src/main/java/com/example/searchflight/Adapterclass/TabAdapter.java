package com.example.searchflight.Adapterclass;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.searchflight.ArrivalTabFragment;
import com.example.searchflight.DepartureTabFragment;

public  class TabAdapter extends FragmentStateAdapter {

    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public TabAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DepartureTabFragment();
            case 1:
                return new ArrivalTabFragment();

            default:
                return new DepartureTabFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
