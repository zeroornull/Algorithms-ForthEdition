package chapter1_3.Ex35;

import algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomQueue<Item> implements Iterable<Item> {

    private int N;
    private Item[] a = (Item[]) new Object[1];

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        if (N >= 0) System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    public void enqueue(Item item) {
        if (N == a.length)
            resize(a.length * 2);
        a[N++] = item;
    }

    public Item dequeue() {
        Random random = new Random();
        int n = random.nextInt(N);
        Item temp = a[n];
        a[n] = a[--N];
        if (N == a.length / 4) {
            resize(a.length / 2);
        }
        return temp;
    }

    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        Item[] temp;
        private int i = 0;

        public RandomIterator() {
            temp = (Item[]) new Object[N];
            System.arraycopy(a, 0, temp, 0, N);
            StdRandom.shuffle(temp);
        }

        public boolean hasNext() {
            return i != N;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (i == N)
                throw new NoSuchElementException();
            return temp[i++];
        }
    }

    public static void main(String[] args) {
        RandomQueue<Integer> e = new RandomQueue<>();
        for (int i = 1; i < 14; i++) {
            e.enqueue(i);
        }
        for (Integer i : e) {
            System.out.print(i + " ");
        }
        System.out.println();
        int N = e.size();//如果不这样下面输出会少,因为e.size()不断改变
        for (int i = 0; i < N; i++) {
            System.out.print(e.dequeue() + " ");
        }
    }
}
