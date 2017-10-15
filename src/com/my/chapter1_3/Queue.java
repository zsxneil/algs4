package com.my.chapter1_3;

import com.my.util.In;
import com.my.util.StdOut;

import java.util.Iterator;

/**
 * 队列，先进先出
 * Created by neil on 2017/10/14.
 */
public class Queue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;

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
        Queue queue = new Queue();
        In in = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter1_3\\tobe.txt");
        String[] strs = in.readAllStrings();
        for (int i=0;i<strs.length;i++) {
            String item = strs[i].trim();
            if (!item.equals("-")) {
                queue.enqueue(item);
            } else if(!queue.isEmpty()) {
                StdOut.print(queue.dequeue() + " ");
            }
        }
        StdOut.println("(" + queue.size() + " left on queue)");

        //先进先出
        Queue queue1 = new Queue();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        for(Object q : queue1) {
            StdOut.println(q);
        }
    }
}
