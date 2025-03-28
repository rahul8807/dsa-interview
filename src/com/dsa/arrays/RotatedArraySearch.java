package com.dsa.arrays;

public class RotatedArraySearch {

    // Function to search for the target in a rotated array
    public static int search ( int[] nums, int target ) {
        if(nums.length < 3){
            for(int i=0; i<nums.length; i++){
                if(nums[i] == target){
                    return i;
                }
            }
        }

        return binarySearch ( nums, 0, nums.length - 1, target );
    }

    public static int binarySearch ( int nums[], int low, int high, int target ) {
        if (low < 0 || high > nums.length-1) {
            return -1;
        }

        if (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }else if(mid-1 <0 || mid+1 > nums.length-1){
                return -1;
            }else if (nums[low] < nums[high]) {
                // sorted in asc order
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if ((nums[mid] < nums[mid - 1] && nums[mid] < nums[mid - 1])
                    || (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])) {

                //rotated
                //start index;
                if (target > nums[mid]) {
                    high = high - 1;
                } else {
                    low = mid + 1;
                }


            } else if (nums[mid] > nums[low] && nums[mid] > nums[high]) {
                //desc
                if (nums[mid] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return binarySearch ( nums, low, high, target );
        }
        return -1;
    }


    public static void main ( String[] args ) {
        // Run the unit test cases
        runUnitTests ( );
    }

    // Unit Test Cases
    public static void runUnitTests () {

        //1 2 3 4 5 6 7 8

        //8 7 6 5 4 3 2 1 -> no 2 or no is 7

        int[] testCase1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        test ( "Test Case 1", testCase1, target1, 4 );

        int[] testCase2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        test ( "Test Case 2", testCase2, target2, -1 );

        int[] testCase3 = {1};
        int target3 = 1;
        test ( "Test Case 3", testCase3, target3, 0 );

        int[] testCase4 = {1};
        int target4 = 0;
        test ( "Test Case 4", testCase4, target4, -1 );

        int[] testCase5 = {3, 1};
        int target5 = 1;
        test ( "Test Case 5", testCase5, target5, 1 );
    }

    // Helper method to test the function with colored output
    public static void test ( String testName, int[] nums, int target, int expected ) {
        int result = search ( nums, target );

        // ANSI escape codes for colors
        String greenColor = "\u001B[32m";
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        if (result == expected) {
            System.out.println ( greenColor + testName + " passed." + resetColor );
        } else {
            System.out.println ( redColor + testName + " failed. Expected " + expected + " but got " + result + "." + resetColor );
        }
    }
}