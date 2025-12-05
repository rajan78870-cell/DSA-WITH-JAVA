class Solution {
    public boolean isArraySpecial(int[] nums) {
        // If there is only one element, it is always special
        if (nums.length <= 1) return true;

        for (int i = 1; i < nums.length; i++) {
            // Check if nums[i] and nums[i-1] have the same parity
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                return false;
            }
        }
        return true;
    }
}
