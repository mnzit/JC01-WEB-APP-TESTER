package com.ggic.tester;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;

public class ApiTest implements Callable<String> {
    private static final String LOCAL_BASE_URL = "http://localhost:9091/api/";
    private static final String PROD_BASE_URL = "https://ggic.herokuapp.com/api/";

    @Override
    public String call() {
        try {
                // create a client
                HttpClient client = HttpClient.newHttpClient();

                // create a request
                HttpRequest request = HttpRequest
                        .newBuilder(URI.create(LOCAL_BASE_URL + "students"))
                        .header("accept", "application/json")
                        .build();

                // use the client to send the request
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // the response:
                return response.body();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return "ERROR";
        }
    }
}
