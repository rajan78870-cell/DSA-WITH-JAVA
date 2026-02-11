import java.util.*;

class Solution {
    public long countPairs(int n, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        List<Integer> componentSizes = new ArrayList<>();

        // Find connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i, graph, visited);
                componentSizes.add(size);
            }
        }

        // Count unreachable pairs
        long result = 0;
        long remaining = n;

        for (int size : componentSizes) {
            remaining -= size;
            result += (long) size * remaining;
        }

        return result;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }

        return count;
    }
}
