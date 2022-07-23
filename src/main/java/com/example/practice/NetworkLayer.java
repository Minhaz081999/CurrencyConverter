package com.example.practice;
import org.json.*;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class NetworkLayer {

    private static NetworkLayer shared = new NetworkLayer();
    private NetworkLayer(){}


    private double result;
    public static NetworkLayer getSharedObject(){
        return shared;
    }

    public double getLatestCurrency(String fromCountryCode, String toCountryCode, float amount) throws IOException, ParseException {

           try {
               String GET_URL = "https://api.exchangerate.host/convert?from=" +fromCountryCode  + "&to=" + toCountryCode+ "&amount=" + amount;

               URL url = new URL(GET_URL);
               HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
               httpsURLConnection.setRequestMethod("GET");
               int responseCode = httpsURLConnection.getResponseCode();

               String inline = "";
               if(responseCode != 200)
                   throw new RuntimeException("HttpResponseCode: " +responseCode);
               else
               {
                   Scanner sc = new Scanner(url.openStream());

                   while(sc.hasNext())
                   {
                       inline += sc.nextLine();
                   }
                   System.out.println("\nJSON data in string format");
                   System.out.println(inline);
                   sc.close();
               }

               JSONObject obj = new JSONObject(inline);
                result = obj.getDouble("result");

               System.out.println("Result= " + result);


           } catch (Exception e) {

               e.printStackTrace();
           }

          return result;
    }
}
