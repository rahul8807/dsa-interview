package com.dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PairWithGivenSum {
    // Method to check for a pair with a given sum in the array
    public static boolean hasPairWithSum(int[] array, int target) {

        Set<Integer> set = Arrays.stream ( array).boxed ().collect ( Collectors.toSet () );
        for(int i=0; i<array.length; i++){
            if(set.contains ( target - array[i] )){
                return true;
            }
        }
        return false; // Placeholder return value
    }

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Pair exists
        int[] array1 = {1, 4, 7, 12, 15};
        int target1 = 11;
        boolean result1 = hasPairWithSum(array1, target1);
        assert result1 == true : "Test Case 1 Failed";
        System.out.println("Test Case 1 Passed");

        // Test Case 2: No pair exists
        int[] array2 = {2, 3, 5, 6};
        int target2 = 10;
        boolean result2 = hasPairWithSum(array2, target2);
        assert result2 == false : "Test Case 2 Failed";
        System.out.println("Test Case 2 Passed");

        // Test Case 3: Empty array
        int[] array3 = {};
        int target3 = 5;
        boolean result3 = hasPairWithSum(array3, target3);
        assert result3 == false : "Test Case 3 Failed";
        System.out.println("Test Case 3 Passed");

        // Test Case 4: Pair with duplicate numbers
        int[] array4 = {5, 5, 5};
        int target4 = 10;
        boolean result4 = hasPairWithSum(array4, target4);
        assert result4 == true : "Test Case 4 Failed";
        System.out.println("Test Case 4 Passed");
    }
}
