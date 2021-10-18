package chapter1_3.Ex39;

import java.util.concurrent.atomic.LongAdder;

public class CycleCacheBuffer<Item> {

    private int N;
    private int head;
    private int tail;
    private Item[] a;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public CycleCacheBuffer() {
        a = (Item[]) new Object[10];
    }

    public CycleCacheBuffer(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public void enqueue(Item item) {
        if (N == a.length) {
            throw new RuntimeException();
        }
        a[tail++] = item;
        if (tail == a.length) {
            tail = 0;
        }

    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        N--;
        Item item = a[head++];
        if (head == a.length) {
            head = 0;
        }
        return item;
    }
}
