package com.example.practice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class API {
    public static void main(String[] args) throws IOException,InterruptedException {

        var url = "https://api.exchangerate.host/latest?base";


        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        var client = HttpClient.newBuilder();
       var response = client.build().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        System.out.println(response.statusCode());



//        JSONObject obj = new JSONObject(response.toString());
//             Double exchangeRate = obj.getJSONObject(("rates").getDouble(fromCode));
//             System.out.println(obj.getJSONObject("rates"));
//             System.out.println(exchangeRate);
//             System.out.println();

    }
}
