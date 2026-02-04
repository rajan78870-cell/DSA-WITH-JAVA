class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        
        int partSize = length / k;
        int extra = length % k;

        curr = head;

        for (int i = 0; i < k; i++) {
            result[i] = curr;
            int currentPartSize = partSize + (extra > 0 ? 1 : 0);

            if (extra > 0) extra--;

            // Move to the end of this part
            for (int j = 0; j < currentPartSize - 1 && curr != null; j++) {
                curr = curr.next;
            }

            // Cut the list
            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null;
                curr = nextPart;
            }
        }

        return result;
    }
}
