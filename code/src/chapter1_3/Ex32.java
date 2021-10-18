package chapter1_3;

import java.awt.*;
import java.util.Iterator;

public class Ex32<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        N++;
        Node node = new Node();
        node.item = item;
        node.next = null;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            first = node;
        }

    }

    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        Item item = first.item;
        first = first.next;
        return item;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = first.item;
                first = first.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
