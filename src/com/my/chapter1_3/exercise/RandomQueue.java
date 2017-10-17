package com.my.chapter1_3.exercise;

import com.my.util.StdOut;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

/**
 * 随机队列 1.3.35
 * Created by neil on 2017/10/16.
 */
public class RandomQueue<Item> implements Iterable<Item> {

    private int N;
    private Item[] a;

    public RandomQueue() {
        N =0;
        a = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for(int i=0;i<a.length;i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Item dequeu() {
        Random random = new Random();
        int randIndex = random.nextInt(N-1);
        Item temp = a[randIndex];
        a[randIndex] = a[N-1];
        a[N-1] = null;
        N--;
        if (N == a.length/4) {
            resize(a.length/2);
        }
        return temp;
    }

    public Item sample() {
        Random random = new Random();
        int randIndex = random.nextInt(N-1);
        return a[randIndex];
    }

    public static void main(String[] args) {
        RandomQueue<Integer> queue = new RandomQueue();
        for(int i=0;i<100;i++) {
            queue.enqueue(i);
        }

        for(int i=0;i<10;i++) {
            StdOut.print(queue.dequeu() + " ");
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private int index;
        private Random random;

        public ListIterator() {
            random = new Random();
            index = 0;
            randomSort();
        }

        private void randomSort() {
            for(int i=0;i<N;i++) {
                int randomIndex = i + random.nextInt(N - i);
                Item temp = a[randomIndex];
                a[randomIndex] = a[i];
                a[i] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return index < N;
        }

        @Override
        public Item next() {
            Item item = a[index ++];
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
