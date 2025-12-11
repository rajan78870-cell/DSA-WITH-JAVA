import java.util.*;

public class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        // Count frequency of every number across all arrays
        for (int[] arr : nums) {
            for (int num : arr) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        // Collect numbers that appear in all arrays
        List<Integer> result = new ArrayList<>();
        for (int key : freq.keySet()) {
            if (freq.get(key) == n) {
                result.add(key);
            }
        }

        Collections.sort(result);
        return result;
    }

    // Test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] nums1 = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        System.out.println(sol.intersection(nums1)); // [3, 4]

        int[][] nums2 = {{1,2,3},{4,5,6}};
        System.out.println(sol.intersection(nums2)); // []
    }
}
