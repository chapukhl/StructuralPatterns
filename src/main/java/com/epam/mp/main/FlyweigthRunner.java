package com.epam.mp.main;

import com.epam.mp.flyweight.SharedKitchen;

public class FlyweigthRunner {

    public static void main(String[] args) throws InterruptedException {
       SharedKitchen sharedKitchen = SharedKitchen.getInstance();
       sharedKitchen.getCooker("Bosch").cookDish();
        sharedKitchen.getCooker("Electrolux").cookDish();
        sharedKitchen.getCooker("Gefest").cookDish();
    }
}
