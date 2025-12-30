class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        // Find node before index a
        ListNode prev = list1;
        for (int i = 0; i < a - 1; i++) {
            prev = prev.next;
        }

        // Find node after index b
        ListNode curr = prev.next;
        for (int i = a; i <= b; i++) {
            curr = curr.next;
        }

        // Connect prev to list2
        prev.next = list2;

        // Find tail of list2
        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Connect tail to remaining list1
        tail.next = curr;

        return list1;
    }
}
