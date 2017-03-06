package com.ingesup.nicolas.foodmonitor;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Principale extends AppCompatActivity {

//    ListView mListView;

    Date date1 = new Date(2017,02,28);
    Date date2 = new Date(2017,02,29);

    Food food1 = new Food("pate",date1);
    Food food2 = new Food("cereales",date2);

    NotificationManager manager;
    Notification myNotification;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //scheduleAlarm();
                createNotification("cereale");
            }
        });

        ListView listFoodView = (ListView) findViewById(R.id.listFood);



        List<HashMap<String, String>> listItem = new ArrayList<>();

        SimpleAdapter adapter = new SimpleAdapter(this, listItem, R.layout.list_item,
                new String[]{"First Line","Second Line"},
                new int[]{R.id.text1,R.id.text2});

        Iterator it = Food.listFood.entrySet().iterator();
        while (it.hasNext()){
            HashMap<String,String> resultMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultMap.put("First Line",pair.getKey().toString());
            resultMap.put("Second Line", pair.getValue().toString());
            listItem.add(resultMap);

        }

        listFoodView.setAdapter(adapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principale, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private final void createNotification(String foodName){
        Intent intent = new Intent("com.ingesup.nicolas.foodmonitor");

        PendingIntent pendingIntent = PendingIntent.getActivity(Principale.this, 1, intent, 0);

        Notification.Builder builder = new Notification.Builder(Principale.this);

        builder.setAutoCancel(false);
        builder.setTicker("this is ticker text");
        builder.setContentTitle("Un aliment est périmé !");
        builder.setContentText(foodName + " est périmé");
        builder.setSmallIcon(R.drawable.notification);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
        builder.setSubText("Il est déconseillé de le consommer");   //API level 16
        builder.setNumber(100);
        builder.build();

        myNotification = builder.getNotification();
        manager.notify(11, myNotification);
    }


    public void scheduleAlarm()
    {
        Calendar time = Calendar.getInstance();
        time.set(2017,03,07,16,20,0);
        long time2 = time.getTimeInMillis();
        // Create an Intent and set the class that will execute when the Alarm triggers. Here we have
        // specified AlarmReciever in the Intent. The onReceive() method of this class will execute when the broadcast from your alarm is received.
        Intent intentAlarm = new Intent(this, AlarmReciever.class);

        // Get the Alarm Service.
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // Set the alarm for a particular time.
        alarmManager.set(AlarmManager.RTC_WAKEUP, time2, PendingIntent.getBroadcast(this, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Alarm Scheduled", Toast.LENGTH_LONG).show();
    }
}
