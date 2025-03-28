package com.dsa.arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.HashSet;

public class ArrayCommonItem {
    // Method to check if two arrays contain any common item
    public static boolean containsCommonItem(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet <> (  );
        for(int i = 0 ; i< array1.length; i++){
            set.add ( array1[i] );
        }

        for(int i=0; i < array2.length; i++){
            if(set.contains ( array2 )){
                return false;
            }
        }

        return true; // Placeholder return value
    }

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Both arrays have a common item
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 3};
        boolean result1 = containsCommonItem(array1, array2);
        assert result1 == true : "Test Case 1 Failed";
        System.out.println("Test Case 1 Passed");

        // Test Case 2: No common item
        array1 = new int[]{10, 20, 30};
        array2 = new int[]{40, 50, 60};
        boolean result2 = containsCommonItem(array1, array2);
        assert result2 == false : "Test Case 2 Failed";
        System.out.println("Test Case 2 Passed");

        // Test Case 3: One array is empty
        array1 = new int[]{};
        array2 = new int[]{1, 2, 3};
        boolean result3 = containsCommonItem(array1, array2);
        assert result3 == false : "Test Case 3 Failed";
        System.out.println("Test Case 3 Passed");

        // Test Case 4: Both arrays are empty
        array1 = new int[]{};
        array2 = new int[]{};
        boolean result4 = containsCommonItem(array1, array2);
        assert result4 == false : "Test Case 4 Failed";
        System.out.println("Test Case 4 Passed");

        // Test Case 5: Both arrays are identical
        array1 = new int[]{1, 2, 3};
        array2 = new int[]{1, 2, 3};
        boolean result5 = containsCommonItem(array1, array2);
        assert result5 == true : "Test Case 5 Failed";
        System.out.println("Test Case 5 Passed");
    }
}
