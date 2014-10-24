package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        new Car();

        enumTest();

        streamTest();

        mapReduceTest();

    }

    private static void enumTest() {
        List<Color> a = Arrays.asList(Color.values());

        a.forEach(i -> System.out.println(i));
        a.forEach(i -> {
            System.out.println(i);
            System.out.println(i.getValue());

        });

        a.forEach(System.out::println);

        for (Color c : Color.values()) {
            System.out.println(c + ":" + c.getValue());
        }
    }

    private static void streamTest(){
        List<Integer> numbers = Arrays.asList(1,2,3);

       // Predicate odds = ;
        List<Integer> odds =
                numbers.stream()
                .filter(n -> (n%2 !=0))
                .collect(Collectors.toList());


        odds.forEach(System.out::println);
    }

    private static void mapReduceTest(){
        List<Vehicle> vs = new ArrayList<Vehicle>();
        vs.add(new Car(Color.RED, "Tesla", 100));
        vs.add(new Motorcycle(Color.BLUE, "Honda", 1000));

        vs.stream().map(n -> updateVehicle(n)).collect(Collectors.toList());
        vs.forEach(System.out::println);

        vs = vs.stream()
                .filter(n -> n.getHp() > 200)
                .collect(Collectors.toList());


        vs.forEach(System.out::println);


    }

    private static Vehicle updateVehicle(Vehicle v){
        v.setHp(v.getHorsePower()+1);
        return v;
    }
}
