import java.util.*;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int value = 0; // stores current value mod 5

        for (int bit : nums) {
            value = (value * 2 + bit) % 5;
            result.add(value == 0);
        }

        return result;
    }
}
