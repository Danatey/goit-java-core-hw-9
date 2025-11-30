public class MyLinkedList {
    private Node headLinkedListNode;
    private Node tailLinkedListNode;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);

        if (size == 0) {
            headLinkedListNode = newNode;
            tailLinkedListNode = newNode;
        } else {
            newNode.prevNode = tailLinkedListNode;
            tailLinkedListNode.nextNode = newNode;
            tailLinkedListNode = newNode;
        }
        size++;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return getNode(index).value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node node = getNode(index);

        Node prev = node.prevNode;
        Node next = node.nextNode;

        if (prev != null) {
            prev.nextNode = next;
        } else {
            headLinkedListNode = next;
        }

        if (next != null) {
            next.prevNode = prev;
        } else {
            tailLinkedListNode = prev;
        }

        node.prevNode = null;
        node.nextNode = null;
        node.value = null;

        size--;
    }

    public void clear() {
        Node current = headLinkedListNode;
        while (current != null) {
            Node next = current.nextNode;
            current.prevNode = null;
            current.nextNode = null;
            current.value = null;
            current = next;
        }
        headLinkedListNode = null;
        tailLinkedListNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private Node getNode(int index) {
        Node current = headLinkedListNode;
        if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                current = current.nextNode;
            }
        } else {
            current = tailLinkedListNode;

            for (int i = size - 1; i > index; i--) {
                current = current.prevNode;
            }
        }
        return current;
    }
}
