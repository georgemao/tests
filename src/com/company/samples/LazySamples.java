package com.company.samples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by George.Mao on 10/22/2014.
 */
public class LazySamples {
    static List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    public static void main(String[] args){
        // Sum all odds, greater than 3
        System.out.println(sumOddsGT3());

        System.out.println(sumOddsGT3New());
    }

    /* Sum all odds, greater than  3*/
    // Imperataive way
    public static int sumOddsGT3(){
        int sum=0;

        for(int i:values){
            System.out.println("In Loop...");
            if(i%2!=0 && i > 3)
                sum+=i;
        }

        return sum;
    }

    // Declarative/Functional way
    public static int sumOddsGT3New(){
        int  sum=0;
        Stream<Integer> st = values.stream()
                .filter(LazySamples::isGT3)   // these are lazy & fused together
                .filter(LazySamples::isOdd);

        sum = st.reduce(0, Math::addExact); // if terminal operation is commented out, this doesnt do anything

        return sum;

    }

    public static boolean isGT3(int number){
        System.out.println("isGT3: " + number);
        return number > 3;
    }

    public  static boolean isOdd(int number){
        System.out.println("isOdd:" + number);
        return number % 2 !=0;
    }

}
