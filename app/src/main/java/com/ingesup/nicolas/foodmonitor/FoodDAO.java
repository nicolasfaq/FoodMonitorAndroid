package com.ingesup.nicolas.foodmonitor;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by moussa on 27/02/2017.
 */

public class FoodDAO {

    public static HashMap<String,Date> getFood(){
        String name=null;
        String datePeremp=null;
        URL myURL = null;



        String url = "../data.xml" ;

        try {
            myURL = new URL(url);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        HashMap<String,Date> listFood = new HashMap<String,Date>();

        try {
            Log.d("URL", myURL.toString());
            Document doc = null;
            try {
                doc = db.parse(myURL.openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Element racine = doc.getDocumentElement();

// récup de la food

            NodeList list = racine.getElementsByTagName("product");

            for (int i = 0; i < list.getLength(); i++) {
                Node food = list.item(i);
                NodeList lesProprietes = food.getChildNodes();
// recherche du nom
                for (int j = 0; j < lesProprietes.getLength(); j++) {

                    if (lesProprietes.item(j).getNodeName().equals("name")) {
                        name = lesProprietes.item(j).getTextContent().trim();
                    }
                    if (lesProprietes.item(j).getNodeName().equals("expdate")) {
                        datePeremp = lesProprietes.item(j).getTextContent().trim();
                    }
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Food food1 = null;

                try {
                    listFood.put(name,dateFormat.parse(datePeremp));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


        }
        catch (SAXException e) {
            e.printStackTrace();
        }

        return listFood;
    } }

