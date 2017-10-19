package com.my.chapter1_3.exercise;

import com.my.util.In;
import com.my.util.StdOut;

import java.util.Iterator;

/**
 * 栈的链表实现
 * 复制堆栈 1.3.42
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

    public Stack() {
    }

    public Stack(Stack<Item> stack) {
        Stack<Item> temp = new Stack();
        int stackSize = stack.size();
        while (temp.size()<stackSize) {
            Item item = stack.pop();
            temp.push(item);
        }
        while (temp.size() > 0) {
            Item item = temp.pop();
            this.push(item);
            stack.push(item);
        }
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
        //后进先出
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Stack copyStack = new Stack(stack);
        stack.push(4);
        copyStack.push(5);
        for(Object i : stack) {
            StdOut.println(i);
        }
        for(Object i : copyStack) {
            StdOut.println(i);
        }

    }
}
