package tao;

import java.util.HashMap;

public class Pool<K> {
    private final HashMap<K, Integer> keyIndexMap;
    private final HashMap<Integer, K> indexKeyMap;
    private int size;

    public Pool() {
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        this.size = 0;
    }

    public void insert(K key) {
        if (keyIndexMap.containsKey(key)) {
            return;
        }
        keyIndexMap.put(key, size);
        indexKeyMap.put(size, key);
        size++;
    }

    public void delete(K key) {
        if (!keyIndexMap.containsKey(key)) {
            return;
        }
        int index = keyIndexMap.get(key);
        K lastKey = indexKeyMap.get(--size);
        keyIndexMap.put(lastKey, index);
        indexKeyMap.put(index, lastKey);
        indexKeyMap.remove(size);
        keyIndexMap.remove(key);
    }

    public K getRandom() {
        if (size == 0) {
            return null;
        }
        int random = (int) (Math.random() * size);
        return indexKeyMap.get(random);
    }
}
