package com.example.axyn.androidwatchphone;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Wearable;

public class MainActivityPhone extends AppCompatActivity{

    //private int notificationId= 0;
    private static final String EXTRA_EVENT_ID = "extra_event_id";
    private static final String TAG = "PhoneActivity";
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_phone);

        //Accessing the Wearable Data Layer
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle connectionHint) {
                        Log.d(TAG, "onConnected: " + connectionHint);
                    }
                    @Override
                    public void onConnectionSuspended(int cause) {
                        Log.d(TAG, "onConnectionSuspended: " + cause);
                    }
                })
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(ConnectionResult result) {
                        Log.d(TAG, "onConnectionFailed: " + result);
                    }
                })
                .addApi(Wearable.API)
                .build();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    private void sendNotification(){
        int eventId= 3;
        if(mGoogleApiClient.isConnected()){
            //Create instance of NotificationCompact.Builder
            int notificationId = 001;
            // Build intent for notification content
            Intent viewIntent = new Intent(this, MainActivityPhone.class);
            viewIntent.putExtra(EXTRA_EVENT_ID, eventId);
            PendingIntent viewPendingIntent = PendingIntent.getActivity(this, 0, viewIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Action action= new NotificationCompat.Action.Builder(
                    R.mipmap.ic_launcher, getString(R.string.wearTitle), viewPendingIntent).build();

            //Building notification layout
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(getString(R.string.wearTitle))
                    .setContentText("Hello World !! Tim Test")
                    .setContentIntent(viewPendingIntent)
                    .extend(new NotificationCompat.WearableExtender().addAction(action));
            //.build();

            // instance of the NotificationManager service
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

            // Build the notification and notify it using notification manager.
            notificationManager.notify(notificationId, notificationBuilder.build());
        }else{
            Log.d(TAG, "Connection to Wearable impossible. Please reconnect Wearable.");
        }
    }


    //Create a menu tab with just settings tab
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

