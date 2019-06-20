package com.example.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 12331;
    public static final String TAG ="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        notification = new NotificationCompat.Builder(this);

        notification.setAutoCancel(true);

    }

        public void buckyButtonClicked(View view){


            //Build notification
            notification.setSmallIcon(R.drawable.ic_launcher_foreground);
            notification.setTicker("This is ticker");
            notification.setWhen(System.currentTimeMillis());
            notification.setContentTitle("This is Title");
            notification.setContentText("I am the text body of yoyr notification ");

            Intent intent = new Intent(this,MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this , 0 , intent,PendingIntent.FLAG_UPDATE_CURRENT);
            notification.setContentIntent(pendingIntent);

            //Build notification and issue it
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(uniqueID ,notification.build());

        }
    }

