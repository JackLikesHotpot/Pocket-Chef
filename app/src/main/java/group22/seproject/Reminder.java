package group22.seproject;

import java.sql.Time;
import java.util.Calendar;

//Unused. Reminder class would set a reminder to notify a user at a certain time and date.

public class Reminder {
    private Calendar startDate;
    private Time time;

    public Reminder(Calendar date, Time time) {
        startDate = date;
        this.time = time;
    }

    public void sendNotification() {
    }
}
