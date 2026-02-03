class MyLinkedList {

    // Node definition
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head; // dummy head
    private int size;

    public MyLinkedList() {
        head = new Node(0); // dummy node
        size = 0;
    }

    // Get value at index
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    // Add at head
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // Add at tail
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // Add at index
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;

        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node newNode = new Node(val);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    // Delete at index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        size--;
    }
}
