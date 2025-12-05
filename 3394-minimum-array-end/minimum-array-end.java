class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        long add = n - 1;
        long bit = 1;
        
        while (add > 0) {
            if ((x & bit) == 0) {
                if ((add & 1) == 1) {
                    res |= bit;
                }
                add >>= 1;
            }
            bit <<= 1;
        }
        
        return res;
    }
}
