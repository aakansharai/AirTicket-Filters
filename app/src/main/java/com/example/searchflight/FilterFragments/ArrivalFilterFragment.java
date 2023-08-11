package com.example.searchflight.FilterFragments;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

    private CheckBox earlyMorning ;
    private SharedPreferences prefs;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String CHECKBOX_KEY = "checkBoxState";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_arrival_filter, container, false);

        earlyMorning = view.findViewById(R.id.ArrEarlyMorningChk);

        prefs = getActivity().getSharedPreferences(PREFS_NAME, 0);

        boolean isChecked = prefs.getBoolean(CHECKBOX_KEY, false);
        earlyMorning.setChecked(isChecked);

        earlyMorning.setOnCheckedChangeListener((buttonView, isChecked_) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(CHECKBOX_KEY, isChecked_);
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