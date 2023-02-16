package com.lksnext.parking.utils;

import com.lksnext.parking.model.Plaza;
import com.lksnext.parking.view.activity.MainActivity;
import com.lksnext.parking.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class PlazasGenerator {

    private PlazasGenerator() {
    }

    public static List<Plaza> numeroPlazas(Integer numeroPlazas) {
        List<Plaza> plazasAux = new ArrayList<Plaza>();
        for (int i = 1; i <= numeroPlazas; i++) {
            plazasAux.add(new Plaza("Plaza" + i));
        }
        return plazasAux;
    }
}
