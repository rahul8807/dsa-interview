package com.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Method to find the indices of two numbers that sum up to the target
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap <> (  ); //Key is the number and Value is the Index

        for(int i=0; i<nums.length; i++){
            map.put ( nums[i], i );
        }

        for(int i=0; i<nums.length; i++){
            int number = target - nums[i];
            if(map.containsKey ( number )){
                return new int[]{nums[i] ,number};
            }
        }
        return new int[]{-1, -1}; // Placeholder return value
    }

    // Test cases
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        assert result1[0] == 0 && result1[1] == 1 : "Test Case 1 Failed";
        System.out.println("Test Case 1 Passed");

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        assert result2[0] == 1 && result2[1] == 2 : "Test Case 2 Failed";
        System.out.println("Test Case 2 Passed");

        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        assert result3[0] == 0 && result3[1] == 1 : "Test Case 3 Failed";
        System.out.println("Test Case 3 Passed");

        // Test Case 4
        int[] nums4 = {-3, 4, 3, 90};
        int target4 = 0;
        int[] result4 = twoSum(nums4, target4);
        assert result4[0] == 0 && result4[1] == 2 : "Test Case 4 Failed";
        System.out.println("Test Case 4 Passed");
    }
}
