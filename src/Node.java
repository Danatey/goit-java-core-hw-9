public class Node<T> {
    T value;
    Node<T> prevNode;
    Node<T> nextNode;

    public Node(T value) {
        this.value = value;
    }
}