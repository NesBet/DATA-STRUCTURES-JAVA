public class SortedNumberList {
    public Node head;
    public Node tail;

    public SortedNumberList() {
        head = null;
        tail = null;
    }

    // Inserts the number into the list in the correct position such that the
    // list remains sorted in ascending order.
    public void insert(double number) {
        Node newNode = new Node(number);

        if (head == null) {
            // If the list is empty, make the new node the head and tail
            head = newNode;
            tail = newNode;
        } else if (number <= head.data) {
            // If the new value is less than or equal to the head, insert at the beginning
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (number >= tail.data) {
            // If the new value is greater than or equal to the tail, insert at the end
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            // Find the correct position to insert the new value while maintaining the sorted order
            Node current = head.next;
            while (current != null && current.data < number) {
                current = current.next;
            }

            // Insert the new node before the current node
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }
    }

    // Removes the node with the specified number value from the list. Returns
    // true if the node is found and removed, false otherwise.
    public boolean remove(double number) {
        Node current = head;

        while (current != null) {
            if (current.data == number) {
                if (current == head) {
                    // If the node to be removed is the head
                    head = head.next;
                    if (head != null) {
                        head.previous = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    // If the node to be removed is the tail
                    tail = tail.previous;
                    tail.next = null;
                } else {
                    // If the node to be removed is in the middle
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                return true;
            }

            current = current.next;
        }

        return false;
    }
}
