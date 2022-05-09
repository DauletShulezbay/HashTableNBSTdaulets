package com.company;

public class BST <K extends Comparable<K>, V>{
    private Node root = null;
    private class Node {
        private K key;
        private V value;
        private Node left = null, right = null;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public void put(K key, V val) {
        Node temp = root;
        while (temp != null) {
            if ((int)temp.key > (int)key)
                temp = temp.left;
            else
                temp = temp.right;
        }
        temp = new Node(key, val);
    }
    public V get(K key) {
        Node temp = root;
        while (temp.key != key) {
            if ((int)temp.key > (int)key)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return temp.value;
    }
    public void delete(K key) {
        Node temp = root, previous = null;
        while (temp.key != key) {
            previous = temp;
            if ((int)temp.key > (int)key)
                temp = temp.left;
            else
                temp = temp.right;
        }
        if (temp.right != null && temp.left != null) {
            Node right = temp.right;
            Node left = temp.left;
            if (previous.right == temp) {
                previous.right = right;
            }
            else
                previous.left = right;
            temp = right;
            Node oldleft = right.left;
            temp.left = left;
            while (temp.left != null)
                temp = temp.right;
            temp.left = oldleft;
        }
        else if (temp.right != null) {
            if (previous.right == temp)
                previous.right = temp.right;
            else
                previous.left = temp.right;
        }
        else if (temp.left != null) {
            if (previous.right == temp)
                previous.right = temp.left;
            else
                previous.left = temp.left;
        }
        else {
            if (previous.right == temp)
                previous.right = null;
            else
                previous.left = null;
        }
    }
}
