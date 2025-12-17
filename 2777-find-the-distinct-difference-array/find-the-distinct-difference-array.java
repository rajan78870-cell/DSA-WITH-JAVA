import java.util.*;

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];

        // Step 1: Compute suffix distinct counts
        int[] suffixDistinct = new int[n];
        Set<Integer> suffixSet = new HashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            suffixSet.add(nums[i]);
            suffixDistinct[i] = suffixSet.size();
        }

        // Step 2: Compute prefix distinct counts and diff
        Set<Integer> prefixSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            prefixSet.add(nums[i]);
            int prefixCount = prefixSet.size();
            int suffixCount = (i + 1 < n) ? suffixDistinct[i + 1] : 0;
            diff[i] = prefixCount - suffixCount;
        }

        return diff;
    }
}
