package com.epam.mp.main;

import com.epam.mp.composite.impl.Army;

public class CompositeRunner {

    public static void main(String[] args) {
        compositeTest();
    }

    private static void compositeTest() {
        Army army = new Army.ArmyBuilder().divisions(2).
                battalions(3).regiments(4).
                platoons(5).squards(6).soldires(20).
                build();
        army.getFormations().get(0).getFormations().get(0).cryHooray();
    }
}
