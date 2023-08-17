package com.example.searchflight;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.searchflight.Adapterclass.Adapter3Aeroplane;
import com.example.searchflight.FilterFragments.AirlineFilterFragment;
import com.example.searchflight.FilterFragments.ArrivalFilterFragment;
import com.example.searchflight.FilterFragments.DepartureFilterFragment;
import com.example.searchflight.FilterFragments.PriceFilterfragment;
import com.example.searchflight.FilterFragments.StopfilterFragment;
import com.example.searchflight.Modelclass.FilterAirlineModelclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DepartureTabFragment extends Fragment {

    TextView stop, departureTime, ArrivalTime, Departureprice, Airlinedeparture;
    Button applybtn, resetbtn;
    private ViewPager viewPager;
    FrameLayout frameLayout;
    LinearLayout linearLayout;
    int REQUEST_CODE_STOPS = 0;
    int CODE = 0;
    int ARRIVAL_REQ = 0;
    int PRICE_CODE = 0;
    ArrayList<Integer> REQUEST_CODES = new ArrayList<>();
    CheckBox departureTimeCheck, ArrivalTimeCheck, nonStopCHK, oneStopCHK, moreThenOneStopCHK;
    CheckBox EarlyMorning, Morning, MidDay, Evening, Night, EarlyMorningArrival, MorningArrival, MidDayArrival, EveningArrival, NightArrival;
    ArrayList<FilterAirlineModelclass> filterAirlineModelClasses = new ArrayList<>();

    RecyclerView filterRV;
//    RecyclerView filterValuesRV;
    Adapter3Aeroplane filterAdapter;
    int STOP_CODE;

    public DepartureTabFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_departure_tab, container, false);

        if (getArguments() != null)
        {
            STOP_CODE = getArguments().getInt("yourKey");
        }
        applybtn = view.findViewById(R.id.applyBtn);
        resetbtn = view.findViewById(R.id.resetBtn);
        linearLayout = view.findViewById(R.id.linearvisibility);

        frameLayout = view.findViewById(R.id.stopFilterFragment);
        stop = view.findViewById(R.id.stop);
        departureTime = view.findViewById(R.id.Departuretime);
        ArrivalTime = view.findViewById(R.id.Arrivaltime);

        EarlyMorning = view.findViewById(R.id.EarlyMorningCHK);
        Morning = view.findViewById(R.id.morningChk);
        MidDay = view.findViewById(R.id.MidDayChk);
        Evening = view.findViewById(R.id.EveningChk);
        Night = view.findViewById(R.id.Nightchk);

        EarlyMorningArrival = view.findViewById(R.id.ArrEarlyMorningChk);
        MorningArrival = view.findViewById(R.id.ArrMorningChk);
        MidDayArrival = view.findViewById(R.id.ArrMidDayChk);
        EveningArrival = view.findViewById(R.id.ArrEveningChk);
        NightArrival = view.findViewById(R.id.ArrNightChk);

        Departureprice = view.findViewById(R.id.Pricedeparture);

        Airlinedeparture = view.findViewById(R.id.departureAirline);

        oneStopCHK = view.findViewById(R.id.departureOneStopChk);
        nonStopCHK = view.findViewById(R.id.departureNonStopChk);
        moreThenOneStopCHK = view.findViewById(R.id.departureOnePlusStopChk);

        departureTimeCheck = view.findViewById(R.id.departureTime);
        ArrivalTimeCheck = view.findViewById(R.id.arrivalTime);


//===============   R E P L A C E M E N T   O F    F R A G M E N T S ==========
        replacefragment(new StopfilterFragment());
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new StopfilterFragment());
            }
        });

        departureTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new DepartureFilterFragment());
//                linearLayout.setVisibility(View.INVISIBLE);
            }
        });

        ArrivalTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new ArrivalFilterFragment());
            }
        });

        Departureprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new PriceFilterfragment());
//                linearLayout.setVisibility(View.INVISIBLE);
            }
        });

        Airlinedeparture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new AirlineFilterFragment());
//                linearLayout.setVisibility(View.INVISIBLE);
            }
        });

        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                assert getFragmentManager() != null;
                int len = getChildFragmentManager().getFragments().size();
                Log.e("HEHE", len+"\n \n "+getChildFragmentManager().getFragments().get(0)+"\n "+getParentFragmentManager().getFragments().get(0)+"\n "+getParentFragmentManager().getFragments().get(1));

//                StopfilterFragment stopFragment = (StopfilterFragment) getChildFragmentManager().getFragments().get(0);

                StopfilterFragment stopFragment = new StopfilterFragment();

                Fragment current = (Fragment) getChildFragmentManager().getFragments().get(0);
//                DepartureTabFragment dep = (DepartureTabFragment) getParentFragmentManager().getFragments().get(1);
//
//                Fragment departure = getParentFragmentManager().findFragmentById(R.id.departureFilterFragment);
//                Log.e("DEPARTURE_FRAGMENT", departure+"");
//                int length = dep.getChildFragmentManager().getFragments().size();

                if(Objects.equals(current, stopFragment)){

                    nonStopCHK = stopFragment.getView().findViewById(R.id.departureNonStopChk);
                    oneStopCHK = stopFragment.getView().findViewById(R.id.departureOneStopChk);
                    moreThenOneStopCHK = stopFragment.getView().findViewById(R.id.departureOnePlusStopChk);
//                    Log.e("DEPARTURE", length + " " + dep.getChildFragmentManager().getFragments().get(0));


                    if (nonStopCHK.isChecked()) {
                        if (oneStopCHK.isChecked() && moreThenOneStopCHK.isChecked()) {
                            REQUEST_CODE_STOPS = 1111;
                        } else if (oneStopCHK.isChecked()) {
                            REQUEST_CODE_STOPS = 1212;
                        } else if (moreThenOneStopCHK.isChecked()) {
                            REQUEST_CODE_STOPS = 1313;
                        } else {
                            REQUEST_CODE_STOPS = 3200;
                        }
                    } else if (oneStopCHK.isChecked()) {
                        if (moreThenOneStopCHK.isChecked()) {
                            REQUEST_CODE_STOPS = 2323;
                        } else {
                            REQUEST_CODE_STOPS = 3300;
                        }
                    } else if (moreThenOneStopCHK.isChecked()) {
                        REQUEST_CODE_STOPS = 3400;
                    }
                }

//                nonStopCHK = stopFragment.getView().findViewById(R.id.departureNonStopChk);
//                oneStopCHK = stopFragment.getView().findViewById(R.id.departureOneStopChk);
//                moreThenOneStopCHK = stopFragment.getView().findViewById(R.id.departureOnePlusStopChk);
////                Log.e("DEPARTURE", length + " " + dep.getChildFragmentManager().getFragments().get(0));
//
//
//                if (nonStopCHK.isChecked()) {
//                    if (oneStopCHK.isChecked() && moreThenOneStopCHK.isChecked()) {
//                        REQUEST_CODE_STOPS = 1111;
//                    } else if (oneStopCHK.isChecked()) {
//                        REQUEST_CODE_STOPS = 1212;
//                    } else if (moreThenOneStopCHK.isChecked()) {
//                        REQUEST_CODE_STOPS = 1313;
//                    } else {
//                        REQUEST_CODE_STOPS = 3200;
//                    }
//                } else if (oneStopCHK.isChecked()) {
//                    if (moreThenOneStopCHK.isChecked()) {
//                        REQUEST_CODE_STOPS = 2323;
//                    } else {
//                        REQUEST_CODE_STOPS = 3300;
//                    }
//                } else if (moreThenOneStopCHK.isChecked()) {
//                    REQUEST_CODE_STOPS = 3400;
//                }

                Intent intent = new Intent(getContext(), MainActivity.class);



//                int DEP_REQUEST = CheckDepartureTime();


//                if(EarlyMorning.isChecked()) {
//                    if(Morning.isChecked()) {
//                        if(MidDay.isChecked()) {
//                            if(Evening.isChecked()) {
//                                if(Night.isChecked()){
//                                    CODE = 1;
//                                } else {
//                                    CODE = 2;
//                                }
//                            } else {
//                                CODE = 3;
//                            }
//                        } else {
//                            CODE = 4;
//                        }
//
//                    } else if(MidDay.isChecked()) {
//                        CODE = 5;
//                    } else if(Evening.isChecked()) {
//                        CODE = 6;
//                    } else if(Night.isChecked()) {
//                        CODE = 7;
//                    }
//                } else if(Morning.isChecked()){
//                    if(MidDay.isChecked()) {
//                        if(Evening.isChecked()) {
//                            if(Night.isChecked()) {
//                                CODE = 11;
//                            } else {
//                                CODE = 12;
//                            }
//                        } else {
//                            CODE = 13;
//                        }
//                    } else {
//                        CODE = 14;
//                    }
//                } else if(MidDay.isChecked()) {
//                    if(Evening.isChecked()) {
//                        if(Night.isChecked()){
//                            CODE = 21;
//                        } else {
//                            CODE = 22;
//                        }
//                    } else {
//                        CODE = 23;
//                    }
//                } else if(Evening.isChecked()) {
//                    if(Night.isChecked()){
//                        CODE = 31;
//                    } else {
//                        CODE = 32;
//                    }
//                } else if(Night.isChecked()) {
//                    CODE = 43;
//                } else {
//                    CODE = 0;
//                }
//
//
//                if(EarlyMorningArrival.isChecked()) {
//                    if(MorningArrival.isChecked()) {
//                        if(MidDayArrival.isChecked()) {
//                            if(EveningArrival.isChecked()) {
//                                if(NightArrival.isChecked()){
//                                    ARRIVAL_REQ = 101;
//                                } else {
//                                    ARRIVAL_REQ = 102;
//                                }
//                            } else {
//                                ARRIVAL_REQ = 103;
//                            }
//                        } else {
//                            ARRIVAL_REQ = 104;
//                        }
//
//                    } else if(MidDayArrival.isChecked()) {
//                        ARRIVAL_REQ = 105;
//                    } else if(EveningArrival.isChecked()) {
//                        ARRIVAL_REQ = 106;
//                    } else if(NightArrival.isChecked()) {
//                        ARRIVAL_REQ = 107;
//                    }
//                } else if(MorningArrival.isChecked()){
//                    if(MidDayArrival.isChecked()) {
//                        if(EveningArrival.isChecked()) {
//                            if(NightArrival.isChecked()) {
//                                ARRIVAL_REQ = 111;
//                            } else {
//                                ARRIVAL_REQ = 112;
//                            }
//                        } else {
//                            ARRIVAL_REQ = 113;
//                        }
//                    } else {
//                        ARRIVAL_REQ = 114;
//                    }
//                } else if(MidDayArrival.isChecked()) {
//                    if(EveningArrival.isChecked()) {
//                        if(NightArrival.isChecked()){
//                            ARRIVAL_REQ = 201;
//                        } else {
//                            ARRIVAL_REQ = 202;
//                        }
//                    } else {
//                        ARRIVAL_REQ = 203;
//                    }
//                } else if(EveningArrival.isChecked()) {
//                    if(NightArrival.isChecked()){
//                        ARRIVAL_REQ = 301;
//                    } else {
//                        ARRIVAL_REQ = 302;
//                    }
//                } else if(NightArrival.isChecked()) {
//                    ARRIVAL_REQ = 333;
//                    ARRIVAL_REQ = 333;
//                } else {
//                    ARRIVAL_REQ = 203;
//                }

                intent.putExtra("REQUEST_CODE_STOPS", REQUEST_CODE_STOPS);
                intent.putExtra("REQUEST_CODE_DEPARTURE", CODE);
                intent.putExtra("REQUEST_CODE_ARRIVAL", ARRIVAL_REQ);
                intent.putIntegerArrayListExtra("ARRAY_OF_CODE", REQUEST_CODES);


                startActivity(intent);

            }

        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void replacefragment(Fragment departureFilterFragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.departureframelayout, departureFilterFragment);
        fragmentTransaction.commit();
    }

    private void initControls() {
//        filterRV =
//        filterValuesRV = findViewById(R.id.filterValuesRV);
//        filterRV.setLayoutManager(new LinearLayoutManager(this));
//        filterValuesRV.setLayoutManager(new LinearLayoutManager(this));

        List<String> stops = Arrays.asList(new String[]{"0", "1", "2", "3"});
        if (!PreferencesHM.filters.containsKey(FilterMy.INDEX_STOPS)) {
            PreferencesHM.filters.put(FilterMy.INDEX_STOPS, (com.example.searchflight.FilterMy) new com.example.searchflight.FilterMy("Color", stops, new ArrayList()));
        }
        List<String> depTime = Arrays.asList(new String[]{"0-420", "420-", "14", "16", "18", "20"});
        if (!PreferencesHM.filters.containsKey(FilterMy.INDEX_DEPARTURE)) {
            PreferencesHM.filters.put(FilterMy.INDEX_DEPARTURE, (com.example.searchflight.FilterMy) new com.example.searchflight.FilterMy("departureTime", depTime, new ArrayList()));
        }
        List<String> arrTime = Arrays.asList(new String[]{"10", "12", "14", "16", "18", "20"});
        if (!PreferencesHM.filters.containsKey(FilterMy.INDEX_ARRIVAL)) {
            PreferencesHM.filters.put(FilterMy.INDEX_ARRIVAL, (com.example.searchflight.FilterMy) new com.example.searchflight.FilterMy("arrivalTime", arrTime, new ArrayList()));
        }
        List<String> airline = Arrays.asList(new String[]{"10", "12", "14", "16", "18", "20"});
        if (!PreferencesHM.filters.containsKey(FilterMy.INDEX_AIRLINE)) {
            PreferencesHM.filters.put(FilterMy.INDEX_AIRLINE, (com.example.searchflight.FilterMy) new com.example.searchflight.FilterMy("arrivalTime", arrTime, new ArrayList()));
        }
        List<String> prices = Arrays.asList(new String[]{"0-100", "101-200", "201-300"});
        if (!PreferencesHM.filters.containsKey(com.example.searchflight.FilterMy.INDEX_PRICE)) {
            PreferencesHM.filters.put(com.example.searchflight.FilterMy.INDEX_PRICE, (FilterMy) new FilterMy("Price", prices, new ArrayList()));
        }

//        filterAdapter = new Adapter3Aeroplane(getContext(),PreferencesHM.filters, filterValuesRV);
//        filterRV.setAdapter(filterAdapter);


        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferencesHM.filters.get(FilterMy.INDEX_STOPS).setSelected(new ArrayList());
                PreferencesHM.filters.get(FilterMy.INDEX_DEPARTURE).setSelected(new ArrayList());
                PreferencesHM.filters.get(FilterMy.INDEX_ARRIVAL).setSelected(new ArrayList());
                PreferencesHM.filters.get(FilterMy.INDEX_PRICE).setSelected(new ArrayList());
                PreferencesHM.filters.get(FilterMy.INDEX_AIRLINE).setSelected(new ArrayList());
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getContext(), MainActivity.class);

                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
    }


}

