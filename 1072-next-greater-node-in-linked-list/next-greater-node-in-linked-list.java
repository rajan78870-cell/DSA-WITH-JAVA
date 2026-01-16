import java.util.*;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> values = new ArrayList<>();

        // Convert linked list to array
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int n = values.size();
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Monotonic stack
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {
                ans[stack.pop()] = values.get(i);
            }
            stack.push(i);
        }

        return ans;
    }
}
