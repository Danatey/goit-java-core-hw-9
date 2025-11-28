public class MyQueue {
    private Node firstMyQueueNode;
    private Node lastMyQueueNode;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);

        if (size == 0) {
            firstMyQueueNode = newNode;
            lastMyQueueNode = newNode;
        } else {
            lastMyQueueNode.nextNode = newNode;
            lastMyQueueNode = newNode;
        }

        size++;
    }

    public void clear() {
        firstMyQueueNode = null;
        lastMyQueueNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            return null;
        }
        return firstMyQueueNode.value;
    }

    public Object poll() {
        if (size == 0) {
            return null;
        }

        Object value = firstMyQueueNode.value;
        firstMyQueueNode = firstMyQueueNode.nextNode;

        size--;

        if (size == 0) {
            lastMyQueueNode = null;
        }

        return value;
    }
}
