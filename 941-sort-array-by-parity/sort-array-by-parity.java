class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            // left already even → move ahead
            if (nums[left] % 2 == 0) {
                left++;
            }
            // right already odd → move backward
            else if (nums[right] % 2 == 1) {
                right--;
            }
            // swap odd (left) with even (right)
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
