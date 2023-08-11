package com.example.searchflight.Adapterclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchflight.Modelclass.FilterAirlineModelclass;
import com.example.searchflight.R;

import java.util.ArrayList;

public class FilterAirlineAdapter extends RecyclerView.Adapter<FilterAirlineAdapter.ViewHolder> {

    private ArrayList<FilterAirlineModelclass> filterAirlineModelclasses;
    ArrayList<String> selectedCat = new ArrayList<String>();


    public FilterAirlineAdapter(ArrayList<FilterAirlineModelclass> filterAirlineModelclasses) {
        this.filterAirlineModelclasses = filterAirlineModelclasses;
    }



    @NonNull
    @Override
    public FilterAirlineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.airlinerfilter_recyclerviewitem, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterAirlineAdapter.ViewHolder holder, int position) {
        holder.Availableairline.setText(filterAirlineModelclasses.get(position).getAvailableAirline());
        holder.AirlineName.setText(filterAirlineModelclasses.get(position).getAirlineName());
        holder.Airlinecheckbox.setChecked(filterAirlineModelclasses.get(position).getCheckbox());
        holder.IndigoImg.setImageResource(filterAirlineModelclasses.get(position).getIndigoimage());


        selectedCat.add("airlinecheckbox");
        if(selectedCat.contains("airline checkbox")){
            holder.Airlinecheckbox.setChecked(true);
        }else{
            holder.Airlinecheckbox.setChecked(false);
        }


    }


    @Override
    public int getItemCount() {
        return filterAirlineModelclasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView IndigoImg;
        TextView AirlineName, Availableairline;
        CheckBox Airlinecheckbox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IndigoImg = itemView.findViewById(R.id.IndigoImg);
            Airlinecheckbox =itemView.findViewById(R.id.airlinecheckbox);
            AirlineName = itemView.findViewById(R.id.indigoairlineFilter);
            Availableairline =itemView.findViewById(R.id.NumberOfairlineAvailable);

        }
    }
}
