package com.lksnext.parking.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import static com.lksnext.parking.utils.CalendarUtil.*;

import com.lksnext.parking.utils.CalendarUtil;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class ReservaViewModel extends AndroidViewModel {

    public final MutableLiveData<String> dayLiveData = new MutableLiveData<>();
    private Calendar calendar;
    private String dayWeek;
    private Integer day;
    private Integer month;
    private Integer year;

    public ReservaViewModel(Application application) {
        super(application);
        //Initialize the randomValue MutableLiveData
        calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.forLanguageTag("es-ES"));
        dayLiveData.setValue(computeDay(calendar));
    }

    /**
     * Go to the day before
     */
    public void onDayDown(View v){
        calendar.add(Calendar.DATE, -1);
        dayLiveData.setValue(computeDay(calendar));
    }

    /**
     * Go to the day after
     */
    public void onDayUp(View v){
        calendar.add(Calendar.DATE, 1);
        dayLiveData.setValue(computeDay(calendar));
    }

    /**
     * Compute the day with the wanted format
     */
    public String computeDay(Calendar calendar){
        if (calendar == null) {
            return null;
        } else {
            dayWeek = getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
            day = calendar.get(Calendar.DAY_OF_MONTH);
            month = calendar.get(Calendar.MONTH) + 1;
            year = calendar.get(Calendar.YEAR);
            return (dayWeek + " " + day + "/" + "0" + month + "/" + year);
        }
    }
}
