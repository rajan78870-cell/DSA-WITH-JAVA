import java.util.*;

class Solution {

    // Union-Find (Disjoint Set Union) class
    static class DSU {
        int[] parent;
        int[] rank;
        int components;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            components = n;
            for (int i = 1; i <= n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return false; // already connected
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            components--;
            return true;
        }

        boolean isConnected() {
            return components == 1;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // First, use type 3 edges (shared by both Alice and Bob)
        DSU dsuAlice = new DSU(n);
        DSU dsuBob = new DSU(n);
        int removedEdges = 0;

        // Process type 3 edges first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean mergedAlice = dsuAlice.union(edge[1], edge[2]);
                boolean mergedBob = dsuBob.union(edge[1], edge[2]);
                if (!mergedAlice && !mergedBob) removedEdges++;
            }
        }

        // Process type 1 edges (Alice only)
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!dsuAlice.union(edge[1], edge[2])) removedEdges++;
            }
        }

        // Process type 2 edges (Bob only)
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (!dsuBob.union(edge[1], edge[2])) removedEdges++;
            }
        }

        // Check if both Alice and Bob can traverse the entire graph
        if (!dsuAlice.isConnected() || !dsuBob.isConnected()) return -1;

        return removedEdges;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 4;
        int[][] edges1 = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        System.out.println(sol.maxNumEdgesToRemove(n1, edges1)); // Output: 2

        int n2 = 4;
        int[][] edges2 = {{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
        System.out.println(sol.maxNumEdgesToRemove(n2, edges2)); // Output: 0

        int n3 = 4;
        int[][] edges3 = {{3,2,3},{1,1,2},{2,3,4}};
        System.out.println(sol.maxNumEdgesToRemove(n3, edges3)); // Output: -1
    }
}
