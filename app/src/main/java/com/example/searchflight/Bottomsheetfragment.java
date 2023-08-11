package com.example.searchflight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.searchflight.Adapterclass.TabAdapter;
import com.example.searchflight.FilterFragments.DepartureFilterFragment;
import com.example.searchflight.FilterFragments.StopfilterFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bottomsheetfragment} factory method to
 * create an instance of this fragment.
 */
public class Bottomsheetfragment extends BottomSheetDialogFragment {

TabLayout tabLayout;
ViewPager2 viewPager2;
TabAdapter adapter;
ImageView crossimage;
    private ViewPager viewPager;
FrameLayout frameLayout;

    public Bottomsheetfragment() {
        // Required empty public constructor
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                BottomSheetDialog d = (BottomSheetDialog) dialog;
                View bottomSheetInternal = d.findViewById(com.google.android.material.R.id.design_bottom_sheet);
                BottomSheetBehavior.from(bottomSheetInternal).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
                // Inflate the layout for this fragment
                View view = inflater.inflate(R.layout.fragment_bottomsheetfragment, container, false);



                tabLayout = view.findViewById(R.id.tablayout);
                viewPager2 = view.findViewById(R.id.viewpager);
//                viewPager = view.findViewById(R.id.viewpager);
                crossimage = view.findViewById(R.id.closeimage);

                frameLayout= view.findViewById(R.id.fraamelayoutStopfilter);

                tabLayout.addTab(tabLayout.newTab().setText("Departure"));
                tabLayout.addTab(tabLayout.newTab().setText("Arrival"));
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();


//        ViewPagerAdapter adapter = new ViewPagerAdapter(requireActivity().getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
//
//        int index = viewPager.getCurrentItem();
//        DepartureTabFragment tabFragment = (DepartureTabFragment) adapter.getFragment(index);





                adapter = new TabAdapter(fragmentManager, getLifecycle());
                viewPager2.setAdapter(adapter);

                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager2.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                    }
                });
                viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                    private int position;

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        tabLayout.selectTab(tabLayout.getTabAt(position));
                    }
                });


                crossimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

        return view;

            }



        }










