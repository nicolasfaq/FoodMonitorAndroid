package com.ingesup.nicolas.foodmonitor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by moussa on 27/02/2017.
 */

public class Notif {
    import android.app.Activity;
    import android.app.Notification;
    import android.app.NotificationManager;
    import android.app.PendingIntent;
    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;

    public class MainActivity extends Principale {
        public int ID_NOTIFICATION = 0;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_principale);

            Button b = (Button) findViewById(R.id.launch);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // L'icône sera une petite loupe
                    int icon = R.drawable.ic_action_search;
                    // Le premier titre affiché
                    CharSequence tickerText = "Titre de la notification";
                    // Daté de maintenant
                    long when = System.currentTimeMillis();

                    // La notification est créée
                    Notification notification = new Notification(icon, tickerText, when);

                    Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                    notificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent, 0);

                    notification.setLatestEventInfo(MainActivity.this, "Titre", "Texte", contentIntent);

                    // Récupération du Notification Manager
                    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                    manager.notify(ID_NOTIFICATION, notification);
                }
            });
        }
    }
}
