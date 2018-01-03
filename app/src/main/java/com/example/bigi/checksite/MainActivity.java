package com.example.bigi.checksite;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mSettings;
    private Set<String> ret;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettings = getSharedPreferences("Adresa", Context.MODE_PRIVATE);
        startAlarm();
        listView = (ListView)findViewById(R.id.listUrl);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ret = mSettings.getStringSet("strSetKey", new HashSet<String>());

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, ret);

        listView.setAdapter(adapter);
    }

    private void startAlarm() {
        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent myIntent;
        PendingIntent pendingIntent;
            myIntent = new Intent(MainActivity.this, AlarmNotificationReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this,0,myIntent,0);

            manager.setRepeating(AlarmManager.RTC_WAKEUP,SystemClock.elapsedRealtime()+3000,60*1000,pendingIntent);
    }

    public void AddUrl(View view) {
        final AlertDialog.Builder ratingdialog = new AlertDialog.Builder(this);

        ratingdialog.setTitle("Aдрес сайта");

        View linearlayout = getLayoutInflater().inflate(R.layout.add_dialog, null);
        ratingdialog.setView(linearlayout);

        final EditText rating = (EditText)linearlayout.findViewById(R.id.editText);

        ratingdialog.setPositiveButton("Добавить",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Set<String> catnames = new HashSet<String>();
                        catnames.add(rating.getText().toString());
                        catnames.addAll(ret);
                        SharedPreferences.Editor e = mSettings.edit();
                        e.putStringSet("strSetKey", catnames);
                        e.apply();
                        adapter.notifyDataSetChanged();

                        dialog.dismiss();

                    }
                })

                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        ratingdialog.create();
        ratingdialog.show();

    }
}