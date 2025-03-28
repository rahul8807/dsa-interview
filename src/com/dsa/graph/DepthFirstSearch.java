package com.dsa.graph;

import java.util.*;

public class DepthFirstSearch {
    // Method to perform DFS traversal on a graph
    public static List<Integer> dfsTraversal(Map<Integer, List<Integer>> graph, int source) {

        Set<Integer> isVisted = new HashSet <> (  );
        List<Integer> dfs = new ArrayList <> (  );
        Stack<Integer> stack = new Stack <> ();
        stack.push ( source );
        isVisted.add ( source );

        while (!stack.isEmpty ()){
            int node = stack.pop ();
            dfs.add ( node );

            for(Integer neighbour : graph.get ( node ).reversed ()){
                if(!isVisted.contains ( neighbour )) {
                    stack.push ( neighbour );
                    isVisted.add ( neighbour );
                }
            }

        }

        return dfs; // Placeholder return value
    }

    // ANSI color codes for console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Graph with multiple branches
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 2));
        graph1.put(1, Arrays.asList(3));
        graph1.put(2, Arrays.asList(4, 5));
        graph1.put(3, new ArrayList<>());
        graph1.put(4, new ArrayList<>());
        graph1.put(5, new ArrayList<>());
        int source1 = 0;
        List<Integer> expected1 = Arrays.asList(0, 1, 3, 2, 4, 5);
        runTest(graph1, source1, expected1, "Test Case 1");

        // Test Case 2: Graph with cycles
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1, 2));
        graph2.put(1, Arrays.asList(2));
        graph2.put(2, Arrays.asList(0, 3));
        graph2.put(3, Arrays.asList(3));
        int source2 = 0;
        List<Integer> expected2 = Arrays.asList(0, 1, 2, 3);
        runTest(graph2, source2, expected2, "Test Case 2");

        // Test Case 3: Single vertex
        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        graph3.put(0, new ArrayList<>());
        int source3 = 0;
        List<Integer> expected3 = Arrays.asList(0);
        runTest(graph3, source3, expected3, "Test Case 3");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(Map<Integer, List<Integer>> graph, int source, List<Integer> expected, String testCaseName) {
        List<Integer> result = dfsTraversal(graph, source);

        if (result.equals(expected)) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.print(" (Expected: " + expected + ", Got: " + result + ")");
            System.out.println();
        }
    }
}
