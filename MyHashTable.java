package com.company;

public class MyHashTable <K, V>{
    private class HashNode<K, V> {
        private K key = null;
        private V value;
        private HashNode<K, V> next = null;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + '}';
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable(int M) {
        size = 0;
        this.M = M;
        chainArray = new HashNode[M];
    }
    private int hash(K key) {
        return (int) key % M;
    }
    public void put(K key, V value) {
        if (chainArray[hash(key)].key == null) {
            chainArray[hash(key)] = new HashNode(key, value);
            return;
        }
        HashNode<K, V> temp = chainArray[hash(key)];
        chainArray[hash(key)] = new HashNode(key, value);
        chainArray[hash(key)].next = temp;
    }
    public V get(K key) {
        int i = hash(key);
        return chainArray[i].value;
    }
    public V remove(K key) {
        int i = hash(key);
        HashNode<K, V> temp = chainArray[i];
        chainArray[i] = chainArray[i].next;
        return temp.value;
    }
    public boolean contains (V value) {
        for (int i = 0; i < M; i ++) {
            HashNode<K, V> temp = chainArray[i];
            do{
                if (temp.value == value) return true;
                temp = temp.next;
            }while (temp.key != null);
        }
        return false;
    }
    public K getKey(V value) {
        for (int i = 0; i < M; i ++) {
            HashNode<K, V> temp = chainArray[i];
            do{
                if (temp.value == value) return temp.key;
                temp = temp.next;
            }while (temp.key != null);
        }
        return null;
    }
}
