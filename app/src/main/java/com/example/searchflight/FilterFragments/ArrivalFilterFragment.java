package com.example.searchflight.FilterFragments;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.searchflight.MainActivity;
import com.example.searchflight.R;

import java.util.Objects;

public class ArrivalFilterFragment extends Fragment {

    private CheckBox earlyMorning, morning, midDay, Evening, night;
    private SharedPreferences prefs, pref1, prefMD, prefE, prefN ;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String CHECKBOX_KEY = "checkBoxState";
    private static final String PREFS_NAME1 = "MyPrefs1";
    private static final String CHECKBOX_KEY1 = "checkBoxState1";
    private static final String PREFS_NAME_MIDDAY = "MyPrefs_md";
    private static final String CHECKBOX_KEY1_MIDDAY = "checkBoxState1_md";
    private static final String PREFS_NAME_EVENING = "MyPrefs_eve";
    private static final String CHECKBOX_KEY1_EVENING = "checkBoxState1_eve";
    private static final String PREFS_NAME_NIGHT = "MyPrefs_night";
    private static final String CHECKBOX_KEY1_NIGHT = "checkBoxState1_night";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_arrival_filter, container, false);

        earlyMorning = view.findViewById(R.id.ArrEarlyMorningChk);
        morning = view.findViewById(R.id.ArrMorningChk);
        midDay = view.findViewById(R.id.ArrMidDayChk);
        Evening = view.findViewById(R.id.ArrEveningChk);
        night = view.findViewById(R.id.ArrNightChk);

        prefs = getActivity().getSharedPreferences(PREFS_NAME, 0);
        pref1 = getActivity().getSharedPreferences(PREFS_NAME1, 0);
        prefMD = getActivity().getSharedPreferences(PREFS_NAME_MIDDAY, 0);
        prefE = getActivity().getSharedPreferences(PREFS_NAME_EVENING, 0);
        prefN = getActivity().getSharedPreferences(PREFS_NAME_NIGHT, 0);


        boolean isCheckedEarlyMorning = prefs.getBoolean(CHECKBOX_KEY, false);
        boolean isCheckedMorning = pref1.getBoolean(CHECKBOX_KEY1, false);
        boolean isCheckedMidDay = prefMD.getBoolean(CHECKBOX_KEY1_MIDDAY, false);
        boolean isCheckedEvening = prefE.getBoolean(CHECKBOX_KEY1_EVENING, false);
        boolean isCheckedNight = prefN.getBoolean(CHECKBOX_KEY1_NIGHT, false);

        earlyMorning.setChecked(isCheckedEarlyMorning);
        morning.setChecked(isCheckedMorning);
        midDay.setChecked(isCheckedMidDay);
        Evening.setChecked(isCheckedEvening);
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
        Evening.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefE.edit();
            editor.putBoolean(CHECKBOX_KEY1_EVENING, isChecked_);
            editor.apply();
        });
        night.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefN.edit();
            editor.putBoolean(CHECKBOX_KEY1_NIGHT, isChecked_);
            editor.apply();
        });


//        SharedPreferences settings = getActivity().getSharedPreferences("syllabus", 0);
//        Boolean isChecked = settings.getBoolean("cbx1_ischecked", false);
//        earlyMorning.setChecked(isChecked );
//
//        earlyMorning.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        earlyMorning = getView().findViewById(R.id.ArrEarlyMorningChk);
        morning = getView().findViewById(R.id.ArrMorningChk);
        outState.putBoolean(String.valueOf(earlyMorning), earlyMorning.isChecked());
        outState.putBoolean(String.valueOf(morning), morning.isChecked());

    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        Toast.makeText(getContext(), "IM DONE WITH THIS", Toast.LENGTH_SHORT).show();
//        earlyMorning = requireActivity().findViewById(R.id.ArrEarlyMorningChk);
//        SharedPreferences sh = getContext().getSharedPreferences("MyPreference", MODE_PRIVATE);
//        boolean em = sh.getBoolean("EM_STATUS", false);
////
//        earlyMorning.setChecked(em);
//
//
//    }
//
//    public void onPause(){
//        super.onPause();
//
//        earlyMorning = getView().findViewById(R.id.ArrEarlyMorningChk);
//
//        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPreference", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
////        boolean em = sharedPreferences.getBoolean("EM_STATUS", earlyMorning.isChecked());
//
//        editor.putBoolean("EM_STATUS", earlyMorning.isChecked());
//        editor.apply();
//
//    }
}