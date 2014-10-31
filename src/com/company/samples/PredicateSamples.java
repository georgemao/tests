package com.company.samples;

import com.company.Car;
import com.company.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by George.Mao on 10/22/2014.
 */
public class PredicateSamples {

    static List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

    public static void main(String[] args){


        // Sum the numbers
        System.out.println(sum());
        System.out.println(sumNew());
        System.out.println(sumOddsNew(e -> true));

        //Sum the odds
        System.out.println(sumOdds());
        System.out.println(sumOddsNew());
        System.out.println(sumOddsNew(e -> e % 2 != 0));

        //Test predicates on objects
        testPredicates();

    }

    /* Sum the numbers */
    // Imperative way
    public static int sum(){
        int sum =0;
        for(Integer i: values){
            sum+=i;
        }
        return sum;
    }

    // Functional/Declarative way
    public static int sumNew(){
        return values.stream()
                     .reduce(0, Math::addExact);
    }

    /*Sum only odd numbers*/
    // Imperative way
    public static int sumOdds(){
        int sum =0;
        for(Integer i: values){
            if(i % 2 !=0)
                sum+=i;
        }
        return sum;
    }

    // Functional/Declarative way
    public static int sumOddsNew(){
        return values.stream()
                     .filter(e -> e%2 !=0)
                     .reduce(0, Math::addExact);

    }

    // Functional/Declarative way, even better with Predicates
    public static int sumOddsNew(Predicate<Integer> selector){
        return values.stream()
                .filter(selector)
                .reduce(0, Math::addExact);

    }

    public static void testPredicates(){
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(Color.BLACK, "Tesla", 333));
        cars.add(new Car(Color.RED, "Ford", 222));
        cars.add(new Car(Color.BLUE, "Honda", 111));

        Predicate<Car> blacks = e -> e.getColor() == Color.BLACK;
        Predicate<Car> blacksAndBlues = e -> e.getColor() == Color.BLACK || e.getColor() == Color.BLUE;

        cars.stream()
            .filter(blacks)
            .forEach(System.out::println);


        cars.stream()
                .filter(blacksAndBlues)
                .forEach(System.out::println);


        cars.stream()
            .map( PredicateSamples::upTheHP) // or lambda style: e -> upTheHP(e)
            .collect(Collectors.toList())
            .forEach(System.out::println);
    }

    private static Car upTheHP(Car car){
        car.setHp(car.getHp()+100);

        return car;
    }
}
