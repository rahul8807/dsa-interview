package com.dsa.graph;

import java.util.*;

public class BreadthFirstSearch {
    // Method to perform BFS traversal on a graph
    public static List<Integer> bfsTraversal(Map<Integer, List<Integer>> graph, int source) {

        List<Integer> bfs = new ArrayList <> (  );
        Queue<Integer> queue = new LinkedList <> (  );
        queue.offer ( source );
        Set<Integer> isVisited = new HashSet <> (  );
        isVisited.add ( source );

        while(!queue.isEmpty ()){
            int node = queue.poll ();
            bfs.add ( node );

            for(Integer neighbour : graph.get ( node )){
               if(!isVisited.contains ( neighbour )) {
                   queue.offer ( neighbour );
                   isVisited.add ( neighbour );
               }
            }
        }

        return bfs; // Placeholder return value
    }

    // ANSI color codes for console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Graph with four vertices
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 2));
        graph1.put(1, Arrays.asList(2));
        graph1.put(2, Arrays.asList(3));
        graph1.put(3, new ArrayList<>());
        int source1 = 0;
        List<Integer> expected1 = Arrays.asList(0, 1, 2, 3);
        runTest(graph1, source1, expected1, "Test Case 1");

        // Test Case 2: Graph with multiple branching
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1, 2, 3));
        graph2.put(1, Arrays.asList(4));
        graph2.put(2, new ArrayList<>());
        graph2.put(3, Arrays.asList(5));
        graph2.put(4, new ArrayList<>());
        graph2.put(5, new ArrayList<>());
        int source2 = 0;
        List<Integer> expected2 = Arrays.asList(0, 1, 2, 3, 4, 5);
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
        List<Integer> result = bfsTraversal(graph, source);

        if (result.equals(expected)) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.print(" (Expected: " + expected + ", Got: " + result + ")");
            System.out.println();
        }
    }
}
