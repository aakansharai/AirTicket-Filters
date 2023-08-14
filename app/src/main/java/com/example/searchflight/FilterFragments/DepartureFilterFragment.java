package com.example.searchflight.FilterFragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.searchflight.R;

public class DepartureFilterFragment extends Fragment {

    CheckBox earlyMorning, morning, midDay, evening, night;
    private SharedPreferences prefs, pref1, prefMD, prefE, prefN;

    private static final String PREFS_NAME = "MyPrefsD";
    private static final String CHECKBOX_KEY = "checkBoxStateD";
    private static final String PREFS_NAME1 = "MyPrefsDMorning";
    private static final String CHECKBOX_KEY1 = "checkBoxStateDMorning";
    private static final String PREFS_NAME_MIDDAY = "MyPrefsD_MidDay";
    private static final String CHECKBOX_KEY1_MIDDAY = "checkBoxStateD_MidDay";
    private static final String PREFS_NAME_EVENING = "MyPrefsD_eve";
    private static final String CHECKBOX_KEY1_EVENING = "checkBoxStateD_eve";
    private static final String PREFS_NAME_NIGHT = "MyPrefsD_night";
    private static final String CHECKBOX_KEY1_NIGHT = "checkBoxStateD_night";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_departure_filter, container, false);

        earlyMorning = view.findViewById(R.id.EarlyMorningCHK);
        morning = view.findViewById(R.id.morningChk);
        midDay = view.findViewById(R.id.MidDayChk);
        evening = view.findViewById(R.id.EveningChk);
        night = view.findViewById(R.id.Nightchk);

        prefs = getActivity().getSharedPreferences(PREFS_NAME, 0);
        pref1 = getActivity().getSharedPreferences(PREFS_NAME1, 0);
        prefMD = getActivity().getSharedPreferences(PREFS_NAME_MIDDAY, 0);
        prefE = getActivity().getSharedPreferences(PREFS_NAME_EVENING, 0);
        prefN = getActivity().getSharedPreferences(PREFS_NAME_NIGHT, 0);

        boolean isChecked = prefs.getBoolean(CHECKBOX_KEY, false);
        boolean isCheckedMorning = pref1.getBoolean(CHECKBOX_KEY1, false);
        boolean isCheckedMidDay = prefMD.getBoolean(CHECKBOX_KEY1_MIDDAY, false);
        boolean isCheckedEvening = prefE.getBoolean(CHECKBOX_KEY1_EVENING, false);
        boolean isCheckedNight = prefN.getBoolean(CHECKBOX_KEY1_NIGHT, false);

        earlyMorning.setChecked(isChecked);
        morning.setChecked(isCheckedMorning);
        midDay.setChecked(isCheckedMidDay);
        evening.setChecked(isCheckedEvening);
        night.setChecked(isCheckedNight);

        earlyMorning.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(CHECKBOX_KEY, isChecked_);
            editor.apply();
        });
        morning.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = pref1.edit();
            editor.putBoolean(CHECKBOX_KEY1, isChecked_);
            editor.apply();
        });
        midDay.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefMD.edit();
            editor.putBoolean(CHECKBOX_KEY1_MIDDAY, isChecked_);
            editor.apply();
        });
        evening.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefE.edit();
            editor.putBoolean(CHECKBOX_KEY1_EVENING, isChecked_);
            editor.apply();
        });
        night.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefN.edit();
            editor.putBoolean(CHECKBOX_KEY1_NIGHT, isChecked_);
            editor.apply();
        });

        return view;
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        earlyMorning = getView().findViewById(R.id.EarlyMorningCHK);
        morning = getView().findViewById(R.id.morningChk);
        outState.putBoolean(String.valueOf(earlyMorning), earlyMorning.isChecked());
        outState.putBoolean(String.valueOf(morning), morning.isChecked());

    }

}