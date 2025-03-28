package com.dsa.graph;

import java.util.*;

class NeigbourNode{
        public Integer fromNode;
        public Integer neighbour;
        public Integer distance;

        public Integer getDistance(){
            return distance;
        }
}

public class DijkstraAlgorithm {
    // Method to implement Dijkstra's algorithm
    public static Map<Integer, Integer> dijkstra(Map<Integer, List<int[]>> graph, int source) {

        PriorityQueue<NeigbourNode> priorityQueue = new PriorityQueue<> (Comparator.comparing ( NeigbourNode::getDistance ));
        Map<Integer,Integer> path = new HashMap <> (  );
        Set<Integer> isVisited = new HashSet <> (  );

        //traverse
        for (Integer node : graph.keySet ( )){
            for(int[] edge : graph.get ( node )){
                NeigbourNode neigbourNode = new NeigbourNode ();
                neigbourNode.fromNode = node;
                neigbourNode.neighbour = edge[0];
                neigbourNode.distance = edge[1];

                priorityQueue.add ( neigbourNode );
            }
        }

        while (!priorityQueue.isEmpty ()){
            NeigbourNode neigbourNode = priorityQueue.poll ();
            if(isVisited.contains ( neigbourNode.fromNode )){

            }
        }


        return path; // Placeholder return value
    }

    // ANSI color codes for console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Simple graph
        Map<Integer, List<int[]>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(new int[]{1, 4}, new int[]{2, 1}));
        graph1.put(1, Arrays.asList(new int[]{3, 1}));
        graph1.put(2, Arrays.asList(new int[]{1, 2}, new int[]{3, 5}));
        graph1.put(3, new ArrayList<>());

        Map<Integer, Integer> expected1 = new HashMap<>();
        expected1.put(0, 0);
        expected1.put(1, 3);
        expected1.put(2, 1);
        expected1.put(3, 4);
        runTest(graph1, 0, expected1, "Test Case 1");

        // Test Case 2: Graph with higher weights
        Map<Integer, List<int[]>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(new int[]{1, 10}, new int[]{2, 3}));
        graph2.put(1, Arrays.asList(new int[]{3, 2}));
        graph2.put(2, Arrays.asList(new int[]{1, 1}));
        graph2.put(3, new ArrayList<>());

        Map<Integer, Integer> expected2 = new HashMap<>();
        expected2.put(0, 0);
        expected2.put(1, 4);
        expected2.put(2, 3);
        expected2.put(3, 6);
        runTest(graph2, 0, expected2, "Test Case 2");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(Map<Integer, List<int[]>> graph, int source, Map<Integer, Integer> expected, String testCaseName) {
        Map<Integer, Integer> result = dijkstra(graph, source);

        if (result.equals(expected)) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.print(" (Expected: " + expected + ", Got: " + result + ")");
            System.out.println();
        }
    }
}
