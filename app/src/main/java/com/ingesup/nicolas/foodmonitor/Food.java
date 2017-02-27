package com.ingesup.nicolas.foodmonitor;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nicolas on 27/02/2017.
 */

public class Food {
    private String name;
    private String expDate;
    public static ArrayList<Food> listFood = new ArrayList<Food>() ;

    Food (String name, String expDate){
        this.name = name;
        this.expDate = expDate;
        listFood.add(this);
    }

    public String getName() {
        return name;
    }

    public String getExpDate(){
        return expDate;
    }

    public static List<String> getListNameFoodList(){
        List<String> names = new ArrayList<String>() {};

        for (Food food:listFood
             ) {
            names.add(food.name);
        }

        return names;
    }
}
