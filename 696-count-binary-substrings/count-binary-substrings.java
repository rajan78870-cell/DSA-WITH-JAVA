public class Solution {
    public int countBinarySubstrings(String s) {
        int prevRunLength = 0; // Length of the previous consecutive group
        int currRunLength = 1; // Length of the current consecutive group
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currRunLength++; // Extend the current group
            } else {
                // When the group changes, add min of previous and current group to count
                count += Math.min(prevRunLength, currRunLength);
                prevRunLength = currRunLength; // Update previous group length
                currRunLength = 1; // Reset current group length
            }
        }

        // Add the last pair of groups
        count += Math.min(prevRunLength, currRunLength);

        return count;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "00110011";
        System.out.println(sol.countBinarySubstrings(s1)); // Output: 6

        String s2 = "10101";
        System.out.println(sol.countBinarySubstrings(s2)); // Output: 4
    }
}
