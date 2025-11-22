class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;

        for (int num : nums) {
            int r = num % 3;
            if (r != 0) {
                operations += 1;   // Either +1 or -1 will fix it
            }
        }

        return operations;
    }
}
