import java.util.*;

public class Solution {
    public boolean isGood(int[] nums) {
        int n = 0;

        // Find max element
        for (int num : nums) {
            n = Math.max(n, num);
        }

        // Condition 1: size must be n + 1
        if (nums.length != n + 1) return false;

        int[] freq = new int[n + 1];

        // Count frequencies
        for (int num : nums) {
            if (num < 1 || num > n) return false;  // invalid number
            freq[num]++;
        }

        // Elements 1 to n-1 must each appear exactly once
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) return false;
        }

        // Element n must appear exactly twice
        return freq[n] == 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 1, 3};
        System.out.println(sol.isGood(nums1)); // false

        int[] nums2 = {1, 3, 3, 2};
        System.out.println(sol.isGood(nums2)); // true

        int[] nums3 = {1, 1};
        System.out.println(sol.isGood(nums3)); // true

        int[] nums4 = {3, 4, 4, 1, 2, 1};
        System.out.println(sol.isGood(nums4)); // false
    }
}
