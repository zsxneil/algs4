package com.my.chapter1_3.exercise;

import com.my.util.StdOut;

import java.util.Iterator;

/**
 * 双向队列 1.3.33
 * Created by neil on 2017/10/16.
 */
public class Deque<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;

    public Deque() {
    }



    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {

        if (N==0) {
            Node node = new Node();
            node.item = item;
            first = last = node;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            oldFirst.prev = first;
            first.next = oldFirst;
        }
        N++;
    }

    public void pushRight(Item item) {
        if (N == 0) {
            Node node = new Node();
            node.item = item;
            first = last = node;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.prev = oldLast;
            oldLast.next = last;
        }
        N++;
    }

    public Item popLeft(){
        Node node = first;
        N--;
        if (N == 0) {
            first.next = null;
            last.prev = null;
            first = last = null;
        } else {
            first = node.next;
            first.prev = null;
            node.next = null;
        }
        return node.item;
    }

    public Item popRight(){
        Node node = last;
        N--;
        if (N == 0) {
            first.next = null;
            last.prev = null;
            first = last = null;
        } else {
            last = node.prev;
            last.next = null;
            node.prev = null;
        }
        return node.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {

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
        Deque<Integer> deque = new Deque();
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);

        deque.pushRight(4);
        deque.pushRight(5);
        deque.pushRight(6);

        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
//        deque.popRight();
        StdOut.println(deque.size() + ";");
        for( int i : deque) {
            StdOut.println(i);
        }
    }
}
