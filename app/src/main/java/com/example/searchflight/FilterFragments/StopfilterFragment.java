package com.example.searchflight.FilterFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.searchflight.R;

import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StopfilterFragment} factory method to
 * create an instance of this fragment.
 */
public class StopfilterFragment extends Fragment {
    CheckBox Nonstopchk, onestopchhk, oneplustopchk;
    TextView Nonstop, onestop, oneplusStop;



    public StopfilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
      View  view = inflater.inflate(R.layout.fragment_stopfilter, container, false);

        Nonstop = view.findViewById(R.id.DepartueNonStop);
        onestop = view.findViewById(R.id.DepartueOneStop);
        oneplusStop = view.findViewById(R.id.DepartueOnePlusStop);
        Nonstopchk = view.findViewById(R.id.departureNonStopChk);
        onestopchhk = view.findViewById(R.id.departureOneStopChk);
        onestopchhk = view.findViewById(R.id.departureOneStopChk);

        Nonstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;
    }
}