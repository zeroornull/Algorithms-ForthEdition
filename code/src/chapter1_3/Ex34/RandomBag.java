package chapter1_3.Ex34;

import algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomBag<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    private void resize(int max) {
        assert max > N;
        Item[] temp = (Item[]) new Object[max];
        if (N >= 0) {
            System.arraycopy(a, 0, temp, 0, N);
        }
        a = temp;
    }


    public void enqueue(Item item) {

    }

    public Item dequeue() {
        return null;
    }

    public Item sample() {
        return null;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }


    private class RandomIterator implements Iterator<Item> {
        Item[] temp;
        private int i = 0;

        public RandomIterator() {
            temp = (Item[]) new Object[N];
            for (int j = 0; j < N; j++) {
                temp[j] = a[j];
            }
            StdRandom.shuffle(temp);
        }

        @Override
        public boolean hasNext() {

            return i != N;
        }

        @Override
        public Item next() {
            if (i == N) {
                throw new NoSuchElementException();
            }
            return temp[i++];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
