class Solution {

    // Union-Find (Disjoint Set Union)
    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);  // Path compression
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb) parent[pb] = pa;
        }
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        DSU dsu = new DSU(n);

        if (threshold == 0) {
            // Special case: everything is connected because all share divisor 1
            List<Boolean> allTrue = new ArrayList<>();
            for (int[] q : queries) allTrue.add(true);
            return allTrue;
        }

        // Build unions for numbers sharing divisors greater than threshold
        for (int d = threshold + 1; d <= n; d++) {
            for (int multiple = 2 * d; multiple <= n; multiple += d) {
                dsu.union(d, multiple);
            }
        }

        // Answer queries
        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            result.add(dsu.find(q[0]) == dsu.find(q[1]));
        }

        return result;
    }
}
