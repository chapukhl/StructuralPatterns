package com.epam.mp.facade;

import java.io.IOException;

public interface JsonPlaceholderFacade {

    void deletePost(long id) throws IOException;


    void deleteComments(long id) throws IOException;


    void deleteAlbums(long id) throws IOException;


    String getPosts() throws IOException;

    String getComments() throws IOException;

    String getAlbums() throws IOException;
}
