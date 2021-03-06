package com.my.chapter1_3;

import com.my.util.In;
import com.my.util.StdOut;

import java.util.Iterator;

/**
 * 栈的链表实现
 * Created by Administrator on 2017/10/14.
 */
public class Stack<Item> implements Iterable<Item>{
    private Node first; //栈顶
    private int N;      //元素数量

    private class Node{
        //定义了结点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    //返回最近添加的元素，而不弹出栈
    public Item peek() {
        if (first != null) {
            return first.item;
        }
        return null;
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
        Stack s = new Stack();
        In in = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter1_3\\tobe.txt");
        String[] strs = in.readAllStrings();
        for (int i=0;i<strs.length;i++) {
            String item = strs[i].trim();
            if (!item.equals("-")) {
                s.push(item);
            } else if(!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");

        //后进先出
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for(Object i : stack) {
            StdOut.println(i);
        }
    }
}
