package com.epam.mp.adapter;

import com.epam.mp.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GsonAdapterParser implements UserJsonParser {

    private Gson gson;

    private JsonReader reader;


    public GsonAdapterParser() throws IOException {
        this.gson = new GsonBuilder().create();
        reader = new JsonReader(new FileReader(FILENAME));
    }

    @Override
    public User readUser() {
        User user = gson.fromJson(reader, User.class);
        System.out.println(user);
        return user;
    }

    @Override
    public void updateUser(User user) throws IOException {
        String userJson = gson.toJson(user);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILENAME))) {
            writer.write(userJson);
        }
    }


}
