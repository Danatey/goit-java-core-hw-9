public class MyArrayList<K, V> {
    private Entry<K, V>[] buckets;
    private int size;

    public MyArrayList(Entry<K, V> buckets) {
        this.buckets = new Entry[10];
        this.size = 0;
    }

    public void add(Object value) {
        if (size == buckets.length) {
            Entry[] newBuckets = new Entry[size * 2];
            for (int i = 0; i < size; i++) {
                newBuckets[i] = buckets[i];
            }
            buckets = newBuckets;
        }
        this.buckets[size] = (Entry<K, V>) value;
        this.size++;
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

    public Entry get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return buckets[index];
    }
}
