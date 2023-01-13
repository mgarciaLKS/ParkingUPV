package com.lksnext.parking.utils;

public class CalendarUtil {

    public CalendarUtil() {
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
        }
        return day;
    }
}
