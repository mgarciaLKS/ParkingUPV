package com.lksnext.parking.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.lksnext.parking.databinding.ReservaRowBinding;
import com.lksnext.parking.model.Reserva;

import java.util.List;

public class ReservasAdapter extends RecyclerView.Adapter<ReservasAdapter.MyAdapter> {

    public AdapterListener onClickListener;
    private LayoutInflater inflater;
    private List<Reserva> reservas;
    private ReservaRowBinding mReservaRowBinding;
    private int posicion;

    public void setReservasList(List<Reserva> reservas) {
        this.reservas = reservas;
        Log.d("RESUMEN VH", "log plazas");
        notifyDataSetChanged();
    }


    @Override
    public MyAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        if (null == inflater) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        mReservaRowBinding = ReservaRowBinding.inflate(inflater, parent, false);
        return new MyAdapter(mReservaRowBinding);
    }

    @Override
    public void onBindViewHolder( MyAdapter holder, int position) {
        if (reservas != null) {
            holder.bind(reservas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (reservas != null) {
            return reservas.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        private final ReservaRowBinding reservaRowBinding;
        public MaterialTextView boton;

        public MyAdapter(ReservaRowBinding reservaRowBinding) {
            super(reservaRowBinding.getRoot());
            this.reservaRowBinding = reservaRowBinding;
        }

        public void bind(Reserva reserva) {
            this.reservaRowBinding.setRangoHora(reserva.horaInicio + " - " + reserva.horaFin);
            this.reservaRowBinding.setUser(reserva.nombreUsuario);
        }

        public ReservaRowBinding reservaRowBinding() {
            return reservaRowBinding;
        }
    }

    public interface AdapterListener {
        void buttonOnClick(View v, int position);
    }
}
