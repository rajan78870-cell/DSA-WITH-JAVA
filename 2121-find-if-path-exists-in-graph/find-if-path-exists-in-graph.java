import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // Visited array
        boolean[] visited = new boolean[n];

        // DFS
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(List<List<Integer>> graph, int node, int destination, boolean[] visited) {
        if (node == destination) return true;
        if (visited[node]) return false;

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    // You can test it here
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 3;
        int[][] edges1 = {{0,1},{1,2},{2,0}};
        System.out.println(sol.validPath(n1, edges1, 0, 2));  // true

        int n2 = 6;
        int[][] edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(sol.validPath(n2, edges2, 0, 5));  // false
    }
}
