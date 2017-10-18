package com.my.chapter1_3.exercise;

/**
 * 1.3.38 链表实现
 * Created by neil on 2017/10/18.
 */
public class GeneralizedLinkQueue<Item> {
    private int N;
    private Node first;

    private class Node{
        private Item item;
        private Node next;
    }

    public GeneralizedLinkQueue() {
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N ++;
    }

    public Item delete(int k) {
        Node current = first;
        int position = N - k + 1;
        int index = 1;

        while (index != position - 1) {
            current = current.next;
            index ++;
        }
        Node node = current.next;
        Item item = node.item;
        current.next = node.next;
        N--;
        return item;
    }
}
