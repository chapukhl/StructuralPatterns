package com.epam.mp.facade;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetApi {

    public String getPosts() throws IOException {
        return getRequest("https://jsonplaceholder.typicode.com/posts");
    }

    public String getComments() throws IOException {
        return getRequest("https://jsonplaceholder.typicode.com/comments");
    }

    public String getAlbums() throws IOException {
        return getRequest("https://jsonplaceholder.typicode.com/albums");
    }


    private String getRequest(String apiUrl) throws IOException {
        HttpResponse response = performRequest(apiUrl);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        return printResponse(rd);
    }

    private HttpResponse performRequest(String apiUrl) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(apiUrl);

        return client.execute(request);
    }

    private String printResponse(BufferedReader rd) throws IOException {
        String line;
        StringBuilder resultResponse = new StringBuilder();
        while ((line = rd.readLine()) != null) {

            resultResponse.append(line);
        }
        return resultResponse.toString();
    }

}
