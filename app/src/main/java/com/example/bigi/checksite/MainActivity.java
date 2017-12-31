package com.example.bigi.checksite;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;

import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

//
//        Intent myIntent = new Intent(getBaseContext(),
//                MyService.class);
//
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(
//                getBaseContext(), 0, myIntent, 0);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.add(Calendar.SECOND, 10);
//        long interval = 60 * 1000; //
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
//                calendar.getTimeInMillis(), interval, pendingIntent);
//        finish();



    }



    public void setOneTimeAlarm() {
        Intent intent = new Intent(this, MyService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                intent, PendingIntent.FLAG_ONE_SHOT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (5 * 1000), pendingIntent);
    }

    public void setRepeatingAlarm() {
        Intent intent = new Intent(this, MyService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(), (5 * 1000), pendingIntent);
    }

    public void onClice(View view) {
        setRepeatingAlarm();
        System.out.println("fdgsdfgd");
    }
}