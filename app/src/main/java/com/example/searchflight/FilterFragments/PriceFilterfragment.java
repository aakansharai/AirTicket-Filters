package com.example.searchflight.FilterFragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.searchflight.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PriceFilterfragment} factory method to
 * create an instance of this fragment.
 */
public class PriceFilterfragment extends Fragment {
    SeekBar priceseekbar;
    TextView pricefilter;

    public PriceFilterfragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_price_filterfragment, container, false);
        priceseekbar = view.findViewById(R.id.seekbarprice);
        pricefilter =view.findViewById(R.id.pricefilter);
        priceseekbar.setProgress(7008);
        priceseekbar.setMax(7008);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            priceseekbar.setMin(4803);
        }
        priceseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 4803;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}