public class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        boolean inOneSegment = false;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                if (!inOneSegment) {
                    count++;
                    inOneSegment = true;
                }
            } else {
                inOneSegment = false;
            }
            if (count > 1) return false;
        }
        return true;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.checkOnesSegment("1001")); // false
        System.out.println(sol.checkOnesSegment("110"));  // true
    }
}
