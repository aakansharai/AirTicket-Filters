package com.example.searchflight.Adapterclass;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchflight.Modelclass.Model1Voucher;
import com.example.searchflight.Modelclass.Model3Aeroplane;
import com.example.searchflight.R;

import java.util.ArrayList;


public class Adapter3Aeroplane extends RecyclerView.Adapter<Adapter3Aeroplane.ViewHolder>{

    private ArrayList<Model3Aeroplane> model3Aeroplanes;


    public Adapter3Aeroplane(ArrayList<Model3Aeroplane> model3Aeroplanes) {
        this.model3Aeroplanes = model3Aeroplanes;
    }

    @NonNull
    @Override
    public Adapter3Aeroplane.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3design,parent,false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Adapter3Aeroplane.ViewHolder holder, int position) {
        holder.aeroplaneimage.setImageResource(model3Aeroplanes.get(position).getAeroplaneimage());
        holder.aeroplaneName.setText(model3Aeroplanes.get(position).getAeroplaneName());
        holder.aeroplaneNonstop.setText(model3Aeroplanes.get(position).getAeroplaneNonstop());
        holder.aeroplanePrice.setText("₹ "+model3Aeroplanes.get(position).getPrice());

        int stop = model3Aeroplanes.get(position).getStops();

        if(stop==0){
            holder.Stops.setText("Non-Stop");
        } else if(stop==1){
            holder.Stops.setText(stop + " Stop");
        } else if(stop>1){
            holder.Stops.setText(stop + " Stops");
        }

        int totalTime = model3Aeroplanes.get(position).getDepartureTime();
        int hours = totalTime/60;
        int minuts = hours%totalTime;

        int totalTimeA = model3Aeroplanes.get(position).getArrivalTime();
        int hoursA = totalTimeA/60;
        int minutsA = hours%totalTime;

        if(hoursA==0){
            hoursA=12;
        }
        if(hours==0){
            hours=12;
        }

        holder.departureTime.setText(hours+" :"+minuts);
        holder.arrivalTime.setText(hoursA+" :"+minutsA);
    }


    @Override
    public int getItemCount() {
        return model3Aeroplanes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView aeroplaneimage;
        TextView aeroplaneName, aeroplaneNonstop, aeroplanePrice, Stops, departureTime, arrivalTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            aeroplaneimage= itemView.findViewById(R.id.item3image);
            aeroplaneName = itemView.findViewById(R.id.item3indigotext);
            aeroplaneNonstop = itemView.findViewById(R.id.item3Nonstop);
            aeroplanePrice = itemView.findViewById(R.id.item3price);
            Stops = itemView.findViewById(R.id.stops);
            departureTime = itemView.findViewById(R.id.departureTime);
            arrivalTime = itemView.findViewById(R.id.arrivalTime);

        }
    }
}
