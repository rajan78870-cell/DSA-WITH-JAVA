class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        // Initialize binary search range
        for (int num : nums) {
            low = Math.max(low, num); // max element
            high += num;              // sum of all elements
        }

        // Binary search on the answer
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;   // try smaller largest sum
            } else {
                low = mid + 1; // need larger sum
            }
        }
        return low;
    }

    // Check if array can be split into <= k subarrays
    // with max subarray sum <= maxSum
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;

                if (subarrays > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}
