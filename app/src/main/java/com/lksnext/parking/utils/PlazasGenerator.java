package com.lksnext.parking.utils;

import java.util.ArrayList;
import java.util.List;

public class PlazasGenerator {

    private PlazasGenerator() {
    }

    public static List<String> numeroPlazas(Integer numeroPlazas) {
        List<String> plazasAux = new ArrayList<>();
        for (int i = 1; i <= numeroPlazas; i++) {
            plazasAux.add("Plaza" + i);
        }
        return plazasAux;
    }
}
