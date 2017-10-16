package com.my.chapter1_3.exercise;

/**
 * 1.3.31
 * Created by neil on 2017/10/15.
 */
public class DoubleLink<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node{
        Node next;
        Node prev;
        Item item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insertHead(Item item) {
        Node node = new Node();
        node.item = item;
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
        N++;
    }

    public void insertTail(Item item) {
        Node node = new Node();
        node.item = item;
        if (last == null) {
            last = node;
            first = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        N++;
    }

    public Item deleteHead() {
        Item item = first.item;
        Node firstNext = first.next;
        first.next.prev = null;
        first.next = null;
        first = firstNext;
        N--;
        return item;
    }

    public Item deleteTail() {
        Item item = last.item;
        Node lastPrev = last.prev;
        last.prev.next = null;
        last.prev = null;
        last = lastPrev;
        N--;
        return item;
    }

    public void insertBefore(Item item,int index) {
        Node node = first;
        int position = 0;
        while (position != index) {
            node = node.next;
            position++;
        }
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev.next = newNode;
        node.prev = newNode;
        N++;
    }

    public void insertAfter(Item item,int index) {
        Node node = first;
        int position = 0;
        while (position != index) {
            node = node.next;
            position++;
        }
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = node;
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;
        N++;
    }

    public Item delete(int index) {
        Node node = null;
        if (N == 1) {
            N = 0;
            Item item = first.item;
            first = last = null;
            return item;
        }
        if (index > N / 2) {
            Node current = last;
            int position = 0;
            while (position != index) {
                current = current.prev;
                position --;
            }
            node = current;
        } else {
            Node current = first;
            int position = 0;
            while (position != index) {
                current = current.next;
                position ++;
            }
            node = current;
        }
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return node.item;
    }
}
