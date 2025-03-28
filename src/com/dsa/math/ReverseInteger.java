package com.dsa.math;

public class ReverseInteger {
    // Method to reverse an integer
    public static long reverse(long x) {

        if(x == 0){
            return 0;
        }

        long xMultiplier = 1;

        if(x < 0){
            xMultiplier = -1;
            x = x * xMultiplier;
        }

        long newNumber = 0;
        int divide = 10;
        while(x > 0){
            long temp = x % divide;
            if(newNumber == 0){
                newNumber = temp + newNumber;
            }else{
                newNumber = temp + (newNumber * 10);
            }
            x = x / 10;
        }

        return xMultiplier * newNumber; // Placeholder return value
    }

    // ANSI color codes for console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        runTest(123, 321, "Test Case 1");
        runTest(-123, -321, "Test Case 2");
        runTest(120, 21, "Test Case 3");
        runTest(0, 0, "Test Case 4");
        runTest(Integer.MAX_VALUE, 0, "Test Case 5"); // Edge case: overflow when reversed
        runTest(Integer.MIN_VALUE, 0, "Test Case 6"); // Edge case: overflow when reversed
    }

    // Helper method to validate and run test cases
    private static void runTest(int x, int expected, String testCaseName) {
        long result = reverse(x);

        if (result == expected) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.println(" (Expected: " + expected + ", Got: " + result + ")");
        }
    }
}
