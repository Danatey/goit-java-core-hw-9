public class MyArrayList<T> {
    private T[] buckets;
    private int size;

    public MyArrayList() {
        this.buckets = (T[]) new Object[10];
        this.size = 0;
    }

    public void add(T value) {
        if (size == buckets.length) {
            T[] newArray = (T[]) new Object[size * 2];
            System.arraycopy(buckets, 0, newArray, 0, size);
            buckets = newArray;
        }
        buckets[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        for (int i = index; i < size - 1; i++) {
            buckets[i] = buckets[i + 1];
        }

        buckets[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return buckets[index];
    }
}
