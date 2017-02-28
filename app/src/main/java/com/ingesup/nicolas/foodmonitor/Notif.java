package com.ingesup.nicolas.foodmonitor;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by moussa on 27/02/2017.
 */

public class Notif {

/*
    public class MainActivity extends Principale {
        public int ID_NOTIFICATION = 0;

        private GoogleApiClient client;

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
            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        }


        public Action getIndexApiAction() {
            Thing object = new Thing.Builder()
                    .setName("Main Page") // TODO: Define a title for the content shown.
                    // TODO: Make sure this auto-generated URL is correct.
                    .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                    .build();
            return new Action.Builder(Action.TYPE_VIEW)
                    .setObject(object)
                    .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                    .build();
        }

        @Override
        public void onStart() {
            super.onStart();

            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            client.connect();
            AppIndex.AppIndexApi.start(client, getIndexApiAction());
        }

        @Override
        public void onStop() {
            super.onStop();

            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            AppIndex.AppIndexApi.end(client, getIndexApiAction());
            client.disconnect();
        }
    }*/
}
