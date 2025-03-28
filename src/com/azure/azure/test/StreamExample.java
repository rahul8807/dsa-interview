package com.azure.azure.test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExample {

    public static Predicate<Person> predicate = (e) -> e.getAge () > 25;

    public static void main ( String[] args ) {
        List <String> words = Arrays.asList("apple", "banana", "kiwi", "grape", "orange", "fig");

        List filteredOutput = words.stream ()
                .filter ( e -> e.length () >= 5 )
                .collect ( Collectors.toList () );
        System.out.println (filteredOutput);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> consList = numbers.stream ()
                .map ( e -> e*e )
                .collect( Collectors.toList ());
        System.out.println (consList );

        List<Integer> numbers2 = Arrays.asList(10, 5, 20, 8, 15);

        Optional <Integer> max = numbers2.stream( ).max  (  ( a, b) -> a.compareTo(b) );

        System.out.println (max.get () );

        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "David");
        List sortedList = names.stream( ).sorted ().toList ();
        System.out.println (sortedList );
        sortedList = names.stream( ).sorted ( (a,b) -> b.compareTo ( a ) ).toList ();
        System.out.println (sortedList );

        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers4 = numbers3.stream( ).filter ( e -> e%2 == 0 ).collect ( Collectors.toList () );
        numbers3.stream( ).filter ( e -> e%2 == 0 ).count ();
        System.out.println (numbers4.size () );

        List<String> words1 = Arrays.asList("apple", "banana", "orange");
        String x = words1.stream ().collect ( Collectors.joining (",") );
        System.out.println (x );

        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        OptionalDouble d = numbers5.stream( ).mapToDouble ( Integer::intValue ).average ();
        System.out.println (d.getAsDouble () );

        List<String> words5 = Arrays.asList("apple", "banana", "kiwi", "grape", "orange", "fig");
        Map <Integer,List<String>> map = words5.stream ().collect ( Collectors.groupingBy ( String::length ) );
        System.out.println (map );


        List<Integer> numbers7 = Arrays.asList(10, 5, 20, 8, 15,2,3,2,3,4,5,4);
        numbers7.stream ().distinct ().collect ( Collectors.toList () );
        System.out.println (numbers7 );

        Person p1 = new Person(25,"Abi");
        Person p2 = new Person ( 27, "Suri" );
        Person p3 = new Person ( 26, "Sanvi" );
        List<Person> listP = new ArrayList <> (  );
        listP.add ( p1 );
        listP.add ( p2 );
        listP.add ( p3 );

        Collections.sort ( listP, Comparator.comparing ( Person::getAge ) );
        System.out.println (listP );

        List<Person> people = listP.stream ().sorted ( Comparator.comparing ( Person::getName ) ).toList ();
        Boolean b = listP.stream ().allMatch ( predicate );
        System.out.println (b );
    }
}
