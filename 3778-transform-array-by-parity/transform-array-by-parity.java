import java.util.Arrays;

class Solution {
    public int[] transformArray(int[] nums) {
        // Step 1 & 2: Replace even numbers with 0, odd numbers with 1
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] % 2 == 0) ? 0 : 1;
        }

        // Step 3: Sort the array in non-decreasing order
        Arrays.sort(nums);

        return nums;
    }

    // Optional: main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(sol.transformArray(nums1))); // [0, 0, 1, 1]

        int[] nums2 = {1, 5, 1, 4, 2};
        System.out.println(Arrays.toString(sol.transformArray(nums2))); // [0, 0, 1, 1, 1]
    }
}
