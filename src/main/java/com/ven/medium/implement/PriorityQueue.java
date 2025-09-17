package com.ven.medium.implement;

public class PriorityQueue<K> {
    private K[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = (K[]) new Object[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        K temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(K key) {
        if (size == capacity) {
            throw new IllegalStateException("Priority Queue is full");
        }
        heap[size] = key;
        size++;
        heapifyUp(size - 1);
    }

    public K extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        K min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyUp(int index) {
        while (index > 0 && ((Comparable<K>) heap[index]).compareTo(heap[parent(index)]) < 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && ((Comparable<K>) heap[left]).compareTo(heap[smallest]) < 0) {
            smallest = left;
        }
        if (right < size && ((Comparable<K>) heap[right]).compareTo(heap[smallest]) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10);
        pq.insert(5);
        pq.insert(3);
        pq.insert(8);
        pq.insert(1);

        while (!pq.isEmpty()) {
            System.out.println(pq.extractMin());
        }
    }
}
