package com.company;

/**
 * Created by George.Mao on 10/21/2014.
 */
public abstract class Vehicle {

    private Color color;
    private String make;
    private int hp;

    protected Vehicle() {
        System.out.println("In Vehicle Default consturctor ...");
    }

    protected Vehicle(Color color, String make, int hp) {
        this.color = color;
        this.make = make;
        this.hp=hp;
        System.out.println("In Vehicle Constructor ...");
    }

    public abstract int getHorsePower();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    @Override
    public String toString(){
        return color+":"+make+":"+hp;
    }

}
