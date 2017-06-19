package com.example.axyn.androidwatchphone;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivityPhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_phone);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNotificationClick(v);
            }
        });
    }
        /*//Notification code
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("My notification")
                .setContentText("Hello World!");


        //Notification manager
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, notificationBuilder.build());*/

        public void buttonNotificationClick(View v){
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
        }
}

