package com.lksnext.parking.viewmodel;

import static com.lksnext.parking.utils.PlazasGenerator.numeroPlazas;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lksnext.parking.model.Plaza;
import com.lksnext.parking.model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private static final Integer NUMEROPLAZAS = 2;
    private static List<Plaza> plazas;

    public MainViewModel() {
        //Initialize the userName MutableLiveData
        plazas = new ArrayList<>();
    }

    public List<Plaza> getPlazas() {
        if (plazas.isEmpty()){
            plazas = numeroPlazas(NUMEROPLAZAS);
        }
        return plazas;
    }

    public void setPLazas(List<Plaza> plazas){
        this.plazas = plazas;
    }

    public void añadirPlaza(Plaza plaza) {
        plazas.add(plaza);
    }

    public void añadirReserva(Integer posicion, Reserva reserva){
        Plaza aux = plazas.get(posicion);
        aux.setReservas(reserva);
        plazas.set(posicion, aux);
    }
}
