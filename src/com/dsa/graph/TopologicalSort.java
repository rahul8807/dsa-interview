package com.dsa.graph;

import java.util.*;

public class TopologicalSort {
    // Method to perform topological sort using BFS (Kahn's Algorithm)
    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {

        Map<Integer, Integer> inDegree = new HashMap <> (  );
        Queue<Integer> queue = new LinkedList <> (  );
        Set<Integer> isVisisted = new HashSet <> (  );
        List<Integer> topologicalSort = new ArrayList <> (  );

        for(Integer node : graph.keySet ()){
            inDegree.put ( node , 0 );
        }

        for(Integer node : graph.keySet ()){
            for(Integer neighbour : graph.get ( node )){
                int inDegreeCount = inDegree.get ( neighbour );
                inDegreeCount++;
                inDegree.put ( neighbour, inDegreeCount );
            }
        }

        for(Integer node : inDegree.keySet ()){
            if(inDegree.get ( node ) == 0){
                queue.add ( node );
                isVisisted.add ( node );
            }
        }

        while(!queue.isEmpty ()){
            int node = queue.poll ();
            topologicalSort.add ( node );

            // visit neighbours, Minus indegree
            for(Integer neighbour : graph.get ( node )){
                int inDegreeCount = inDegree.get ( neighbour );
                inDegreeCount--;
                inDegree.put ( neighbour, inDegreeCount );

                if(inDegreeCount == 0){
                    queue.add ( neighbour );
                    isVisisted.add ( neighbour );
                }
            }
        }

        if(graph.size () == topologicalSort.size () ){
            return topologicalSort;
        }else{
            return new ArrayList<>(); // Placeholder return value
        }

    }

    // ANSI color codes for console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Simple DAG
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1));
        graph1.put(1, Arrays.asList(2, 3));
        graph1.put(2, new ArrayList<>());
        graph1.put(3, new ArrayList<>());
        List<Integer> expected1 = Arrays.asList(0, 1, 2, 3);
        runTest(graph1, Arrays.asList(expected1), "Test Case 1");

        // Test Case 2: Larger DAG with multiple valid outputs
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(5, new ArrayList<>());
        graph2.put(4, Arrays.asList(0, 1));
        graph2.put(3, Arrays.asList(1));
        graph2.put(2, Arrays.asList(3, 4));
        graph2.put(1, new ArrayList<>());
        graph2.put(0, new ArrayList<>());

        List<Integer> validOutput1 = Arrays.asList(2, 3, 4, 0, 1, 5);
        List<Integer> validOutput2 = Arrays.asList(2, 5, 3, 4, 0, 1);
        runTest(graph2, Arrays.asList(validOutput1, validOutput2), "Test Case 2");

        // Test Case 3: Single vertex
        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        graph3.put(0, new ArrayList<>());
        List<Integer> expected3 = Arrays.asList(0);
        runTest(graph3, Arrays.asList(expected3), "Test Case 3");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(Map<Integer, List<Integer>> graph, List<List<Integer>> validOutputs, String testCaseName) {
        List<Integer> result = topologicalSort(graph);

        boolean isValid = validOutputs.stream().anyMatch(output -> output.equals(result));

        if (isValid) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.print(" (Valid Outputs: ");
            validOutputs.forEach(output -> System.out.print(output + " "));
            System.out.print(", Got: " + result);
            System.out.println(")");
        }
    }
}

