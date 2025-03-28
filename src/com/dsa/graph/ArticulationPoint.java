package com.dsa.graph;

import java.util.*;

public class ArticulationPoint {
    // Method to find all articulation points in an undirected graph
    public static List<Integer> findArticulationPoints(Map<Integer, List<Integer>> graph) {
        Map<Integer,Integer> discovery = new HashMap <> (  );
        Map<Integer,Integer> low = new HashMap <> (  );
        Set<Integer> isVisited = new HashSet <> (  );
        List<Integer> articulationPoint = new ArrayList <> (  );
        int time = 0;

        for(Integer node: graph.keySet ()){
            if(!isVisited.contains(node)){
                dfs ( node,-1,time,discovery,low,isVisited,articulationPoint,graph );
            }
        }



        return articulationPoint; // Placeholder return value
    }

    public static void dfs(Integer node, Integer parent, Integer time,  Map<Integer,Integer> discovery ,  Map<Integer,Integer> low, Set<Integer> isVisited, List<Integer> articulationPoint,Map<Integer, List<Integer>> graph ) {
        isVisited.add ( node );
        discovery.put ( node, time );
        low.put ( node, time );
        time++;

        int children = 0;

        if (graph.containsKey ( node )) {
            for (Integer neighbour : graph.get ( node )) {
                if (parent.equals ( neighbour )) {
                    continue;
                }

                if (isVisited.contains ( neighbour )) {
                    low.put ( node, Math.min ( low.get ( node ), discovery.get ( neighbour ) ) );
                } else {
                    children++;
                    dfs ( neighbour, node, time, discovery, low, isVisited, articulationPoint, graph );
                    low.put ( node, Math.min ( low.get ( node ), discovery.get ( neighbour ) ) );

                    if (low.get ( neighbour ) > discovery.get ( node ) && parent != -1) {
                        //then articulation point
                        articulationPoint.add ( node );
                    }
                }
            }
        }

        if(parent == -1 && children > 1){ // <--- ISSUE 8: Root node condition.
            articulationPoint.add(node);
        }

    }


    // Method to print the graph representation
    private static void printGraph(Map<Integer, List<Integer>> graph) {
        System.out.println("Graph Representation:");
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Simple graph
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 2));
        graph1.put(1, Arrays.asList(0, 3, 4));
        graph1.put(2, Arrays.asList(0));
        graph1.put(3, Arrays.asList(1));
        graph1.put(4, Arrays.asList(1));
        List<Integer> expected1 = Arrays.asList(1);
        runTest(graph1, expected1, "Test Case 1");

        // Test Case 2: Graph with multiple articulation points
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1, 2));
        graph2.put(1, Arrays.asList(0));
        graph2.put(2, Arrays.asList(0, 3));
        graph2.put(3, Arrays.asList(2));
        List<Integer> expected2 = Arrays.asList(0, 2);
        runTest(graph2, expected2, "Test Case 2");

        // Test Case 3: No articulation points
        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        graph3.put(0, Arrays.asList(1, 2));
        graph3.put(1, Arrays.asList(0, 2));
        graph3.put(2, Arrays.asList(0, 1));
        List<Integer> expected3 = new ArrayList<>();
        runTest(graph3, expected3, "Test Case 3");
    }

    // Helper method to validate and run test cases
    private static void runTest(Map<Integer, List<Integer>> graph, List<Integer> expected, String testCaseName) {
        // Print the graph before finding articulation points
        printGraph(graph);

        List<Integer> result = findArticulationPoints(graph);

        if (result.equals(expected)) {
            System.out.println(testCaseName + " Passed");
        } else {
            System.out.println(testCaseName + " Failed");
            System.out.println("Expected: " + expected);
            System.out.println("Got: " + result);
        }
    }
}
