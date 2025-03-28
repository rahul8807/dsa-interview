package com.azure.azure.test;


import java.math.BigDecimal;

public class JavaFetaures {

    static String s ;

    public static void main ( String[] args ) {
        var person1 = new Person ( 30, "Rohit" );

        String day = "MONDAY";
        String message = switch (day) {
            case "MONDAY" -> "GET UP EARLY";
            default -> "OK";
        };
        var html = """
                hey %s,
                    Good morning, hope you are doing good
                    
                Thanks & Regards 
                """.formatted ( "Rahul" );

        System.out.println (html );

        var transaction1 = new Money ( 1234, BigDecimal.valueOf ( 10000 ) );
        System.out.println (transaction1 );

        Object obj = new String ( "Hello Pattern Matching" );
        if(obj instanceof String g){
            System.out.println (g );
        }


        System.out.println (s.getBytes () );


        Thread.ofPlatform().start ( () -> {} );

    }

}
