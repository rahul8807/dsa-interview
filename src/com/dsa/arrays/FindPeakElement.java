package com.dsa.arrays;

public class FindPeakElement {

    public static int findPeak(int[] nums) {
        if(nums.length < 3){
            if(nums.length == 1){
                return nums[0];
            }

            if(nums[0] > nums[1]){
                return nums[0];
            }else{
                return nums[1];
            }
        }

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[low] < nums[high]){ //sorted
                return nums[high];
            }else if(low == high){//reached to end
                return nums[high];
            }else if (mid == 0) {
                if (nums[0] > nums[1]) {
                    return nums[0];
                }else{
                    return nums[1];
                }
            }else if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]   ){//middle
                return nums[mid];
            }else{
                if(nums[mid] > nums[mid+1]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }

        return -1; // Placeholder
    }

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        test("Test Case 1", new int[]{4, 5, 6, 7, 0, 1, 2}, 7);
        test("Test Case 2", new int[]{3, 4, 5, 1, 2}, 5);
        test("Test Case 3", new int[]{1, 2, 3, 4, 5}, 5); // Strictly increasing
        test("Test Case 4", new int[]{5, 4, 3, 2, 1}, 5); // Strictly decreasing
        test("Test Case 5", new int[]{1}, 1);
        test("Test Case 6", new int[]{1, 2}, 2);
        test("Test Case 7", new int[]{2, 1}, 2);
        test("Test Case 8", new int[]{1, 2, 3, 2, 1}, 3);
        test("Test Case 9", new int[]{1,2,3,4,3,2,1}, 4);
        test("Test Case 10", new int[]{1,2,3,4,5,4,3,2,1}, 5);
        test("Test Case 11", new int[]{1,2,3,4,5,6,7,6,5,4,3,2,1}, 7);
        test("Test Case 12", new int[] {3,3,3,3,3}, 3);
        test("Test Case 13", new int[] {1,2,3,4,5,6,7,7,7}, 7);
        test("Test Case 14", new int[] {7,7,7,7,7,6,5,4,3,2,1}, 7);
    }

    public static void test(String testName, int[] nums, int expected) {
        int result = findPeak(nums);
        String green = "\u001B[32m";
        String red = "\u001B[31m";
        String reset = "\u001B[0m";

        if (result == expected) {
            System.out.println(green + testName + " passed." + reset);
        } else {
            System.out.println(red + testName + " failed. Expected " + expected + ", but got " + result + "." + reset);
        }
    }
}