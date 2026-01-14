import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        
        // dp[node][color] = max count of color on any path ending at node
        int[][] dp = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }
        
        int visited = 0;
        int ans = 0;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            
            for (int c = 0; c < 26; c++) {
                ans = Math.max(ans, dp[u][c]);
            }
            
            for (int v : graph.get(u)) {
                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                }
                
                int colorIdx = colors.charAt(v) - 'a';
                dp[v][colorIdx] = Math.max(dp[v][colorIdx], dp[u][colorIdx] + 1);
                
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        return visited == n ? ans : -1;
    }
}
