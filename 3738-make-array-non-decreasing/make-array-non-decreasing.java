import java.util.*;

class Solution {
    public int maximumPossibleSize(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int x : nums) {
            stack.addLast(x);

            while (stack.size() >= 2) {
                int last = stack.removeLast();
                int prev = stack.removeLast();

                if (prev <= last) {
                    stack.addLast(prev);
                    stack.addLast(last);
                    break;
                } else {
                    stack.addLast(Math.max(prev, last));
                }
            }
        }

        return stack.size();
    }
}