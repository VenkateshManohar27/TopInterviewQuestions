package com.ven.medium.implement;


class Node<K, T> {
    K key;
    T value;
    Node<K, T> next;

    public Node(K key, T value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class HashMap<K, T> {
    T[] table;

    int capacity;

    int size = 0;

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.table = (T[]) new Object[capacity];
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, T value) {
        int index = hash(key);
        Node<K, T> newNode = new Node<>(key, value);

        if (table[index] == null) {
            table[index] = (T) newNode;
        } else {
            Node<K, T> current = (Node<K, T>) table[index];
            while (true) {
                if (current.key.equals(key)) {
                    current.value = value; // Update existing key
                    return;
                }
                if (current.next == null) break;
                current = current.next;
            }
            current.next = newNode; // Add to the end of the chain
        }
        size++;
    }

    public T get(K key) {
        int index = hash(key);
        Node<K, T> current = (Node<K, T>) table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, T> current = (Node<K, T>) table[index];
        Node<K, T> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = (T) current.next; // Remove head
                    size--;
                } else {
                    prev.next = current.next; // Bypass the current node
                    size--;
                }
                return;
            }
            prev = current;
            current = current.next;
        }

    }

    public void resize() {
        // Optional: Implement resizing logic when load factor exceeds a threshold
        // This typically involves creating a new larger array and rehashing all existing keys
        // Not implemented in this example
        if (size > capacity * 0.7) {
            int newCapacity = capacity * 2;
            T[] newTable = (T[]) new Object[newCapacity];

            for (T item : table) {
                Node<K, T> current = (Node<K, T>) item;
                while (current != null) {
                    int newIndex = current.key.hashCode() % newCapacity;
                    Node<K, T> newNode = new Node<>(current.key, current.value);

                    if (newTable[newIndex] == null) {
                        newTable[newIndex] = (T) newNode;
                    } else {
                        Node<K, T> temp = (Node<K, T>) newTable[newIndex];
                        while (temp.next != null) {
                            temp = temp.next;
                        }
                        temp.next = newNode;
                    }
                    current = current.next;
                }
            }
            table = newTable;
            capacity = newCapacity;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(10);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println(map.get("two")); // Output: 2
        map.remove("two");
        System.out.println(map.get("two")); // Output: null
    }
}
