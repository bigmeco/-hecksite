package com.example.bigi.checksite;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mSettings;
    private Set<String> ret;
    private ListView listView;
    private ArrayList<UrlPojo> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettings = getSharedPreferences("Adresa", Context.MODE_PRIVATE);
        listView = (ListView) findViewById(R.id.listUrl);
        startListUrl();
        startAlarm();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Set<String> catnames = new HashSet<String>();
                catnames.remove(data.get(position).getStatus());

                ImageView delite = (ImageView) view.findViewById(R.id.delite);

                SharedPreferences.Editor e = mSettings.edit();
                e.putStringSet("strSetKey", catnames);
                e.apply();
                delite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
            }
        });

        }




    @Override
    protected void onResume() {
        super.onResume();

    }

    private void startAlarm() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent myIntent;
        PendingIntent pendingIntent;
        myIntent = new Intent(MainActivity.this, AlarmNotificationReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0);

        manager.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime() + 3000, 60 * 1000, pendingIntent);
    }


    private void startListUrl() {
        ret = mSettings.getStringSet("strSetKey", new HashSet<String>());
        Iterator<String> iterator = ret.iterator();
        while (iterator.hasNext()) {
            data.add(new UrlPojo(iterator.next(), "11", Color.RED));
        }
        listView.setAdapter(new UrlAdapter(this, data));
    }

    public void AddUrl(View view) {
        final AlertDialog.Builder ratingdialog = new AlertDialog.Builder(this);

        ratingdialog.setTitle("Aдрес сайта");

        View linearlayout = getLayoutInflater().inflate(R.layout.add_dialog, null);
        ratingdialog.setView(linearlayout);

        final EditText rating = (EditText) linearlayout.findViewById(R.id.editText);

        ratingdialog.setPositiveButton(R.string.add,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Set<String> catnames = new HashSet<String>();
                        catnames.add(rating.getText().toString());
                        catnames.addAll(ret);
                        SharedPreferences.Editor e = mSettings.edit();
                        e.putStringSet("strSetKey", catnames);
                        e.apply();

                        data.add(new UrlPojo(rating.getText().toString(), "11", Color.RED));

                        dialog.dismiss();

                    }
                })

                .setNegativeButton(R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        ratingdialog.create();
        ratingdialog.show();

    }
}