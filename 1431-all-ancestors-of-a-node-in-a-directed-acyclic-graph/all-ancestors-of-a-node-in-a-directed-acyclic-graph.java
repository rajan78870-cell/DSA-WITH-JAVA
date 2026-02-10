import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
       
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

       
        int[] indegree = new int[n];

        
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

      
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

       
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph.get(u)) {
                
                ancestors.get(v).add(u);
                
                ancestors.get(v).addAll(ancestors.get(u));

                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(ancestors.get(i));
            Collections.sort(list);
            result.add(list);
        }

        return result;
    }
}
