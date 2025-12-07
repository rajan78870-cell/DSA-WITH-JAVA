class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Fix: Required for driver testing
    public static ListNode deserialize(String data) {
        data = data.replace("[", "").replace("]", "");
        if (data.isEmpty()) return null;

        String[] values = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String s : values) {
            current.next = new ListNode(Integer.parseInt(s.trim()));
            current = current.next;
        }

        return dummy.next;
    }

    // Optional: To print the linked list
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) sb.append(",");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // find middle (slow will be at mid)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode secondHalf = reverse(slow);

        // compare both halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
