package group22.seproject;

import java.sql.Time;
import java.util.Calendar;

public class Reminder {
    private Calendar startDate;
    private Time time;

    public Reminder(Calendar date, Time time){
        startDate = date;
        this.time = time;
    }

    public void sendNotification(){
    }
}
