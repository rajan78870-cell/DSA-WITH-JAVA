class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] visitTime = new int[n]; // stores time when node was visited
        int time = 1; // global timer
        int longest = -1;

        for (int i = 0; i < n; i++) {
            if (visitTime[i] != 0) continue; // already visited

            int current = i;
            // map node to local visiting time
            java.util.HashMap<Integer, Integer> localMap = new java.util.HashMap<>();

            while (current != -1 && visitTime[current] == 0) {
                visitTime[current] = time;
                localMap.put(current, time);
                time++;
                current = edges[current];
            }

            // If current is not -1 AND it exists in the map, cycle found
            if (current != -1 && localMap.containsKey(current)) {
                longest = Math.max(longest, time - localMap.get(current));
            }
        }

        return longest;
    }
}
