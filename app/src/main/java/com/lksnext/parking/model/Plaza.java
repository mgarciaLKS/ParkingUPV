package com.lksnext.parking.model;

import java.util.ArrayList;
import java.util.List;

public class Plaza {
    public String id;
    public List<Reserva> reservas = new ArrayList<>();

    public Plaza(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Reserva reserva) {
        this.reservas.add(reserva);
    }
}
