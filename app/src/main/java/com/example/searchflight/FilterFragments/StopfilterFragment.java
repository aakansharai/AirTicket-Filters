package com.example.searchflight.FilterFragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.searchflight.R;

import java.util.Collections;

public class StopfilterFragment extends Fragment {
    CheckBox nonStop, oneStop, onePlusStop;
//    TextView Nonstop, onestop, oneplusStop;
    Bundle bundle = new Bundle();
    int STOP_CODE;
    private SharedPreferences prefsNonStop, prefOneStop, prefMoreThenOne;

    private static final String PREFS_NAME_NON = "MyPrefs_NonSTOP";
    private static final String CHECKBOX_KEY_NON = "checkBoxState_NonStop";
    private static final String PREFS_NAME_ONE = "MyPrefs_OneSTOP";
    private static final String CHECKBOX_KEY_ONE = "checkBoxState_OneStop";
    private static final String PREFS_NAME_MORE = "MyPrefs_MoreSTOP";
    private static final String CHECKBOX_KEY_MORE = "checkBoxState_MoreStop";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
      View  view = inflater.inflate(R.layout.fragment_stopfilter, container, false);

        nonStop = view.findViewById(R.id.departureNonStopChk);
        oneStop = view.findViewById(R.id.departureOneStopChk);
        onePlusStop = view.findViewById(R.id.departureOnePlusStopChk);

        if (nonStop.isChecked()) {
            if (oneStop.isChecked() && onePlusStop.isChecked()) {
                STOP_CODE = 1111;
            } else if (oneStop.isChecked()) {
                STOP_CODE = 1212;
            } else if (onePlusStop.isChecked()) {
                STOP_CODE = 1313;
            } else {
                STOP_CODE = 3200;
            }
        } else if (oneStop.isChecked()) {
            if (onePlusStop.isChecked()) {
                STOP_CODE = 2323;
            } else {
                STOP_CODE = 3300;
            }
        } else if (onePlusStop.isChecked()) {
            STOP_CODE = 3400;
        }



//==============  S H A R E D  -  P R E F E R E N C E  --  F R A G M E N T S =================

         prefsNonStop = getActivity().getSharedPreferences(PREFS_NAME_ONE, 0);
         prefOneStop = getActivity().getSharedPreferences(PREFS_NAME_ONE, 0);
         prefMoreThenOne = getActivity().getSharedPreferences(PREFS_NAME_MORE, 0);

        boolean isCheckedNone = prefsNonStop.getBoolean(CHECKBOX_KEY_NON, true);
        boolean isCheckedOne = prefOneStop.getBoolean(CHECKBOX_KEY_ONE, false);
        boolean isCheckedMore = prefMoreThenOne.getBoolean(CHECKBOX_KEY_MORE, false);

        nonStop.setChecked(isCheckedNone);
        oneStop.setChecked(isCheckedOne);
        onePlusStop.setChecked(isCheckedMore);

        nonStop.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefsNonStop.edit();
            editor.putBoolean(CHECKBOX_KEY_NON, isChecked_);
            editor.apply();
        });
        oneStop.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefOneStop.edit();
            editor.putBoolean(CHECKBOX_KEY_ONE, isChecked_);
            editor.apply();
        });
        onePlusStop.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefMoreThenOne.edit();
            editor.putBoolean(CHECKBOX_KEY_MORE, isChecked_);
            editor.apply();
        });

//        bundle = getActivity().getIntent().getExtras();
//        assert bundle != null;
//        bundle.putInt("REQUEST-CODE_STOP", 123);
//        this.setArguments(bundle);

        return view;
    }
}