import java.util.*;

class Graph {

    private List<List<int[]>> adj;
    private int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            addEdge(e);
        }
    }

    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[node1] = 0;

        // Min-heap for Dijkstra (node, cost)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{node1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];

            // If we reached node2, return shortest cost
            if (node == node2) return cost;

            for (int[] neighbor : adj.get(node)) {
                int next = neighbor[0];
                int edgeCost = neighbor[1];

                if (cost + edgeCost < dist[next]) {
                    dist[next] = cost + edgeCost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return -1; // No path found
    }
}

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph(4, new int[][]{
            {0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}
        });

        System.out.println(g.shortestPath(3, 2)); // Output: 6
        System.out.println(g.shortestPath(0, 3)); // Output: -1

        g.addEdge(new int[]{1, 3, 4});

        System.out.println(g.shortestPath(0, 3)); // Output: 6
    }
}
