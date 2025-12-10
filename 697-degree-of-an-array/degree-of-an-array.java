import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();       // frequency of each number
        Map<Integer, Integer> firstIndex = new HashMap<>();  // first appearance index
        Map<Integer, Integer> lastIndex = new HashMap<>();   // last appearance index

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Count frequency
            count.put(num, count.getOrDefault(num, 0) + 1);

            // Record first index
            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }

            // Always update last index
            lastIndex.put(num, i);
        }

        // Find array degree
        int degree = Collections.max(count.values());
        int result = Integer.MAX_VALUE;

        // For all numbers that have the same frequency as the degree
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                int length = lastIndex.get(num) - firstIndex.get(num) + 1;
                result = Math.min(result, length);
            }
        }

        return result;
    }
}
