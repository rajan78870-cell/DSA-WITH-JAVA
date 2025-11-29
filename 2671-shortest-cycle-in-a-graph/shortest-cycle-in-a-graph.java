import java.util.*;

class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        // build graph
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int shortest = Integer.MAX_VALUE;

        // BFS from each node
        for (int start = 0; start < n; start++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Queue<Integer> queue = new LinkedList<>();

            dist[start] = 0;
            queue.offer(start);

            int[] parent = new int[n];
            Arrays.fill(parent, -1);

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int nei : graph.get(node)) {
                    // not visited yet
                    if (dist[nei] == Integer.MAX_VALUE) {
                        dist[nei] = dist[node] + 1;
                        parent[nei] = node;
                        queue.offer(nei);
                    }
                    // visited neighbor but not parent -> cycle found
                    else if (parent[node] != nei) {
                        shortest = Math.min(shortest, dist[node] + dist[nei] + 1);
                    }
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
