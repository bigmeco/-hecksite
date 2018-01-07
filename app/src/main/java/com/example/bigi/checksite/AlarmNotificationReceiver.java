package com.example.bigi.checksite;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashSet;
import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reale on 24/11/2016.
 */

public class AlarmNotificationReceiver extends BroadcastReceiver {
    private  Context contex;
    private Intent intent;
    private SharedPreferences mSettings;
    @Override
    public void onReceive(Context context, Intent intent) {
        this.contex = context;
        this.intent = intent;
        Zapros();


    }
    private void UrlZp(String next) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(next)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Zapros userService = retrofit.create(Zapros.class);
        userService.getLog().enqueue(new Callback<String>() {
                                         @Override
                                         public void onResponse(Call<String> call, Response<String> response) {
                                             System.out.println(response.code()==200);
                                         }

                                         @Override
                                         public void onFailure(Call<String> call, Throwable t) {
                                             System.out.println(t.getMessage()+"  " );
                                         }
                                     }
        );
    }

    private void Zapros() {

//        Iterator<String> iterator =  mSettings.getStringSet("strSetKey", new HashSet<String>()).iterator();
//        while (iterator.hasNext()) {
//            UrlZp(iterator.next());
//        }

//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://developer.alexanderklimov.ru")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        Zapros userService = retrofit.create(Zapros.class);
//        userService.getLog().enqueue(new Callback<String>() {
//                                         @Override
//                                         public void onResponse(Call<String> call, Response<String> response) {
//                                             System.out.println(response.code()==200);
//                                         }
//
//                                         @Override
//                                         public void onFailure(Call<String> call, Throwable t) {
//                                             System.out.println(t.getMessage()+"  " );
//                                         }
//                                     }
//        );

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
