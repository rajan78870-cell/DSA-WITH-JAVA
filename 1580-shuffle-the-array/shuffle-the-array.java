class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int i = 0;      // pointer for x part
        int j = n;      // pointer for y part
        int k = 0;      // pointer for result array

        while (i < n && j < 2 * n) {
            result[k++] = nums[i++];
            result[k++] = nums[j++];
        }

        return result;
    }
}
