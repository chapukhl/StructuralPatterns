package com.epam.mp.flyweight;

public abstract class Cooker {

    protected String brandName;

    protected   Dish dish;

    public Cooker(String brandName) throws InterruptedException {
        Thread.sleep(2000);
        this.brandName = brandName;
        dish = Dish.FRESH;
    }

    public void cookDish() {
        dish = Dish.COOKED;
        System.out.println("Cooked with " + brandName);
    }
}
