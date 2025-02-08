package org.example.coding;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/*
LRU, или LRU cache (Least Recently Used)
алгоритм для хранения ограниченного объема данных:
из хранилища вытесняется информация, которая не использовалась дольше всего.
*/
public class LRUCache<T, E> {

    private final int size;
    private final Map<T, E> cache;

    public LRUCache(int size) {
        this.size = size;
        this.cache = new LinkedHashMap<>(size, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<T, E> eldest) {
                return size() > LRUCache.this.size;
            }
        };
    }

    public void add(T key, E value) {
        cache.put(key, value);
    }

    public Optional<E> find(T key) {
        return Optional.ofNullable(cache.get(key));
    }

    public boolean containsKey(T key) {
        return cache.containsKey(key);
    }

}
