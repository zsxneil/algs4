package com.my.chapter1_3.exercise;

import com.my.chapter1_3.Queue;
import com.my.chapter1_3.Stack;

/**
 * 一个以栈为目标的队列 1.3.32
 * Created by neil on 2017/10/15.
 */
public class Steque<Item> {
    private Node first; //栈顶
    private Node last;
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
        if (N == 1) last = first;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        if (N == 1) {
            last = first;
        }
        return item;
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        last.next = node;
        last = node;
        N++;
        if (N == 1) {
            first = last;
        }
    }
}
