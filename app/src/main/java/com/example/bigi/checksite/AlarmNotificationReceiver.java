package com.example.bigi.checksite;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by reale on 24/11/2016.
 */

public class AlarmNotificationReceiver extends BroadcastReceiver {
    private  Context contex;
    private Intent intent;
    @Override
    public void onReceive(Context context, Intent intent) {
        this.contex = context;
        this.intent = intent;
        Zapros();
    }

    private void Zapros() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(contex);
        builder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alarm actived!")
                .setContentText("THIS IS MY ALARM")
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setContentInfo("Info");

        NotificationManager notificationManager = (NotificationManager)contex.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }
}
