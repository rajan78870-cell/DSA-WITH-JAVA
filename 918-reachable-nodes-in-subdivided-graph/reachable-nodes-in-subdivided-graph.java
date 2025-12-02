import java.util.*;

class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // Build graph adjacency list where weight = cnt + 1
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            graph[u].add(new int[]{v, cnt + 1});
            graph[v].add(new int[]{u, cnt + 1});
        }

        // Dijkstra shortest paths
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0}); // node 0, distance 0

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];
            if (d > dist[node]) continue;

            for (int[] nei : graph[node]) {
                int next = nei[0];
                int weight = nei[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        int result = 0;

        // Count reachable original nodes
        for (int d : dist) {
            if (d <= maxMoves)
                result++;
        }

        // Count reachable subdivided nodes on edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];

            int remU = Math.max(0, maxMoves - dist[u]);
            int remV = Math.max(0, maxMoves - dist[v]);

            result += Math.min(cnt, remU + remV);
        }

        return result;
    }
}
