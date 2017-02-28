package com.ingesup.nicolas.foodmonitor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Date;
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






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

//        mListView = (ListView) findViewById(R.id.listFood);

/*        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Food.getListNameFoodList());



        mListView.setAdapter(adapter);*/
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
}
