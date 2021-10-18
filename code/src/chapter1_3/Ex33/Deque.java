package chapter1_3.Ex33;

import java.util.Currency;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    private Node left;
    private Node right;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        Node cur = new Node();
        cur.item = item;
        if (isEmpty()) {
            left = cur;
            right = cur;
            ++N;
        } else {
            cur.next = left;
            left.prev = cur;
            left = cur;
            ++N;
        }
    }

    public void pushRight(Item item) {
        Node cur = new Node();
        cur.item = item;
        if (isEmpty()) {
            left = cur;
            right = cur;
            ++N;
        } else {
            // 这里顺序会产生影响吗
            right.next = cur;

            cur.prev = right;
            right = cur;
            ++N;
        }
    }

    public Item popLeft() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        // 剩最后一个的时候要注意改边left 和 right
        if (size() == 1) {
            left = null;
            right = null;
            N = 0;
        }
        Item item = left.item;
        --N;

        Node cur = left;
        left = left.next;
        cur.next = null;
        left.prev = null;
        return item;

    }

    public Item popRight() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        // 剩最后一个的时候要注意改边left 和 right
        if (size() == 1) {
            left = null;
            right = null;
            N = 0;
        }
        Item item = right.item;
        --N;

        Node cur = right;
        right = right.prev;
        cur.prev = null;
        right.next = null;
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
            Node current = left;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args)
    {
        Deque<Integer> deque=new Deque<Integer>();
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushRight(3);
        deque.pushRight(4);
        deque.popLeft();
        deque.popRight();
        deque.popLeft();

        for(Integer i:deque)
        {
            System.out.print(i+" ");
        }
    }
}
