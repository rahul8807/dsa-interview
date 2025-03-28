package com.dsa.arrays;

public class BinarySearch {

    // Function to perform binary search
    public static int binarySearch(int[] arr, int target) {
       int low = 0;
       int high = arr.length - 1;

        while(low <= high){
            int mid = (low+high) / 2;

            if(arr[mid] == target){
                return mid;
            } else if(target > arr[mid] ){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return -1; // Placeholder return value
    }



    public static void main(String[] args) {
        // Run the unit test cases
        runUnitTests();
    }

    // Unit Test Cases
    public static void runUnitTests() {
        int[] testCase1 = {1, 3, 5, 7, 9, 11};
        int target1 = 7;
        test("Test Case 1", testCase1, target1, 3);

        int[] testCase2 = {1, 3, 5, 7, 9, 11};
        int target2 = 4;
        test("Test Case 2", testCase2, target2, -1);

        int[] testCase3 = {1, 3, 5, 7, 9, 11};
        int target3 = 1;
        test("Test Case 3", testCase3, target3, 0);

        int[] testCase4 = {1};
        int target4 = 1;
        test("Test Case 4", testCase4, target4, 0);

        int[] testCase5 = {1};
        int target5 = 0;
        test("Test Case 5", testCase5, target5, -1);

        int[] testCase6 = {}; // Empty array
        int target6 = 1;
        test("Test Case 6", testCase6, target6, -1);

        int[] testCase7 = {3, 6, 9, 12}; // Even length array
        int target7 = 9;
        test("Test Case 7", testCase7, target7, 2);

        int[] testCase8 = {3, 6, 9, 12}; // Target not present
        int target8 = 5;
        test("Test Case 8", testCase8, target8, -1);

        int[] testCase9 = {5}; // Single-element array, target is not present
        int target9 = 3;
        test("Test Case 9", testCase9, target9, -1);

        int[] testCase10 = {10, 20, 30, 40, 50}; // Target is the last element
        int target10 = 50;
        test("Test Case 10", testCase10, target10, 4);
    }

    // Helper method to test the function
    public static void test(String testName, int[] nums, int target, int expected) {
        int result = binarySearch(nums, target);

        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.println(testName + " failed. Expected " + expected + " but got " + result + ".");
        }
    }
}
