import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int size = 1 << n;  // 2^n

        for (int i = 0; i < size; i++) {
            int gray = i ^ (i >> 1);
            result.add(gray);
        }

        return result;
    }
}
