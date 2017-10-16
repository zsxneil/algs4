package com.my.chapter1_3.exercise;

import com.my.util.StdOut;

import java.util.Random;

/**
 * 随机队列 1.3.35
 * Created by neil on 2017/10/16.
 */
public class RandomQueue<Item> {

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
}
