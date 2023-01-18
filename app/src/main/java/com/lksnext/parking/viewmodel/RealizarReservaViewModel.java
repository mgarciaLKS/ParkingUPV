package com.lksnext.parking.viewmodel;

import static com.lksnext.parking.utils.CalendarUtil.convertirHora;

import android.app.Application;
import android.util.Log;
import com.lksnext.parking.utils.CalendarUtil;

import androidx.lifecycle.AndroidViewModel;

public class RealizarReservaViewModel extends AndroidViewModel {

    public String horaInicio;
    public String horaFin;
    public Integer iHoraInicio;
    public Integer iHoraFin;

    public RealizarReservaViewModel(Application application) {
        super(application);
    }

    public void setHoraInicio(String horainicio) {
        this.horaInicio = horainicio;
    }

    public void setHorafin(String horafin) {
        this.horaFin = horafin;

    }

    public boolean comprobarHora(){
        if (horaInicio == null || horaFin == null) return false;
        iHoraInicio = convertirHora(horaInicio);
        iHoraFin = convertirHora(horaFin);
        if (iHoraFin <= iHoraInicio) return false;
        return (iHoraFin - iHoraInicio <= 8);
    }
}
