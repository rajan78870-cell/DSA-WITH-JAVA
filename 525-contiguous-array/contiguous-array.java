class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store first occurrence of a running sum
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Base case: before starting, sum = 0 at index -1

        int maxLen = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            // Replace 0 with -1 to track equal zeros and ones as sum=0
            sum += (nums[i] == 0 ? -1 : 1);

            if(map.containsKey(sum)){
                // Calculate length of subarray with equal 0's and 1's
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                // Store index of first time this sum is seen
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
