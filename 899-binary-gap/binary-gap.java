class Solution {
    public int binaryGap(int n) {
        int last = -1;   // position of the previous '1'
        int maxDist = 0; // maximum distance found
        int pos = 0;     // current bit position
        
        while (n > 0) {
            if ((n & 1) == 1) { // if the current bit is 1
                if (last != -1) {
                    maxDist = Math.max(maxDist, pos - last);
                }
                last = pos;
            }
            pos++;
            n >>= 1; // shift right to check next bit
        }
        
        return maxDist;
    }
}
 
