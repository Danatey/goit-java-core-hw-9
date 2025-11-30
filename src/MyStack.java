public class MyStack<T> {
    private Node<T> topMyStackNode;
    private int size;

    public void push(T  value) {
        Node<T> newNode = new Node<>(value);

        newNode.prevNode = topMyStackNode;
        topMyStackNode = newNode;
        size++;
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }

        Object value = topMyStackNode.value;
        topMyStackNode = topMyStackNode.prevNode;
        size--;

        return value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            pop();
            return;
        }

        Node<T> current = topMyStackNode;
        for (int i = 0; i < index - 1; i++) {
            current = current.prevNode;
        }

        Node<T> removedNode = current.prevNode;
        current.prevNode = removedNode.prevNode;

        removedNode.prevNode = null;
        removedNode.value = null;

        size--;
    }

    public void clear() {
        while (topMyStackNode != null) {
            Node<T> temp = topMyStackNode.prevNode;
            topMyStackNode.prevNode = null;
            topMyStackNode.value = null;
            topMyStackNode = temp;
        }
        size = 0;
    }

    public int size() {
        return size;
    }
}
