package com.company.samples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by George.Mao on 10/22/2014.
 */
public class StreamSamples {

    public static int doubleit(int number){

        // Pretend we this code takes a long tim to execute
        try { Thread.sleep(1000); } catch (Exception e) {} ;
        return number *2;
    }
    public static void main(String [] args){

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.println(
                values.stream()
                      .mapToInt(StreamSamples::doubleit)
                      .sum()
        );

        // do it concurrently
        System.out.println(
                values.parallelStream()
                        .mapToInt(StreamSamples::doubleit)
                        .sum()

        );

    }
}
