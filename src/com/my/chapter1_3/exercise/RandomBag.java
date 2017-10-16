package com.my.chapter1_3.exercise;

import com.my.util.StdOut;

import java.util.Iterator;
import java.util.Random;

/**
 * 随机背包 1.3.34
 * Created by neil on 2017/10/16.
 */
public class RandomBag<Item> implements Iterable<Item>{
    private Item[] a;
    private int N;

    public RandomBag() {
        a = (Item[]) new Object[1];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (N == a.length ) {
            resize(2*a.length);
        }
        a[N++] = item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i=0;i<N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }


    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator ();
    }

    private class RandomBagIterator  implements Iterator<Item> {

        private int i = 0;
        private Random random = new Random();

        public RandomBagIterator() {
            randowSort();
        }

        private void randowSort() {
            for(int i=0;i<N;i++) {
                int randomIndex = i + random.nextInt(N - i);
                Item item = a[i];
                a[i] = a[randomIndex];
                a[randomIndex] = item;
            }
        }

        @Override
        public boolean hasNext() {
            return i<N;
        }

        @Override
        public Item next() {

            return a[i++];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        for(int i=0;i<10; i++) {
            randomBag.add(i);
        }

        for (int item: randomBag) {
            StdOut.print(item + " ");
        }
    }
}
