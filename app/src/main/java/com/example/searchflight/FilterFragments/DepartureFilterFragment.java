package com.example.searchflight.FilterFragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.searchflight.R;

public class DepartureFilterFragment extends Fragment {

    CheckBox earlyMorning, morning, midDay, evening, night;
    private SharedPreferences prefs;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String CHECKBOX_KEY = "checkBoxState";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_departure_filter, container, false);

        earlyMorning = view.findViewById(R.id.EarlyMorningCHK);

        prefs = getActivity().getSharedPreferences(PREFS_NAME, 0);

        boolean isChecked = prefs.getBoolean(CHECKBOX_KEY, false);
        earlyMorning.setChecked(isChecked);

        earlyMorning.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(CHECKBOX_KEY, isChecked_);
            editor.apply();
        });

        return view;
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        earlyMorning = getView().findViewById(R.id.EarlyMorningCHK);
        outState.putBoolean(String.valueOf(earlyMorning), earlyMorning.isChecked());

    }

}