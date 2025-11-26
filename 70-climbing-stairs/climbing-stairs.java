class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n; // base cases: 1 step → 1 way, 2 steps → 2 ways

        int first = 1; // ways to reach step 1
        int second = 2; // ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int current = first + second; // current = ways to reach i-th step
            first = second;  // shift forward
            second = current;
        }

        return second;
    }
}
