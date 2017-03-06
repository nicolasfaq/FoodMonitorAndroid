package com.ingesup.nicolas.foodmonitor;

import android.widget.ImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nicolas on 27/02/2017.
 */

public class Food {
    private String name;
    private String expDate;
    public static HashMap<String, String> listFood = new HashMap<>() ;

    Food (String name, String expDate){
        this.name = name;
        this.expDate = expDate;
    }

    public String getName() {
        return name;
    }

    public Date getExpDate(){
        return expDate;
    }

    public Date toDate(String strDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
