package fors;

import java.util.stream.IntStream;

public class For {

    public static void main(String[] args) {

        for (int i = 0; i <=10; i = i+1) {
            System.out.println("I="+i);
        }

        for (int x = 0; x <=5; x++)
            System.out.println("X="+x);



        //Extra
        IntStream.of(1,2,3,4,5).forEach(n -> {
            System.out.println(n);
        });


        IntStream.range(0,3).forEach(n -> {
            System.out.println("Número = "+n);
        });

    }

}
