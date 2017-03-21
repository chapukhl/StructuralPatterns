package com.epam.mp.main;

import com.epam.mp.adapter.GsonAdapterParser;
import com.epam.mp.adapter.JacksonAdapterParser;
import com.epam.mp.adapter.UserJsonParser;
import com.epam.mp.model.User;


import java.io.IOException;

public class AdapterRunner {

    public static void main(String[] args) throws IOException {
        UserJsonParser userJsonParser = new GsonAdapterParser();
        userJsonParser.readUser();
        userJsonParser.updateUser(new User("newFirstName", "newLastName"));
        userJsonParser = new JacksonAdapterParser();
        System.out.println(userJsonParser.readUser());
        userJsonParser.updateUser(new User("brandNewFirstName", "brandNewLastName"));


    }


}
