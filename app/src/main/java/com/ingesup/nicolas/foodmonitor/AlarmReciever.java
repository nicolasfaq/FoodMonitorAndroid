package com.ingesup.nicolas.foodmonitor;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Nicolas on 06/03/2017.
 */

public class AlarmReciever extends BroadcastReceiver {

    NotificationManager manager;
    Notification myNotification;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);

        Notification.Builder builder = new Notification.Builder(context);

        builder.setAutoCancel(false);
        builder.setTicker("this is ticker text");
        builder.setContentTitle("Un aliment est périmé !");
        builder.setContentText("L'aliment est périmé");
        builder.setSmallIcon(R.drawable.notification);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
        builder.setSubText("Il est déconseillé de le manger");   //API level 16
        builder.setNumber(100);
        builder.build();

        myNotification = builder.getNotification();
        manager.notify(11, myNotification);

    }
}
