package chapter1_3.Ex29;

import java.io.UTFDataFormatException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node last;
    private int N;


    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private int size() {
        return N;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        N--;
        Item item = last.next.item;
        if (last.next == last) {
            //
            last = null;
            return item;
        }
        last.next = last.next.next;//last.next 表示首元素
        return item;
    }

    public void enqueue(Item item) {
        N++;
        if (last == null) {
            last = new Node();
            last.item = item;
            last.next = last;
        } else {
            Node current = new Node();
            current.item = item;
            current.next = last.next;
            last.next = current;
            last = current;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i = N;

            public boolean hasNext() {
                return i != 0;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (isEmpty())
                    throw new NoSuchElementException();
                i--;
                if (last == last.next)//只有一个元素
                {
                    Item item = last.next.item;
                    last = null;
                    return item;
                }

                Item item = last.next.item;
                last.next = last.next.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        for (Integer i : queue)
            System.out.println(i);
    }

}
