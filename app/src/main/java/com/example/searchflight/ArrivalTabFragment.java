package com.example.searchflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.searchflight.FilterFragments.AirlineFilterFragment;
import com.example.searchflight.FilterFragments.ArrivalFilterFragment;
import com.example.searchflight.FilterFragments.DepartureFilterFragment;
import com.example.searchflight.FilterFragments.PriceFilterfragment;
import com.example.searchflight.FilterFragments.StopfilterFragment;


public class ArrivalTabFragment extends Fragment {

    TextView Stop, departureTime, ArrivalTime, Price, Airline;
    Button applybtn, resetbtn;
    FrameLayout frameLayout;
    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_arrival_tab, container, false);

        applybtn = view.findViewById(R.id.applyBtn);
        resetbtn = view.findViewById(R.id.resetBtn);
        linearLayout = view.findViewById(R.id.linearvisibility);

        frameLayout = view.findViewById(R.id.ArrivalFramelayout);
        Stop = view.findViewById(R.id.ArrStops);
        departureTime = view.findViewById(R.id.ArrDepartureTime);
        ArrivalTime = view.findViewById(R.id.ArrArrivalTime);
        Price = view.findViewById(R.id.ArrPrice);
        Airline = view.findViewById(R.id.ArrAirline);

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new StopfilterFragment());
            }
        });
        departureTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new DepartureFilterFragment());
            }
        });
        ArrivalTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new ArrivalFilterFragment());
            }
        });
        Price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new PriceFilterfragment());
            }
        });
        Airline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new AirlineFilterFragment());
            }
        });

        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), MainActivity.class);

               startActivity(intent);

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
//                } else {
//                    ARRIVAL_REQ = 0;
//                }
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
        fragmentTransaction.replace(R.id.ArrivalFramelayout, departureFilterFragment);
        fragmentTransaction.commit();
    }
}