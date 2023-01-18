package com.lksnext.parking.utils;

public class CalendarUtil {

    private CalendarUtil() {
    }

    public static String getDayOfWeek(int value) {
        String day = "";
        switch (value) {
            case 1:
                day = "Domingo";
                break;
            case 2:
                day = "Lunes";
                break;
            case 3:
                day = "Martes";
                break;
            case 4:
                day = "Miercoles";
                break;
            case 5:
                day = "Jueves";
                break;
            case 6:
                day = "Viernes";
                break;
            case 7:
                day = "Sabado";
                break;
            default:
                break;
        }
        return day;
    }

    public static Integer convertirHora(String hora){
        return Integer.parseInt(hora.substring(0,2));
    }
}
