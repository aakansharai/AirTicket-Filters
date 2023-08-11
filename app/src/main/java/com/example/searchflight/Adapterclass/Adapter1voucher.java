package com.example.searchflight.Adapterclass;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchflight.Modelclass.Model1Voucher;
import com.example.searchflight.R;
import com.example.searchflight.VoucherScreen;

import java.util.ArrayList;


public class Adapter1voucher extends RecyclerView.Adapter<Adapter1voucher.ViewHolder>{

    private ArrayList<Model1Voucher> model1Vouchers;
    private ItemClickLisener itemClickLisener;

    public Adapter1voucher(ArrayList<Model1Voucher> model1Vouchers, ItemClickLisener itemClickLisener) {
        this.model1Vouchers = model1Vouchers;
        this.itemClickLisener =itemClickLisener;
    }

    @NonNull
    @Override
    public Adapter1voucher.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1design,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter1voucher.ViewHolder holder, int position) {
        holder.textView.setText(model1Vouchers.get(position).getRewards());
        holder.imageView.setImageResource(model1Vouchers.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        itemClickLisener.onItemClick(model1Vouchers.get(position));
    }
});
    }


    @Override
    public int getItemCount() {
        return model1Vouchers.size();
    }
    public interface ItemClickLisener{
        void onItemClick(Model1Voucher model1Voucher);
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.vocher);
            textView = itemView.findViewById(R.id.earnrreward);
        }


    }
}
