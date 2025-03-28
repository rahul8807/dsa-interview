package com.dsa.recurssion;


public class CoinChange {
    // Method to calculate the minimum number of coins needed
    static int MAX_AMOUNT = 0;

    public static int coinChange(int[] coins, int amount) {
        MAX_AMOUNT = amount + 1;

        int noOfCoins = coinChange ( coins,amount, 0 );
        if(noOfCoins >= MAX_AMOUNT) {
            return -1; // Placeholder return value
        }else{
            return noOfCoins;
        }
    }

    public static int coinChange(int[] coins, int amount, int index) {

        if(amount == 0){
            return 0;
        }

        if(index >= coins.length){
            return MAX_AMOUNT;
        }

        if(coins[index] > amount){
            return coinChange ( coins, amount, index + 1);
        }

        int include = 1 + coinChange ( coins, amount - coins[index], index );
        int exclude = coinChange ( coins, amount, index + 1 );

        return Math.min ( include,exclude ); // Placeholder return value
    }

    // ANSI color codes for colored console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: General case with multiple coins
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int expected1 = 3;
        runTest(coins1, amount1, expected1, "Test Case 1");

        // Test Case 2: Unreachable amount
        int[] coins2 = {2};
        int amount2 = 3;
        int expected2 = -1;
        runTest(coins2, amount2, expected2, "Test Case 2");

        // Test Case 3: Zero amount
        int[] coins3 = {1};
        int amount3 = 0;
        int expected3 = 0;
        runTest(coins3, amount3, expected3, "Test Case 3");

        // Test Case 4: Single coin denomination
        int[] coins4 = {5};
        int amount4 = 10;
        int expected4 = 2;
        runTest(coins4, amount4, expected4, "Test Case 4");

        // Test Case 5: Large amount with multiple denominations
        int[] coins5 = {1, 7, 10};
        int amount5 = 14;
        int expected5 = 2;
        runTest(coins5, amount5, expected5, "Test Case 5");

        // Additional Test Case 6: General case with multiple coins
        int[] coins6 = {1, 2, 5};
        int amount6 = 7;
        int expected6 = 2; // Example: 5 + 2
        runTest(coins6, amount6, expected6, "Test Case 6");

        // Additional Test Case 7: Exact fit with large coins
        int[] coins7 = {3, 7, 10};
        int amount7 = 14;
        int expected7 = 2; // Example: 7 + 7
        runTest(coins7, amount7, expected7, "Test Case 7");

        // Additional Test Case 8: Single coin denomination
        int[] coins8 = {4};
        int amount8 = 12;
        int expected8 = 3; // Example: 4 + 4 + 4
        runTest(coins8, amount8, expected8, "Test Case 8");

        // Additional Test Case 9: Amount is unreachable
        int[] coins9 = {2, 4};
        int amount9 = 7;
        int expected9 = -1; // Unreachable
        runTest(coins9, amount9, expected9, "Test Case 9");

        // Additional Test Case 10: Large amount with many coins
        int[] coins10 = {1, 2, 5};
        int amount10 = 100;
        int expected10 = 20; // Example: 20 coins of 5
        runTest(coins10, amount10, expected10, "Test Case 10");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(int[] coins, int amount, int expected, String testCaseName) {
        int result = coinChange(coins, amount);

        if (result == expected) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.println(" (Expected: " + expected + ", Got: " + result + ")");
        }
    }
}