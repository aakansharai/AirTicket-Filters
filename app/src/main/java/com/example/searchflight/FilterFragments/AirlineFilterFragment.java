package com.example.searchflight.FilterFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchflight.Adapterclass.FilterAirlineAdapter;
import com.example.searchflight.Modelclass.FilterAirlineModelclass;
import com.example.searchflight.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AirlineFilterFragment extends Fragment {

  RecyclerView recyclerView;
  ArrayList<FilterAirlineModelclass> filterAirlineModelclasses = new ArrayList<>();


    public AirlineFilterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_airline_filter, container, false);
        recyclerView =view.findViewById(R.id.recyclerviewAirline);

        FilterAirlineAdapter adapter = new FilterAirlineAdapter(filterAirlineModelclasses);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        filterAirlineModelclasses.add(new FilterAirlineModelclass(R.drawable.img_1,"Indigo", "4",false));
        filterAirlineModelclasses.add(new FilterAirlineModelclass(R.drawable.img_1,"Vista", "4",false));
        filterAirlineModelclasses.add(new FilterAirlineModelclass(R.drawable.img_1,"Indian AirLine", "4",false));
        filterAirlineModelclasses.add(new FilterAirlineModelclass(R.drawable.img_1,"Indigo", "4",false));
        filterAirlineModelclasses.add(new FilterAirlineModelclass(R.drawable.img_1,"Vista", "4",false));
        filterAirlineModelclasses.add(new FilterAirlineModelclass(R.drawable.img_1,"Indigo", "4",false));
        filterAirlineModelclasses.add(new FilterAirlineModelclass(R.drawable.img_1,"Indigo", "4",false));

        filterairlineapply();

        return view;
    }

    private void filterairlineapply() {
        ArrayList<String> selecteddata;

        selecteddata =new ArrayList<>();

    }
    @Override
    public void onResume() {
        super.onResume();

    }


}