package com.company;

/**
 * Created by George.Mao on 10/20/2014.
 */
public enum Color {

    RED(1){
        @Override
        public int getPrice() {
            return 100;
        }
    },
    BLACK(2){
        @Override
        public int getPrice() {
            return 200;
        }
    },
    BLUE(3){
        @Override
        public int getPrice() {
            return 300;
        }
    };

    private int value;

    private Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract int getPrice();
}
