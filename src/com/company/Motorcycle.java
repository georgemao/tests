package com.company;

/**
 * Created by George.Mao on 10/21/2014.
 */
public class Motorcycle extends Vehicle {
    public Motorcycle() {
    }

    public Motorcycle(Color color, String make, int hp) {
        super(color, make, hp);
        System.out.println("In Moto Constructor ...");
    }

    @Override
    public int getHorsePower() {
        return 1000;
    }
}
