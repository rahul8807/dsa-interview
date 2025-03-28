package com.dsa.recurssion;

public class Knapsack {

    public static int knapsack(int capacity, int[] weights, int[] values) {

        return knapsack(capacity,weights,values,0); // Placeholder return value
    }

    public static int knapsack(int capacity, int[] weights, int[] values, int index) {
        if(capacity <= 0 || index >= values.length){
            return 0;
        }

        if(weights[index] > capacity){
             return knapsack ( capacity  , weights, values, index + 1 );
        }

        int include = values[index] + knapsack ( capacity - weights[index] , weights, values, index + 1 );
        int exclude = knapsack ( capacity  , weights, values, index + 1 );

        return Math.max ( include, exclude ); // Placeholder return value
    }

    public static void main(String[] args) {
        // Test cases
        testCase1();
        testCase2();
        testCase3();
    }

    public static void testCase1() {
        int capacity = 50;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int expected = 220;
        int result = knapsack(capacity, weights, values);
        System.out.println("Test Case 1: Expected = " + expected + ", Result = " + result);
        assert result == expected;
    }

    public static void testCase2() {
        int capacity = 10;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 7, 2, 9};
        int expected = 19;
        int result = knapsack(capacity, weights, values);
        System.out.println("Test Case 2: Expected = " + expected + ", Result = " + result);
        assert result == expected;
    }

    public static void testCase3() {
        int capacity = 0;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 7, 2, 9};
        int expected = 0;
        int result = knapsack(capacity, weights, values);
        System.out.println("Test Case 3: Expected = " + expected + ", Result = " + result);
        assert result == expected;
    }
}
