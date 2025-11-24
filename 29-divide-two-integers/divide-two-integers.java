class Solution {
    public int divide(int dividend, int divisor) {
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        // Edge case: overflow
        if (dividend == INT_MIN && divisor == -1) {
            return INT_MAX;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Work with positive long values to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        // Subtract divisor multiples using bit shifts
        while (a >= b) {
            long temp = b;
            int multiple = 1;

            // Increase divisor by powers of 2
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
