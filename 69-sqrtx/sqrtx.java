class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1;
        int right = x / 2;
        int ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == x) return (int) mid;

            if (square < x) {
                ans = (int) mid;   // mid is a possible answer
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }

        return ans;  // floor(sqrt(x))
    }
}
