package com.dsa.dynamicprogramming;

public class Knapsack {

    public static int knapsack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    int include = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
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
