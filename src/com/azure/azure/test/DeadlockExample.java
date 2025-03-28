package com.azure.azure.test;

public class DeadlockExample {
    public static void main ( String[] args ) {
        Object obj1 = new Object ( );
        Object obj2 = new Object ( );

        Thread t1 = new Thread ( () -> {
            synchronized (obj1) {
                System.out.println ("Thread 1 - Acquired lock on Object(1) " );
                try {
                    Thread.sleep ( 3000 );
                    System.out.println ("Thread 1 - Ready to Process " );
                } catch (InterruptedException e) {
                    throw new RuntimeException ( e );
                }
                synchronized (obj2){
                    System.out.println ( "Thread 1 - Acquired lock on Object(2) " );
                }
            }
        } );

        Thread t2 = new Thread ( () -> {
            synchronized (obj2) {
                System.out.println ("Thread 2 - Acquired lock on Object(2) " );
                try {
                    Thread.sleep ( 3000 );
                    System.out.println ("Thread 2 - Ready to Process " );
                } catch (InterruptedException e) {
                    throw new RuntimeException ( e );
                }
                synchronized (obj1){
                    System.out.println ( "Thread 2 - Acquired lock on Object(2) " );
                }
            }
        } );


        t1.start ();
        t2.start ();
    }
}
