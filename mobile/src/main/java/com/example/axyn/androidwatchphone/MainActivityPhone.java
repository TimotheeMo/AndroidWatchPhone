package com.example.axyn.androidwatchphone;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivityPhone extends AppCompatActivity{

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_phone);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View arg0) {
              try {
                  //buttonNotification(arg0);
                  //setNotificationManager(001);
                  Log.d("app", "pushing button");
              }catch (Exception e){
                  e.printStackTrace();
              }
          }
        });
    }

    /*public void setNotificationManager(NotificationManager notificationManager){
        int notificationId=001;
        //Notification code
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

        //Notification manager
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, mBuilder.build());
    }


    public void onClick(View v){
        //Create instance of NotificationCompact.Builder
        int notificationId = 001;
        // Build intent for notification content
        Intent viewIntent = new Intent(this, SecondActivity.class);
        PendingIntent viewPendingIntent = PendingIntent.getActivity(this, 0, viewIntent, 0);

        //Building notification layout
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Notifications")
                        .setContentText("Hellow World !!")
                        .setContentIntent(viewPendingIntent);

        // instance of the NotificationManager service
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // Build the notification and notify it using notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }*/
}

