package com.epam.mp.facade;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class DeleteApi {

    public void deletePost(long id) throws IOException {
        deleteRequest("https://jsonplaceholder.typicode.com/posts/" + id);
    }

    public void deleteComments(long id) throws IOException {
        deleteRequest("https://jsonplaceholder.typicode.com/comments" + id);
    }

    public void deleteAlbums(long id) throws IOException {
        deleteRequest("https://jsonplaceholder.typicode.com/albums" + id);
    }

    private void deleteRequest(String apiUrl) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();

        HttpDelete request = new HttpDelete(apiUrl);

        client.execute(request);
    }
}
