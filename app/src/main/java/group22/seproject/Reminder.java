package group22.seproject;

import java.io.File;
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

    public static void main(String[] args) {
        File f = new File(System.getProperty("user.dir") + "/app/sampledata/users.txt");
        System.out.println(f.exists());
        //System.out.println("Current directory is " + System.getProperty("user.dir"));
    }
}
