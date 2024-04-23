package com.project.functional.u15_datastructuresfunctional.s109_map;

public class MapFun<K, V> {

    private Entry[] entries;
    private int size;

    public MapFun(int size) {
        this.size = size;
        this.entries = new Entry[size];

        for (int i = 0; i < size; i++) {
            this.entries[i] = new Entry();
        }
    }

    private MapFun(Entry[] entries, int size) {
        this.entries = entries;
        this.size = size;
    }

    public Integer getHash(K key) {
        return key.hashCode() % size;
    }

    public MapFun<K, V> put(K key, V value) {
        Integer hash = getHash(key);
        Entry existingEntry = entries[hash];
        if (!setIfDuplicated(key, value)) {
            Entry nEntry = new Entry(key, value);
            entries[hash] = nEntry;
            nEntry.next = existingEntry;
        }
        return new MapFun<>(entries, size);
    }

    private boolean setIfDuplicated(K key, V value) {
        boolean result = false;
        Entry entry = entries[getHash(key)];
        while (entry != null) {
            if (key.equals(entry.key)) {
                entry.value = value;
                result = true;
                break;
            }
            entry = entry.next;
        }
        return result;
    }

    public V get(K key) {
        V val = null;
        int hash = getHash(key);
        Entry entry = entries[hash];
        while (entry.next != null) {
            if (key.equals(entry.getKey())) {
                val = (V) entry.getValue();
                break;
            }
            entry = entry.next;
        }
        return val;
    }

    public void remove(K key) {
        Integer hash = getHash(key);
        Entry entry = entries[hash];
        Entry prev = null;
        int i = 0;
        while (entry.next != null) {
            if (entry.key.equals(key)) {
                if (i == 0) {
                    entries[hash] = entry.next;
                } else {
                    prev.next = entry.next;
                }
            }
            prev = entry;
            entry = entry.next;
            i++;
        }
    }

    public void display() {
        for (int i = 0; i < this.entries.length; i++) {
            System.out.println(this.entries[i]);
        }
    }

}
