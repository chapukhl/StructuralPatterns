package com.epam.mp.main;

import com.epam.mp.composite.impl.Army;
import com.epam.mp.adapter.GsonAdapterParser;
import com.epam.mp.adapter.JacksonAdapterParser;
import com.epam.mp.adapter.UserJsonParser;
import com.epam.mp.model.User;


import java.io.IOException;

public class AdapterRunner {

    public static void main(String[] args) throws IOException {
       UserJsonParser userJsonParser = new GsonAdapterParser();
//        userJsonParser.readUser();
//        userJsonParser.updateUser(new User("qwerty", "test"));
        userJsonParser = new JacksonAdapterParser();
        System.out.println(userJsonParser.readUser());
        userJsonParser.updateUser(new User("miav", "Mur"));
        //AIzaSyAAnWL_KMg5pgIBJXcLb0veFPU4xbHYV44

        //compositeTest();


    }

    private static void compositeTest() {
        Army army = new Army.ArmyBuilder().divisions(2).
                battalions(3).regiments(4).
                platoons(5).squards(6).soldires(20).
                build();
        army.getFormations().get(0).getFormations().get(0).cryHooray();
    }
}
