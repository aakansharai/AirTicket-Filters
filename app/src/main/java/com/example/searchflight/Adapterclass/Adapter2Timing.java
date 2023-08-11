package com.example.searchflight.Adapterclass;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.example.searchflight.Modelclass.Model2Timing;
import com.example.searchflight.R;

import java.util.ArrayList;


public class Adapter2Timing extends RecyclerView.Adapter<Adapter2Timing.ViewHolder>{

    private ArrayList<Model2Timing> model2Timings;

    public Adapter2Timing(ArrayList<Model2Timing> model2Timings) {
        this.model2Timings = model2Timings;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2design,parent,false);
        return new ViewHolder(v);




    }




    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(model2Timings.get(position).getTime());
        holder.textView2.setText(model2Timings.get(position).getPrice());






    }


    @Override
    public int getItemCount() {
        return model2Timings.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1, textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.item2time);
            textView2  =itemView.findViewById(R.id.item2price);



        }


    }
}
