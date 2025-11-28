public class MyLinkedList {
    private Node firstLinkedListNode;
    private Node lastLinkedListNode;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);

        if (size == 0) {
            firstLinkedListNode = newNode;
            lastLinkedListNode = newNode;
        } else {
            newNode.prevNode = lastLinkedListNode;
            lastLinkedListNode.nextNode = newNode;
            lastLinkedListNode = newNode;
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
            firstLinkedListNode = next;
        }

        if (next != null) {
            next.prevNode = prev;
        } else {
            lastLinkedListNode = prev;
        }

        node.prevNode = null;
        node.nextNode = null;
        node.value = null;

        size--;
    }

    public void clear() {
        Node current = firstLinkedListNode;
        while (current != null) {
            Node next = current.nextNode;
            current.prevNode = null;
            current.nextNode = null;
            current.value = null;
            current = next;
        }
        firstLinkedListNode = null;
        lastLinkedListNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private Node getNode(int index) {
        Node current = firstLinkedListNode;
        if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                current = current.nextNode;
            }
        } else {
            current = lastLinkedListNode;

            for (int i = size - 1; i > index; i--) {
                current = current.prevNode;
            }
        }
        return current;
    }
}
