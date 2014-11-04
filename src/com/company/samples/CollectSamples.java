package com.company.samples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by George.Mao on 10/24/2014.
 */
public class CollectSamples {

    public static boolean isOdd(int integer){
        try {
            Thread.sleep(1000); // simulates some long running logic
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return integer %2 != 0;
    }
    public static void main (String [] args){
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

        // Put odds in one array and evens in another
        Map<Boolean, List<Integer>> resultMap = values.stream()
                .collect(Collectors.groupingBy(CollectSamples::isOdd));


        // Showthe results
        resultMap.forEach( (k,v) -> {
            System.out.print(k);
            System.out.println(v);

        });

        // Put odds in one array and evens in another, do it in parallel
        values.parallelStream()
                .collect(Collectors.groupingBy(CollectSamples::isOdd))
                .forEach( (k,v) -> {
                    System.out.print(k);
                    System.out.println(v);
        });

        // Put odds in one array and evens in another, but only for numbers > 3, do it in parallel
        values.parallelStream()
                .filter(e->e>3)
                .collect(Collectors.groupingBy(CollectSamples::isOdd))
                .forEach( (k,v) -> {
                    System.out.print(k);
                    System.out.println(v);
                });

    }

}
