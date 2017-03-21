package com.epam.mp.facade;

import java.io.IOException;

public class JsonPlaceholderFacadeImpl implements JsonPlaceholderFacade {

    private DeleteApi deleteApi;

    private GetApi getApi;

    public JsonPlaceholderFacadeImpl() {
        deleteApi = new DeleteApi();
        getApi = new GetApi();
    }

    public void deletePost(long id) throws IOException {
        deleteApi.deletePost(id);
    }

    public void deleteComments(long id) throws IOException {
        deleteApi.deleteComments(id);
    }

    public void deleteAlbums(long id) throws IOException {
        deleteApi.deleteAlbums(id);
    }

    public String getPosts() throws IOException {
        return getApi.getPosts();
    }

    public String getComments() throws IOException {
        return getApi.getComments();
    }

    public String getAlbums() throws IOException {
        return getApi.getAlbums();
    }
}
