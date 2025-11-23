import java.util.*;

class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;

        // adjacency lists storing neighbor values
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }

        // build graph (store neighbor node values)
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            neighbors.get(a).add(vals[b]);
            neighbors.get(b).add(vals[a]);
        }

        int maxSum = Integer.MAX_VALUE * -1;

        // For each node as center
        for (int i = 0; i < n; i++) {
            List<Integer> list = neighbors.get(i);

            // keep positive neighbors only
            List<Integer> positive = new ArrayList<>();
            for (int val : list) {
                if (val > 0) positive.add(val);
            }

            // sort descending
            Collections.sort(positive, Collections.reverseOrder());

            int sum = vals[i];  // center node value

            // pick up to k top positive neighbors
            for (int j = 0; j < Math.min(k, positive.size()); j++) {
                sum += positive.get(j);
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] vals1 = {1,2,3,4,10,-10,-20};
        int[][] edges1 = {{0,1},{1,2},{1,3},{3,4},{3,5},{3,6}};
        System.out.println(sol.maxStarSum(vals1, edges1, 2)); // 16

        int[] vals2 = {-5};
        int[][] edges2 = {};
        System.out.println(sol.maxStarSum(vals2, edges2, 0)); // -5
    }
}
