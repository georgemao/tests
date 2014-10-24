package com.company;

/**
 * Created by George.Mao on 10/21/2014.
 */
public class Car extends Vehicle {

    public Car() {
        System.out.println("In Car Default consturctor ...");
    }

    public Car(Color color, String make, int hp) {
        super(color, make, hp);
        System.out.println("In Car Constructor ...");
    }

    @Override
    public int getHorsePower() {
        return 100;
    }
}
