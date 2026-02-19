
class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            int g = gcd(curr.val, curr.next.val);

            // Create new node with gcd value
            ListNode newNode = new ListNode(g);

            // Insert it between curr and curr.next
            newNode.next = curr.next;
            curr.next = newNode;

            // Move to the next original node
            curr = newNode.next;
        }

        return head;
    }
}
