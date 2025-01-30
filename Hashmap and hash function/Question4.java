//package Hashmap;
import java.util.*;

class CustomHashMap<K, V> {
    private static final int SIZE = 16;
    private List<Entry<K, V>>[] table;

    public CustomHashMap() {
        table = new LinkedList[SIZE];
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getIndex(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        table[index].add(newEntry);
    }

    public V get(K key) {
        int index = getIndex(key);

        if (table[index] == null) {
            return null;
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);

        if (table[index] == null) {
            return;
        }

        table[index].removeIf(entry -> entry.key.equals(key));
    }
}
public class Question4{
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        System.out.println(map.get("one")); // Output: 1
        map.remove("one");
        System.out.println(map.get("one")); // Output: null
    }
}

