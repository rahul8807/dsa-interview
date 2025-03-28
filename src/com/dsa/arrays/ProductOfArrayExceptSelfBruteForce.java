package com.dsa.arrays;

public class ProductOfArrayExceptSelfBruteForce {
    // Method to calculate the product of array except for self
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for(int i=0; i< nums.length; i++){
            int product = 1;
            for(int j=0; j< nums.length; j++){
                if(i != j){
                    product = product * nums[j];
                }
            }
            result[i] = product;
        }

        return result; // Placeholder return value
    }

    // ANSI color codes for colored console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Positive integers
        int[] nums1 = {1, 2, 3, 4};
        int[] expected1 = {24, 12, 8, 6};
        runTest(nums1, expected1, "Test Case 1");

        // Test Case 2: Array with zero
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] expected2 = {0, 0, 9, 0, 0};
        runTest(nums2, expected2, "Test Case 2");

        // Test Case 3: Array with one element repeating
        int[] nums3 = {2, 2, 2, 2};
        int[] expected3 = {8, 8, 8, 8};
        runTest(nums3, expected3, "Test Case 3");

        // Test Case 4: Array with negative numbers
        int[] nums4 = {-1, -2, -3, -4};
        int[] expected4 = {-24, -12, -8, -6};
        runTest(nums4, expected4, "Test Case 4");

        // Test Case 5: Two elements only
        int[] nums5 = {5, 10};
        int[] expected5 = {10, 5};
        runTest(nums5, expected5, "Test Case 5");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(int[] nums, int[] expected, String testCaseName) {
        int[] result = productExceptSelf(nums);
        boolean isSuccess = true;

        // Compare the result with the expected output
        for (int i = 0; i < expected.length; i++) {
            if (result[i] != expected[i]) {
                isSuccess = false;
                break;
            }
        }

        // Print test results with color codes
        if (isSuccess) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.print(" (Expected: [");
            for (int i = 0; i < expected.length; i++) {
                System.out.print(expected[i]);
                if (i < expected.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("], Got: [");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("])");
        }
    }
}

