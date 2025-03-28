package com.dsa.graph;

import java.util.*;

//Using tranjans Algorithm
public class StronglyConnectedGraph {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // Method to add edges to the graph
    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    public List<List<Integer>> findSCCs() {
        List<List<Integer>> sccs = new ArrayList<>();
        Map<Integer, Integer> discovery = new HashMap<>();
        Map<Integer, Integer> low = new HashMap<>();
        Stack<Integer> scc = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        int time = 0;

        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                findSCCUsingTranjansAlgorithm(node, discovery, low, scc, sccs, visited, time);
            }
        }

        return sccs;
    }

    public void findSCCUsingTranjansAlgorithm(int node, Map<Integer, Integer> discovery, Map<Integer, Integer> low, Stack<Integer> scc, List<List<Integer>> sccs, Set<Integer> visited, int time) {
        discovery.put(node, time);
        low.put(node, time);
        scc.push(node);
        visited.add(node);
        time++;

        if (graph.get(node) != null) {
            for (Integer neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    findSCCUsingTranjansAlgorithm(neighbor, discovery, low, scc, sccs, visited, time);
                    low.put(node, Math.min(low.get(node), low.get(neighbor)));
                } else if (scc.contains(neighbor)) {
                    low.put(node, Math.min(low.get(node), discovery.get(neighbor)));
                }
            }
        }

        if (low.get(node).equals(discovery.get(node))) {
            List<Integer> result = new ArrayList<>();
            int w;
            do {
                w = scc.pop();
                result.add(w);
            } while (w != node);
            sccs.add(result);
        }
    }

    // Utility method to run a test case
    public static void runTest(StronglyConnectedGraph graph, List<List<Integer>> expected, String testCaseName) {
        List<List<Integer>> result = graph.findSCCs();

        // Sort both the result and expected SCCs for comparison (order may vary in DFS)
        result.forEach(Collections::sort);
        expected.forEach(Collections::sort);
        result.sort(Comparator.comparing(o -> o.get(0)));
        expected.sort(Comparator.comparing(o -> o.get(0)));

        if (result.equals(expected)) {
            // Green output for pass
            System.out.println("\u001B[32m" + testCaseName + " Passed \u001B[0m");
        } else {
            // Red output for fail
            System.out.println("\u001B[31m" + testCaseName + " Failed \u001B[0m");
            System.out.println("Expected: " + expected);
            System.out.println("Got: " + result);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Simple graph with one SCC
        StronglyConnectedGraph graph1 = new StronglyConnectedGraph();
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        List<List<Integer>> expected1 = Arrays.asList(Arrays.asList(0, 1, 2));
        runTest(graph1, expected1, "Test Case 1");

        // Test Case 2: Graph with multiple SCCs
        StronglyConnectedGraph graph2 = new StronglyConnectedGraph();
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 0);
        graph2.addEdge(1, 3);
        graph2.addEdge(3, 4);
        List<List<Integer>> expected2 = Arrays.asList(
                Arrays.asList(0, 1, 2),
                Arrays.asList(3),
                Arrays.asList(4)
        );
        runTest(graph2, expected2, "Test Case 2");

        // Test Case 3: Disconnected graph
        StronglyConnectedGraph graph3 = new StronglyConnectedGraph();
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 0);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 2);
        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(2, 3)
        );
        runTest(graph3, expected3, "Test Case 3");

        // Test Case 4: No edges
        StronglyConnectedGraph graph4 = new StronglyConnectedGraph();
        graph4.addEdge(0, 0);
        List<List<Integer>> expected4 = Arrays.asList(Arrays.asList(0));
        runTest(graph4, expected4, "Test Case 4");
    }
}
