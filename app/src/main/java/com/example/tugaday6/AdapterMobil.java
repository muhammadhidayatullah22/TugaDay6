package com.example.tugaday6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMobil extends RecyclerView.Adapter<AdapterMobil.ViewHolder> {


    private ArrayList<ModelMobil> modelMobil;

    public AdapterMobil(ArrayList<ModelMobil> modelMobil) {
        this.modelMobil = modelMobil;
    }

    @NonNull
    @Override
    public AdapterMobil.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vholder = new ViewHolder(view);
        return vholder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMobil.ViewHolder holder, int position) {
        holder.namaMobil.setText(modelMobil.get(position).getNamaMobil());
        holder.gambarMobil.setImageResource(modelMobil.get(position).getGambarMobil());
    }

    @Override
    public int getItemCount() {
        return modelMobil.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ModelMobil model);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView namaMobil;
        ImageView gambarMobil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaMobil = itemView.findViewById(R.id.nama_mobil);
            gambarMobil = itemView.findViewById(R.id.cars_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(modelMobil.get(position));
                }
            }
        }
    }
}