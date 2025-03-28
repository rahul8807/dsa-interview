package com.dsa.arrays;


public class MountainArrayPeak {

    // Function to find the peak of the mountain array
    public static int findPeak ( int[] arr ) {
        if(arr.length == 1){
            return arr[0];
        }
        return binarySearch ( arr, 0, arr.length-1 );
    }

    public static int binarySearch( int[] arr, int low, int high){
        if(low <= high && low >= 0 && high <= arr.length-1 ){
            int mid = (low + high) / 2;
            if(mid - 1 < 0 || mid + 1 >= arr.length){
                return -1;
            }else if (arr[mid] > arr[mid-1] && arr[mid] >= arr[mid+1]){
                return arr[mid];
            }else{
                if(arr[mid] < arr[mid+1]){
                    return binarySearch ( arr, mid+1 , high );
                }else{
                   return binarySearch ( arr, low , mid-1 );
                }
            }

        }

        return  -1;
    }

    public static void main ( String[] args ) {
        // Run the test cases
        runUnitTests ( );
    }

    public static void runUnitTests() {
        // Regular cases
        int[] testCase1 = {1, 2, 3, 4, 5, 4, 3};
        int expected1 = 5;
        test("Test Case 1", testCase1, expected1);

        int[] testCase2 = {0, 10, 5, 2};
        int expected2 = 10;
        test("Test Case 2", testCase2, expected2);

        int[] testCase3 = {10, 20, 15};
        int expected3 = 20;
        test("Test Case 3", testCase3, expected3);

        int[] testCase4 = {3, 8, 10, 6, 4};
        int expected4 = 10;
        test("Test Case 4", testCase4, expected4);

        int[] testCase5 = {1}; // Single element
        int expected5 = 1;
        test("Test Case 5", testCase5, expected5);

        /*// Edge cases
        int[] testCase6 = {4, 2}; // Two elements, peak at the start
        int expected6 = 4;
        test("Test Case 6", testCase6, expected6);

        int[] testCase7 = {2, 4}; // Two elements, peak at the end
        int expected7 = 4;
        test("Test Case 7", testCase7, expected7);*/

        int[] testCase8 = {2, 2, 2, 1}; // Flat section
        int expected8 = -1;
        test("Test Case 8", testCase8, expected8);

        int[] testCase9 = {1, 2, 3, 4, 5}; // Strictly increasing
        int expected9 = -1; // No peak; logic should handle gracefully
        test("Test Case 9", testCase9, expected9);

        int[] testCase10 = {5, 4, 3, 2, 1}; // Strictly decreasing
        int expected10 = -1; // No peak; logic should handle gracefully
        test("Test Case 10", testCase10, expected10);

        int[] testCase11 = {7, 5, 3, 1}; // Peak at the start
        int expected11 = -1;
        test("Test Case 11", testCase11, expected11);

        int[] testCase12 = {1, 2, 4, 6}; // Peak at the end
        int expected12 = -1;
        test("Test Case 12", testCase12, expected12);

        int[] testCase13 = {1, 2, 3, 4, 5, 6, 5, 3, 1}; // Long array
        int expected13 = 6;
        test("Test Case 13", testCase13, expected13);

        int[] testCase14 = {1, 2, 3, 3, 2, 1}; // Duplicate values
        int expected14 = 3;
        test("Test Case 14", testCase14, expected14);
    }




    // Helper method to test the function
    public static void test ( String testName, int[] testCase, int expected ) {
        int result = findPeak ( testCase );
        if (result == expected) {
            System.out.println ( testName + " passed." );
        } else {
            System.out.println ( testName + " failed. Expected " + expected + " but got " + result + "." );
        }
    }
}
