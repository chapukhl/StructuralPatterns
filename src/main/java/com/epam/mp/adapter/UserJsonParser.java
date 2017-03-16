package com.epam.mp.adapter;

import com.epam.mp.model.User;

import java.io.IOException;

public interface UserJsonParser {

    String FILENAME = "src/main/resources/user.json";

    User readUser() throws IOException;

    void updateUser(User newUser) throws IOException;
}
