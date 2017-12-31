package com.example.bigi.checksite;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends BroadcastReceiver {
    NotificationManager nm;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Intent scheduledIntent = new Intent(context, MyService.class);
        scheduledIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                scheduledIntent, 0);

        nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Resources res = context.getResources();
        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(
                        BitmapFactory.decodeResource(res,
                                R.drawable.ic_launcher_background))
                .setTicker("Накорми кота!")
                // текст в строке состояния
                .setWhen(System.currentTimeMillis()).setAutoCancel(true)
                .setContentTitle("Время кормить кота") // Заголовок уведомления
                .setContentText("Да накорми кота, наконец"); // Текст
        // уведомления
        Notification n = builder.build();
        System.out.println("fdgsdfgd");
        nm.notify(1, n);
    }
}