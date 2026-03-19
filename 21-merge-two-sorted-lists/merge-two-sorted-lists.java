import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Deserialize from string, e.g. "[1,2,4]"
    static ListNode deserialize(String data) {
        data = data.replaceAll("\\[|\\]|\\s", "");
        if (data.isEmpty()) return null;
        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }
        return dummy.next;
    }

   
    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

      
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        
        ListNode list1 = ListNode.deserialize("[1,2,4]");
        ListNode list2 = ListNode.deserialize("[1,3,4]");

        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        ListNode.print(merged);
    }
}
