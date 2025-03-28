package com.dsa.arrays;

import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    // Method to merge overlapping intervals
    public static int[][] merge(int[][] intervals) {
        int i = 0;
        List<int[][]> result = new ArrayList<>();

        Arrays.sort ( intervals, Comparator.comparing ( e1 -> e1[0] ));

        while(i < intervals.length){
            int s1 = intervals[i][0];
            int e1 = intervals[i][1];
            int resultA[][] = new int[1][2];

            int j = i + 1;
            while (j < intervals.length){
                int s2 = intervals[j][0];
                int e2 = intervals[j][1];

                if(e1 >= s2){
                    e1 = Integer.max ( e1,e2 );
                    j++;
                }else{
                    break;
                }

            }

            resultA[0][0] = s1;
            resultA[0][1] = e1;
            result.add ( resultA );
            i= j;
        }

        int[][] rs = new int[result.size ()][2];
        for(int k = 0; k<result.size (); k++){
            rs[k][0] = (result.get ( k ))[0][0];
            rs[k][1] = (result.get ( k ))[0][1];
        }

       // Placeholder return value
        return rs;
    }

    // ANSI color codes for colored console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Overlapping intervals
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected1 = {{1, 6}, {8, 10}, {15, 18}};
        runTest(intervals1, expected1, "Test Case 1");

        // Test Case 2: Touching intervals
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] expected2 = {{1, 5}};
        runTest(intervals2, expected2, "Test Case 2");

        // Test Case 3: Non-overlapping intervals
        int[][] intervals3 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] expected3 = {{1, 2}, {3, 4}, {5, 6}};
        runTest(intervals3, expected3, "Test Case 3");

        // Test Case 4: Single interval
        int[][] intervals4 = {{1, 5}};
        int[][] expected4 = {{1, 5}};
        runTest(intervals4, expected4, "Test Case 4");

        // Test Case 5: Empty input
        int[][] intervals5 = {};
        int[][] expected5 = {};
        runTest(intervals5, expected5, "Test Case 5");

        // Test Case 6: Overlap with multiple merges
        int[][] intervals6 = {{1, 4}, {2, 3}, {5, 7}, {6, 8}};
        int[][] expected6 = {{1, 4}, {5, 8}};
        runTest(intervals6, expected6, "Test Case 6");

        // Test Case 7: Multiple intervals with a wide overlap
        int[][] intervals7 = {{1, 10}, {2, 3}, {4, 8}, {9, 12}};
        int[][] expected7 = {{1, 12}};
        runTest(intervals7, expected7, "Test Case 7");

        // Test Case 8: Unsorted intervals
        int[][] intervals8 = {{5, 6}, {1, 3}, {2, 4}};
        int[][] expected8 = {{1, 4}, {5, 6}};
        runTest(intervals8, expected8, "Test Case 8");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(int[][] intervals, int[][] expected, String testCaseName) {
        int[][] result = merge(intervals);
        boolean isSuccess = Arrays.deepEquals(result, expected);

        if (isSuccess) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.print(" (Expected: [");
            for (int i = 0; i < expected.length; i++) {
                System.out.print(Arrays.toString(expected[i]));
                if (i < expected.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("], Got: [");
            for (int i = 0; i < result.length; i++) {
                System.out.print(Arrays.toString(result[i]));
                if (i < result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("])");
        }
    }
}