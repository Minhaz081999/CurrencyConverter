package com.example.practice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/ffdc00a4276f5a470d51faa9/latest/USD?fbclid=IwAR0AqPBQe3UA7Z5ctRU5rX4nxJB4EwmtKbQdi6VicOag6SCTvrTpNVjPDgQ"))
                .header("X-RapidAPI-Key", "bc4a80a150msh10d5a9797c19fb5p185835jsn0628db3c4fed")
                .header("X-RapidAPI-Host", "currency-converter5.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
}}
