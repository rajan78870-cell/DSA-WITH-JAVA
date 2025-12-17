import java.util.*;

class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // 1. Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        // 2. Merge intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                merged.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        merged.add(new int[]{start, end});

        // 3. Convert List to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}
