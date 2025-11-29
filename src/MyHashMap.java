import java.util.Arrays;

public class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        this.buckets = new Entry[10];
    }

    public void put(K key, V value) {
        int index = (key == null)
                ? 0
                : Math.abs(key.hashCode() % buckets.length);

        Entry<K, V> current = buckets[index];

        if (current == null) {
            buckets[index] = new Entry<>(key, value);
            size++;
            return;
        }

        Entry<K, V> prev = null;

        while (current != null) {
            if (current.getKey() != null
                    && current.getKey().equals(key)) {
                current.setValue(value);
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = new Entry<>(key, value);
        size++;
    }

    public void remove(Object key) {
        int index = (key == null)
                ? 0
                : Math.abs(key.hashCode() % buckets.length);
        Entry<K, V> current = buckets[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.getKey() != null
                    && current.getKey().equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                current.next = null;
                current.setKey(null);
                current.setValue(null);
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = (key == null)
                ? 0
                : Math.abs(key.hashCode() % buckets.length);

        Entry<K, V> current = buckets[index];

        while (current != null) {
            if (current.getKey() != null
                    && current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.next;
        }
        return null;
    }
}
