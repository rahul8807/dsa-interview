package com.dsa.arrays;

public class MaximumSubarray {
    // Method to find the maximum subarray sum
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            max = Math.max ( sum, max );

            if(sum < 0){
                sum = 0;
            }
        }

        return max; // Placeholder return value
    }

    // ANSI color codes
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Mixed positive and negative integers
        int[] array1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected1 = 6;
        runTest(array1, expected1, "Test Case 1");

        // Test Case 2: Single element
        int[] array2 = {1};
        int expected2 = 1;
        runTest(array2, expected2, "Test Case 2");

        // Test Case 3: Entire array is the subarray with maximum sum
        int[] array3 = {5, 4, -1, 7, 8};
        int expected3 = 23;
        runTest(array3, expected3, "Test Case 3");

        // Test Case 4: All negative numbers
        int[] array4 = {-1, -2, -3, -4};
        int expected4 = -1;
        runTest(array4, expected4, "Test Case 4");

        // Test Case 5: Large input array
        int[] array5 = {-1, 3, -2, 5, -3, 2, 2};
        int expected5 = 7;
        runTest(array5, expected5, "Test Case 5");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(int[] array, int expected, String testCaseName) {
        int result = maxSubArray(array);
        if (result == expected) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + testCaseName + " Failed (Expected: " + expected + ", Got: " + result + ")" + ANSI_RESET);
        }
    }
}