import java.util.*;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            // Any number appearing more than 2 times makes splitting impossible
            if (freq.get(num) > 2) return false;
        }
        
        return true;
    }

    // Testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPossibleToSplit(new int[]{1,1,2,2,3,4})); // true
        System.out.println(sol.isPossibleToSplit(new int[]{1,1,1,1}));     // false
    }
}
