public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost element,
            // the minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }

        // At the end, left == right pointing to the minimum element
        return nums[left];
    }

    // Test examples
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(sol.findMin(nums1)); // Output: 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(sol.findMin(nums2)); // Output: 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(sol.findMin(nums3)); // Output: 11
    }
}
