public class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false; // At least 3 elements needed

        int i = 0;

        // 1. Find the end of the first strictly increasing segment
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
        if (i == 0 || i == n - 1) return false; // No increase at start or no room for decrease

        int p = i; // First peak index

        // 2. Find the end of the strictly decreasing segment
        while (i + 1 < n && nums[i] > nums[i + 1]) i++;
        if (i == p) return false; // No decreasing segment
        if (i == n - 1) return false; // No room for final increase

        // 3. Check if the remaining segment is strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;

        return i == n - 1; // True if we reached the end
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 3, 5, 4, 2, 6};
        int[] nums2 = {2, 1, 3};
        System.out.println(sol.isTrionic(nums1)); // true
        System.out.println(sol.isTrionic(nums2)); // false
    }
}
