package list;

public class SLinkedList<S> implements MyList<S> {
    private Node head = null;

    public void addFirst(S data) {
        head = new Node(data, head);
    }

    public void print() {
        Node p = head;
        System.out.print("[");
        while (p != null) {
            System.out.print(p.getData() + ", ");
            p = p.getNext();
        }
        System.out.println("]");
    }

    public class Node { // inner class
        private final S data;
        private Node next;

        public Node(S data, Node next) {
            this.data = data;
            this.next = next;
        }

        public S getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    public void append(S data) {
        head = append(head, data);  // head changes after this?
    }

    // append data to the end of the list starting at node x
    // return the start of the new list
    private Node append(Node x, S data) {
        if (x == null) return new Node(data, null);
        else x.next = append(x.next, data);
        return x;
    }

    private void append_i(S data) {
        Node newNode = new Node(data, null);
        if (head == null) head = newNode;
        else {
            Node p = head;
            // loop until p points to the last node (p.next==null)
            while (p.next != null) p = p.next;
            p.next = newNode;
        }
    }

    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<>();
        list.append("one");
        list.print(); // one
        list.addFirst("two");
        list.append("three");
        list.print(); // two one three
    }

}
