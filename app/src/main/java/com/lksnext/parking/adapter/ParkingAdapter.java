package com.lksnext.parking.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.lksnext.parking.databinding.ParkingRowBinding;

import java.util.List;

public class ParkingAdapter extends RecyclerView.Adapter<ParkingAdapter.MyAdapter> {

    public AdapterListener onClickListener;
    private LayoutInflater inflater;
    private List<String> plazas;
    private ParkingRowBinding parkingRowBinding;
    private int posicion;

    /**
     * Public constructor
     */
    public ParkingAdapter(AdapterListener listener) {
        onClickListener = listener;
    }

    public void setPlazasList(List<String> plazas) {
        this.plazas = plazas;
        Log.d("RESUMEN VH", "log plazas");
        notifyDataSetChanged();
    }


    @Override
    public MyAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        if (null == inflater) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        parkingRowBinding = ParkingRowBinding.inflate(inflater, parent, false);
        return new MyAdapter(parkingRowBinding);
    }

    @Override
    public void onBindViewHolder( MyAdapter holder, int position) {
        if (plazas != null) {
            holder.bind(plazas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (plazas != null) {
            return plazas.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        private final ParkingRowBinding parkingRowBinding;
        public MaterialTextView boton;

        public MyAdapter(ParkingRowBinding parkingRowBinding) {
            super(parkingRowBinding.getRoot());
            this.parkingRowBinding = parkingRowBinding;
            boton = parkingRowBinding().realizarReserva;

            boton.setOnClickListener(v -> onClickListener.buttonOnClick(v, getAdapterPosition()));
        }

        public void bind(String plaza) {
            this.parkingRowBinding.setPlazaVariable(plaza);
        }

        public ParkingRowBinding parkingRowBinding() {
            return parkingRowBinding;
        }
    }

    public interface AdapterListener {
        void buttonOnClick(View v, int position);
    }
}
