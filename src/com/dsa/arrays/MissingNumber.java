package com.dsa.arrays;

public class MissingNumber {
    // Method to find the missing number
    public static int missingNumber(int[] nums) {
        //formula
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = sum + nums[i];
        }

        int total = n * (n+1) / 2;

        return total - sum;
    }

    // ANSI color codes for colored console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Simple case
        int[] nums1 = {3, 0, 1};
        int expected1 = 2;
        runTest(nums1, expected1, "Test Case 1");

        // Test Case 2: Small array
        int[] nums2 = {0, 1};
        int expected2 = 2;
        runTest(nums2, expected2, "Test Case 2");

        // Test Case 3: Larger array
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int expected3 = 8;
        runTest(nums3, expected3, "Test Case 3");

        // Test Case 4: Single element array
        int[] nums4 = {0};
        int expected4 = 1;
        runTest(nums4, expected4, "Test Case 4");

        // Test Case 5: Empty range
        int[] nums5 = {1, 0};
        int expected5 = 2;
        runTest(nums5, expected5, "Test Case 5");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(int[] nums, int expected, String testCaseName) {
        int result = missingNumber(nums);

        if (result == expected) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.println(" (Expected: " + expected + ", Got: " + result + ")");
        }
    }
}