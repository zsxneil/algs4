package com.my.chapter1_3.exercise;

import com.my.util.In;
import com.my.util.StdOut;

import java.util.Iterator;

/**
 * 队列，先进先出
 * 复制队列 1.3.41
 * Created by neil on 2017/10/14.
 */
public class Queue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;

    public Queue(Queue<Item> queue) {
        N = 0;
        int queueSize =queue.size();
        while (N < queueSize) {
            Item item = queue.dequeue();
            this.enqueue(item);
            queue.enqueue(item);
        }
    }
    public Queue() {}

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
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

        }
    }

    public static void main(String[] args) {
        //先进先出
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Queue copyQueue = new Queue(queue);
        queue.enqueue(4);
        copyQueue.enqueue(5);
        for(Object q : queue) {
            StdOut.println(q);
        }
        StdOut.println("**********************");
        for(Object q: copyQueue) {
            StdOut.println(q);
        }
    }
}
