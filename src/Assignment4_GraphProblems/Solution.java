package Assignment4_GraphProblems;

import java.util.*;


public class Solution {
    public static Map<Integer, List<Integer>> buildBiDirectionalGraph(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static Map<Integer, List<Integer>> buildDirectedGraph(int[][] edges){

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }
    public boolean hasPath(int[][] edges, int source, int destination) {
        if (source == destination) return true;

        // Building the graph from the edge list
        Map<Integer, List<Integer>> graph = buildBiDirectionalGraph(edges);
        // BFS to check path existence
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    if (neighbor == destination) {
                        return true;
                    }
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    public boolean allPathsLeadToDestination(int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = buildDirectedGraph(edges);

        return dfsCheck(graph, source, destination, new HashSet<>());
    }

    private boolean dfsCheck(Map<Integer, List<Integer>> graph, int current, int destination, Set<Integer> visiting) {
        if (current == destination) return true;
        if (!graph.containsKey(current)) return false; // No way forward
        if (visiting.contains(current)) return false; // Detected a cycle

        visiting.add(current);
        for (int neighbor : graph.get(current)) {
            if (!dfsCheck(graph, neighbor, destination, visiting)) return false;
        }
        visiting.remove(current);

        return true;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Problem 1
        int[][] edges1_1 = { {0, 1}, {1, 2}, {2, 0} };
        System.out.println(solver.hasPath(edges1_1, 0, 2)); // Expected: true

        int[][] edges1_2 = { {0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3} };
        System.out.println(solver.hasPath(edges1_2, 0, 5)); // Expected: false




        // Test Problem 2
        int[][] edges2_1 = { {0, 1}, {0, 2} };
        System.out.println(solver.allPathsLeadToDestination(edges2_1, 0, 2)); // Expected: false

        int[][] edges2_2 = { {0, 1}, {0, 3}, {1, 2}, {2, 1} };
        System.out.println(solver.allPathsLeadToDestination(edges2_2, 0, 3)); // Expected: false

        int[][] edges2_3 = { {0, 1}, {1, 2}, {2, 3} };
        System.out.println(solver.allPathsLeadToDestination(edges2_3, 0, 3)); // Expected: true
    }


}
