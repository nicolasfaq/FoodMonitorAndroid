package com.ingesup.nicolas.foodmonitor;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nicolas on 27/02/2017.
 */

public class Food {
    private String name;
    private Date expDate;
    public static HashMap<String, Date> listFood = new HashMap<>() ;

    Food (String name, Date expDate){
        this.name = name;
        this.expDate = expDate;
        listFood.put(this.name,this.expDate );
    }

    public String getName() {
        return name;
    }

    public Date getExpDate(){
        return expDate;
    }

/*    public static List<String> getListNameFoodList(){
        List<String> names = new ArrayList<String>() {};

        for (Food food:listFood
             ) {
            names.add(food.name);
        }

        return names;
    }*/
}
