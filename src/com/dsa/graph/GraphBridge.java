package com.dsa.graph;

import java.util.*;

public class GraphBridge {

    static Map < Integer, Integer > discovery = new HashMap <> ( );
    static Map < Integer, Integer > low = new HashMap <> ( );
    static Set < Integer > visited = new HashSet <> ( );
    static List < List < Integer > > bridges = new ArrayList <> ( );
    static int time = 0;

    // Method to find all bridges in an undirected graph
    public static List < List < Integer > > findBridges ( Map < Integer, List < Integer > > graph ) {

        discovery.clear ( ); // Corrected: Clear global variables
        low.clear ( );       // Corrected: Clear global variables
        visited.clear ( );   // Corrected: Clear global variables
        bridges.clear ( );   // Corrected: Clear global variables
        time = 0;          // Corrected: Reset time


        for (Integer node : graph.keySet ( )) {
            if (!visited.contains ( node )) {
                dfs ( node, -1, graph );
            }
        }

        return bridges; // Placeholder return value
    }

    private static void dfs ( int node, int parent, Map < Integer, List < Integer > > graph ) {
        visited.add ( node );
        discovery.put ( node, time );
        low.put ( node, time );
        time++;


        for (Integer neighbour : graph.get ( node )) {
            if (neighbour == parent) { // <--- ISSUE 1: Should be neighbour == parent, not parent == -1
                continue;
            }

            if (visited.contains ( neighbour )) {
                low.put ( node, Math.min ( discovery.get ( neighbour ), low.get ( node ) ) );
            } else {
                dfs ( neighbour, node, graph );
                low.put ( node, Math.min ( low.get ( neighbour ), low.get ( node ) ) );

                if (low.get ( neighbour ) > discovery.get ( node )) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(node);
                    bridge.add(neighbour);
                    bridges.add(bridge);
                }
            }
        }
    }


    // Test cases
    public static void main ( String[] args ) {
        // Test Case 1: Simple graph
        Map < Integer, List < Integer > > graph1 = new HashMap <> ( );
        graph1.put ( 0, Arrays.asList ( 1, 2 ) );
        graph1.put ( 1, Arrays.asList ( 0, 2 ) );
        graph1.put ( 2, Arrays.asList ( 0, 1, 3 ) );
        graph1.put ( 3, Arrays.asList ( 2 ) );
        List < List < Integer > > expected1 = Arrays.asList ( Arrays.asList ( 2, 3 ) );
        runTest ( graph1, expected1, "Test Case 1" );

        // Test Case 2: Graph with multiple bridges
        Map < Integer, List < Integer > > graph2 = new HashMap <> ( );
        graph2.put ( 0, Arrays.asList ( 1 ) );
        graph2.put ( 1, Arrays.asList ( 0, 2, 3 ) );
        graph2.put ( 2, Arrays.asList ( 1, 3 ) );
        graph2.put ( 3, Arrays.asList ( 1, 2 ) );
        List < List < Integer > > expected2 = Arrays.asList ( Arrays.asList ( 0, 1 ) );
        runTest ( graph2, expected2, "Test Case 2" );

        // Test Case 3: No bridges
        Map < Integer, List < Integer > > graph3 = new HashMap <> ( );
        graph3.put ( 0, Arrays.asList ( 1, 2 ) );
        graph3.put ( 1, Arrays.asList ( 0, 2 ) );
        graph3.put ( 2, Arrays.asList ( 0, 1 ) );
        List < List < Integer > > expected3 = new ArrayList <> ( );
        runTest ( graph3, expected3, "Test Case 3" );
    }

    // Helper method to validate and run test cases
    private static void runTest ( Map < Integer, List < Integer > > graph, List < List < Integer > > expected, String testCaseName ) {
        List < List < Integer > > result = findBridges ( graph );

        if (result.equals ( expected )) {
            System.out.println ( testCaseName + " Passed" );
        } else {
            System.out.println ( testCaseName + " Failed" );
            System.out.println ( "Expected: " + expected );
            System.out.println ( "Got: " + result );
        }
    }
}