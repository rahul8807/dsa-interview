package com.dsa.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    // Method to find the kth largest element in an unsorted array
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue ( k );
        for(int i=0; i<nums.length; i++){
            if(minQueue.size () < k){
                minQueue.add ( nums[i] );
            }else if(minQueue.peek () < nums[i]){
                minQueue.poll ();
                minQueue.add ( nums[i] );
            }
        }

        //System.out.println (minQueue );
        return minQueue.peek (); // Placeholder return value
    }

    // ANSI color codes for colored console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: General case with distinct numbers
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int expected1 = 5;
        runTest(nums1, k1, expected1, "Test Case 1");

        // Test Case 2: Array with duplicates
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int expected2 = 4;
        runTest(nums2, k2, expected2, "Test Case 2");

        // Test Case 3: Single element array
        int[] nums3 = {1};
        int k3 = 1;
        int expected3 = 1;
        runTest(nums3, k3, expected3, "Test Case 3");

        // Test Case 4: All elements are the same
        int[] nums4 = {2, 2, 2, 2};
        int k4 = 1;
        int expected4 = 2;
        runTest(nums4, k4, expected4, "Test Case 4");

        // Test Case 5: Large array with negatives
        int[] nums5 = {-10, -7, -6, -5, -4, -3, -2};
        int k5 = 3;
        int expected5 = -4;
        runTest(nums5, k5, expected5, "Test Case 5");

        // Test Case 6: Large positive numbers
        int[] nums6 = {100, 99, 98, 97, 96};
        int k6 = 4;
        int expected6 = 97;
        runTest(nums6, k6, expected6, "Test Case 6");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(int[] nums, int k, int expected, String testCaseName) {
        int result = findKthLargest(nums, k);

        if (result == expected) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.println(" (Expected: " + expected + ", Got: " + result + ")");
        }
    }
}
