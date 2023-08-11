package com.example.searchflight;

import static com.example.searchflight.R.drawable.item4shape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.annotation.SuppressLint;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.searchflight.Adapterclass.Adapter1voucher;
import com.example.searchflight.Adapterclass.Adapter2Timing;
import com.example.searchflight.Adapterclass.Adapter3Aeroplane;
import com.example.searchflight.FilterFragments.StopfilterFragment;
import com.example.searchflight.Modelclass.Model1Voucher;
import com.example.searchflight.Modelclass.Model2Timing;
import com.example.searchflight.Modelclass.Model3Aeroplane;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    TextView newDelhi, varanshi, travellerEconomy, Time, price, stop;
    ImageView leftarrow, rightarrrow, uparrow;
    RecyclerView recyclerViewvoucher, recyclerViewTiming, recyclerViewAeroplane;

    ArrayList<Model1Voucher> model1vouchers = new ArrayList<>();
    ArrayList<Model2Timing> model2Timings = new ArrayList<>();
    ArrayList<Model3Aeroplane> model3Aeroplanes = new ArrayList<>();
    LinearLayout linearLayoutbtn;

    // ----------- S T O P S -------------------------------
    ArrayList<Model3Aeroplane> nonStops = new ArrayList<>();
    ArrayList<Model3Aeroplane> oneStop = new ArrayList<>();
    ArrayList<Model3Aeroplane> moreThenOneStop = new ArrayList<>();
    ArrayList<Model3Aeroplane> one_Non_More_STOPS = new ArrayList<>();
    ArrayList<Model3Aeroplane> one_Non_STOPS = new ArrayList<>();
    ArrayList<Model3Aeroplane> non_More_STOPS = new ArrayList<>();
    ArrayList<Model3Aeroplane> one_More_STOPS = new ArrayList<>();


    // -----------   D E P A R T U R E    T I M E  -------------------------------

    ArrayList<Model3Aeroplane> EarlyMorning = new ArrayList<>();
    ArrayList<Model3Aeroplane> Morning = new ArrayList<>();
    ArrayList<Model3Aeroplane> MidDay = new ArrayList<>();
    ArrayList<Model3Aeroplane> Evening = new ArrayList<>();
    ArrayList<Model3Aeroplane> Night = new ArrayList<>();


    // ----------- T E S T -------------------------------
    ArrayList<Model3Aeroplane> testing = new ArrayList<>();



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newDelhi = findViewById(R.id.newdelhi);
        varanshi  = findViewById(R.id.varanshi);
        travellerEconomy = findViewById(R.id.TimingofTravel);
        Time = findViewById(R.id.TimingofAeroplane);
        price = findViewById(R.id.PriceofAeroplane);
        leftarrow = findViewById(R.id.arrowimage);
        rightarrrow = findViewById(R.id.arrowimage2);
        uparrow = findViewById(R.id.arrowimage3);
        stop = findViewById(R.id.stop);
        linearLayoutbtn = findViewById(R.id.linearlayoutbtn);

        recyclerViewvoucher = findViewById(R.id.recyclerviewVoucher);
        recyclerViewTiming = findViewById(R.id.recyclerviewTiming);
        recyclerViewAeroplane = findViewById(R.id.recyclerviewAeroplane);

        int ACCESS_CODE = getIntent().getIntExtra("REQUEST_CODE_STOPS", 0);
        int DEPARTURE_ACCESS_CODE = getIntent().getIntExtra("REQUEST_CODE_DEPARTURE", 0);
        int ARRIVAL_ACCESS_CODE = getIntent().getIntExtra("REQUEST_CODE_ARRIVAL", 0);
//        int PRICE_ACCESS_CODE = getIntent().getIntExtra("REQUEST_CODE_DEPARTURE", 0);


        Adapter1voucher adapter1voucher=new Adapter1voucher(model1vouchers, new Adapter1voucher.ItemClickLisener() {
            @Override
            public void onItemClick(Model1Voucher model1Voucher) {
                Intent intent = new Intent(MainActivity.this, VoucherScreen.class);
                startActivity(intent);
            }
        });
        recyclerViewvoucher.setHasFixedSize(true);
        recyclerViewvoucher.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        recyclerViewvoucher.setAdapter(adapter1voucher);
        model1vouchers.add(new Model1Voucher(R.drawable.img, "Earn 1% reward \n point on this\n transaction"));
        model1vouchers.add(new Model1Voucher(R.drawable.img, "Earn 1% reward \npoint on this \ntransaction"));
        model1vouchers.add(new Model1Voucher(R.drawable.img, "Earn 1% reward \npoint on this \ntransaction"));
        model1vouchers.add(new Model1Voucher(R.drawable.img, "Earn 1% reward \npoint on this \ntransaction"));


        Adapter2Timing adapter2Timing = new Adapter2Timing(model2Timings);
        recyclerViewTiming.setHasFixedSize(true);
        recyclerViewTiming.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        recyclerViewTiming.setAdapter(adapter2Timing);
        model2Timings.add(new Model2Timing("Tue,Jul 19", "7604"));
        model2Timings.add(new Model2Timing("Tue,Jul 19", "7604"));
        model2Timings.add(new Model2Timing("Tue,Jul 19", "7604"));
        model2Timings.add(new Model2Timing("Tue,Jul 19", "7604"));





        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Indigo", "7683", "18:40 - 19:55", "01h 15m", 0, 1120, 1555));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Spice jet", "7683", "18:40 - 19:55", "01h 15m", 1, 1320, 1455));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Vista", "7683", "18:40 - 199:55", "01h 15m", 2, 1420, 1865));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Indigo", "7683", "18:40 - 199:55", "01h 15m", 0, 1520, 1455));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Vista", "7683", "18:40 - 199:55", "01h 15m", 0, 1120, 1155));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Indigo", "7683", "18:40 - 199:55", "01h 15m", 0, 1120, 1455));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Spice jet", "7683", "18:40 - 199:55", "01h 15m", 2, 1120, 1755));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Vista", "7683", "18:40 - 199:55", "01h 15m", 0, 1120, 1355));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Spice jet", "7683", "18:40 - 199:55", "01h 15m", 1, 1120, 1255));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Vista", "7683", "18:40 - 199:55", "01h 15m", 1, 1120, 1855));
        model3Aeroplanes.add(new Model3Aeroplane(R.drawable.img_1, "Indigo", "7683", "18:40 - 199:55", "01h 15m", 0, 1120, 1455));

//        StopsFilteration();
        DepartureTimeFilter();

        recyclerViewAeroplane.setHasFixedSize(true);
        Log.e("AAKANSHA_REQUEST_CODE", ACCESS_CODE+"");
        int i=0;



        if(ACCESS_CODE==3200){
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getStops()<1){
                    nonStops.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane = new Adapter3Aeroplane(nonStops);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(ACCESS_CODE==3300){
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getStops()==1){
                    oneStop.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane =new Adapter3Aeroplane(oneStop);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(ACCESS_CODE==3400){
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getStops()>1){
                    moreThenOneStop.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane =new Adapter3Aeroplane(moreThenOneStop);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(ACCESS_CODE==1111) {
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getStops()==0 || model3Aeroplanes.get(i).getStops()==1 || model3Aeroplanes.get(i).getStops()>1){
                    one_Non_More_STOPS.add(model3Aeroplanes.get(i));
                    Log.e("AAKA_ERR", model3Aeroplanes.get(i).getStops()+"");
                }
            }
            Adapter3Aeroplane adapter3Aeroplane = new Adapter3Aeroplane(one_Non_More_STOPS);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(ACCESS_CODE==1212) {
            testing.clear();
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getDepartureTime()>720 && model3Aeroplanes.get(i).getDepartureTime()<=960){
                    testing.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane =new Adapter3Aeroplane(one_Non_STOPS);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(ACCESS_CODE==1313){
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getStops()==0 || model3Aeroplanes.get(i).getStops()>1){
                    non_More_STOPS.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane =new Adapter3Aeroplane(non_More_STOPS);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        } else if(ACCESS_CODE==2323){
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getStops()==1 || model3Aeroplanes.get(i).getStops()>1){
                    one_More_STOPS.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane = new Adapter3Aeroplane(one_More_STOPS);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }

// -----------   D E P A R T U R E    T I M E  -------------------------------

        else if(DEPARTURE_ACCESS_CODE == 7){
            testing.clear();
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getDepartureTime()<=480){
                    testing.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane = new Adapter3Aeroplane(testing);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(DEPARTURE_ACCESS_CODE == 14){
            testing.clear();
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getDepartureTime()>480 && model3Aeroplanes.get(i).getDepartureTime()<=720){
                    testing.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane = new Adapter3Aeroplane(testing);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(DEPARTURE_ACCESS_CODE == 23){
            testing.clear();
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getDepartureTime()>720 && model3Aeroplanes.get(i).getDepartureTime()<=960){
                    testing.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane = new Adapter3Aeroplane(testing);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(DEPARTURE_ACCESS_CODE == 32){
            testing.clear();
            for(i=0; i<model3Aeroplanes.size(); i++) {
                if(model3Aeroplanes.get(i).getDepartureTime()>960 && model3Aeroplanes.get(i).getDepartureTime()<=1200){
                    testing.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane = new Adapter3Aeroplane(testing);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(DEPARTURE_ACCESS_CODE == 43){
            testing.clear();
            for(i=0; i<model3Aeroplanes.size(); i++){
                if(model3Aeroplanes.get(i).getDepartureTime()>1200 && model3Aeroplanes.get(i).getDepartureTime()<=1439){
                    testing.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane = new Adapter3Aeroplane(testing);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else if(DEPARTURE_ACCESS_CODE == 5){
            testing.clear();
            for(i=0; i<model3Aeroplanes.size(); i++) {
                if(model3Aeroplanes.get(i).getDepartureTime()>0 && model3Aeroplanes.get(i).getDepartureTime()<=720){
                    testing.add(model3Aeroplanes.get(i));
                }
            }
            Adapter3Aeroplane adapter3Aeroplane = new Adapter3Aeroplane(testing);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }
        else {
            Adapter3Aeroplane adapter3Aeroplane =new Adapter3Aeroplane(model3Aeroplanes);
            recyclerViewAeroplane.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
            recyclerViewAeroplane.setAdapter(adapter3Aeroplane);
        }


        linearLayoutbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Bottomsheetfragment bottomsheetfragment = new Bottomsheetfragment();
        bottomsheetfragment.show(getSupportFragmentManager(), bottomsheetfragment.getTag());

    }

});



    }

    private void DepartureTimeFilter() {
        int i;
        for(i=0; i<model3Aeroplanes.size(); i++){
            if(model3Aeroplanes.get(i).getDepartureTime()<=480){
                EarlyMorning.add(model3Aeroplanes.get(i));
            }
        }
        for(i=0; i<model3Aeroplanes.size(); i++){
            if(model3Aeroplanes.get(i).getDepartureTime()>480 && model3Aeroplanes.get(i).getDepartureTime()<=720){
                Morning.add(model3Aeroplanes.get(i));
            }
        }
        for(i=0; i<model3Aeroplanes.size(); i++){
            if(model3Aeroplanes.get(i).getDepartureTime()>720 && model3Aeroplanes.get(i).getDepartureTime()<=960){
                MidDay.add(model3Aeroplanes.get(i));
            }
        }
        for(i=0; i<model3Aeroplanes.size(); i++) {
            if(model3Aeroplanes.get(i).getDepartureTime()>960 && model3Aeroplanes.get(i).getDepartureTime()<=1200){
                Evening.add(model3Aeroplanes.get(i));
            }
        }
        for(i=0; i<model3Aeroplanes.size(); i++){
            if(model3Aeroplanes.get(i).getDepartureTime()>1200 && model3Aeroplanes.get(i).getDepartureTime()<=1439){
                Night.add(model3Aeroplanes.get(i));
            }
        }
        for(i=0; i<model3Aeroplanes.size(); i++){
            if(model3Aeroplanes.get(i).getDepartureTime()>1200 && model3Aeroplanes.get(i).getDepartureTime()<=1439){
                Night.add(model3Aeroplanes.get(i));
            }
        }



    }

//    private void StopsFilteration() {
//        int i=0;
//        for(i=0; i<model3Aeroplanes.size(); i++){
//            if(model3Aeroplanes.get(i).getStops()<1){
//                nonStops.add(model3Aeroplanes.get(i));
//            }
//        }
//        for(i=0; i<model3Aeroplanes.size(); i++){
//            if(model3Aeroplanes.get(i).getStops()==1){
//                oneStop.add(model3Aeroplanes.get(i));
//            }
//        }
//        for(i=0; i<model3Aeroplanes.size(); i++){
//            if(model3Aeroplanes.get(i).getStops()>1){
//                moreThenOneStop.add(model3Aeroplanes.get(i));
//            }
//        }
//
////==============  NON_ONE
//        for(i=0; i<model3Aeroplanes.size(); i++){
//            if(model3Aeroplanes.get(i).getStops()==0){
//                one_Non_STOPS.add(model3Aeroplanes.get(i));
//            } else if(model3Aeroplanes.get(i).getStops()==1){
//                one_Non_STOPS.add(model3Aeroplanes.get(i));
//            }
//        }
//
////==============  ONE_MORE
//        for(i=0; i<model3Aeroplanes.size(); i++){
//            if(model3Aeroplanes.get(i).getStops()==1){
//                one_More_STOPS.add(model3Aeroplanes.get(i));
//            } else if(model3Aeroplanes.get(i).getStops()>1){
//                one_More_STOPS.add(model3Aeroplanes.get(i));
//            }
//        }
////==============  NONE_MORE
//        for(i=0; i<model3Aeroplanes.size(); i++){
//            if(model3Aeroplanes.get(i).getStops()==0){
//                non_More_STOPS.add(model3Aeroplanes.get(i));
//            } else if(model3Aeroplanes.get(i).getStops()>1){
//                non_More_STOPS.add(model3Aeroplanes.get(i));
//            }
//        }
////==============  ALL _ STOPS CHECKED
//        for(i=0; i<model3Aeroplanes.size(); i++){
//            if(model3Aeroplanes.get(i).getStops()==0 || model3Aeroplanes.get(i).getStops()==1 || model3Aeroplanes.get(i).getStops()>1){
//                one_Non_More_STOPS.add(model3Aeroplanes.get(i));
//                Log.e("AAKA_ERR", model3Aeroplanes.get(i).getStops()+"");
//            }
//        }
//
//    }


}