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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by moussa on 27/02/2017.
 */

public class FoodDAO {

    public static List<Food> getFood(){
         String name;
         String datePeremp;
         URL myURL = null;

        String url = "C:\\Users\\moussa\\AndroidStudioProjects\\FoodMonitor\\app\\src\\main\\res\\values\\data.xml" ;
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
        List<Food> listFood = new ArrayList<Food>();

        try {
            Log.d("URL", myURL.toString());
            Document doc = db.parse(myURL.openStream());
            Element racine = doc.getDocumentElement();

// récup des médecins

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
                Food food1 = new Food(name,datePeremp);
                //Medecins Med1 = new Medecins("1","1");
                //Log.d("Medecin", Med1.getPrenom());
                listFood.add(food1);
            }


        }
        catch (SAXException e) {
        e.printStackTrace();
    }

    return listFood;
    } }

