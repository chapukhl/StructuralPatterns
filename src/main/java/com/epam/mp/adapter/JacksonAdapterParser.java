package com.epam.mp.adapter;

import com.epam.mp.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JacksonAdapterParser implements UserJsonParser {
    @Override
    public User readUser() throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(FILENAME));

        return new ObjectMapper().readValue(jsonData, User.class);
    }

    @Override
    public void updateUser(User newUser) throws IOException {
        new ObjectMapper().writeValue(new File(FILENAME), newUser);
    }
}
