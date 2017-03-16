package com.epam.mp.flyweight;

import com.epam.mp.flyweight.impl.CookerBosch;
import com.epam.mp.flyweight.impl.CookerGefest;
import com.epam.mp.flyweight.impl.CookerOther;

import java.util.HashMap;
import java.util.Map;

public class SharedKitchen {

    private static SharedKitchen instance;

    private static Map<String, Cooker> flyweightPool;

    private SharedKitchen() {
        flyweightPool = new HashMap<>();
        try {
            flyweightPool.put("Bosch", new CookerBosch());
            flyweightPool.put("Gefest", new CookerGefest());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static SharedKitchen getInstance() {
        if (instance == null) {
            instance = new SharedKitchen();
        }
        return instance;
    }

    public Cooker getCooker(String brandName) throws InterruptedException {
        Cooker cooker;
        if (flyweightPool.containsKey(brandName)) {
            cooker = flyweightPool.get(brandName);
        } else {
            cooker = new CookerOther(brandName);
        }

        return cooker;
    }
}
