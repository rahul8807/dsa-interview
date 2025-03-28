package com.azure.azure.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream2 {

    public static void main ( String[] args ) {
        int[] arr = {1, 2, 3, 4, 1, 2, 1};

        List < Integer > list = Arrays.stream ( arr )
                .boxed ( )
                .collect ( Collectors.groupingBy ( e -> e, Collectors.counting ( ) ) )
                .entrySet ( )
                .stream ( )
                .filter ( e -> e.getValue ( ) > 1 )
                .map ( e -> e.getKey ( ) )
                .collect ( Collectors.toList ( ) );

        System.out.println (list );
    }

}
