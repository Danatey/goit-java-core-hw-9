public class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        this.buckets = new Entry[10];
    }



    public int size() {
        return size;
    }
}
