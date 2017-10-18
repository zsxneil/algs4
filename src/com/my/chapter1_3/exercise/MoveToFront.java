package com.my.chapter1_3.exercise;

import com.my.util.StdOut;

import java.util.Iterator;

/**
 * 前移编码策略
 * 当遇到一个从未见过的字符时将它插入表头，当遇到一个重复的字符时，将它从链表中删除，并再次插入表头
 * Created by neil on 2017/10/18.
 */
public class MoveToFront<Item> implements Iterable<Item> {
    private int N;
    private Node first;

    private class Node{
        private Item item;
        private Node next;
        private Node prev;
    }

    public void moveToFront(Item item) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                if (current.prev != null)
                    current.prev.next = current.next;
                if (current.next != null)
                    current.next.prev = current.prev;
                N--;
                break;
            }
            current = current.next;
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst != null)
            oldFirst.prev = first;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < N;
        }

        @Override
        public Item next() {
            if (current != null) {
                Item item = current.item;
                index ++;
                current = current.next;
                return item;
            }
            return null;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        MoveToFront<String> moveToFront = new MoveToFront();
        String[] strs = {"a","b","c","b","c","a"};
        for(int i = 0; i<strs.length;i++) {
            moveToFront.moveToFront(strs[i]);
        }

        for(String str : moveToFront) {
            StdOut.print(str);
        }
    }
}
