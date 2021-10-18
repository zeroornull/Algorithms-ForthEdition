package chapter1_3.Ex38;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GeneralizedQueue<Item> implements Iterable<Item> {

    private int N;
    private Item[] a = (Item[]) new Object[1];

    public boolean isEmpty() {
        return N == 0;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        if (N > 0) {
            System.arraycopy(a, 0, temp, 0, N);
        }
        a = temp;
    }

    public void insert(Item x) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = x;
    }

    public Item delete(int k) {
        if (k > N || k < 0) {
            throw new NoSuchElementException();

        }
        Item item = a[k - 1];
        if (a.length - k >= 0) {
            System.arraycopy(a, k, a, k - 1, a.length - k);
        }
        N--;
        if (N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
