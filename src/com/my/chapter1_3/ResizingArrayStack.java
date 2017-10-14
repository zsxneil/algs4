package com.my.chapter1_3;

import com.my.util.StdOut;

import java.util.Iterator;

/**
 * 下压栈 动态调整容量大小的实现
 * 并实现迭代接口
 * Created by Administrator on 2017/10/14.
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1];  //栈元素
    private int N;                              //元素数量

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(a.length * 2); //栈满，容量扩大一倍
        }
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null; //防止对象游离,等待gc
        if (N > 0 && N == a.length/4) { //栈大小小于数组长度的四分之一时，容量减半
            resize(a.length/2);
        }
        return item;
    }

    //调整数组大小
    private void resize(int max) {
        //将大小为 N<max的栈移动到一个新的大小为max的数组中
        Item[] temp = (Item[]) new Object[max];
        for( int i=0;i<N;i++) {
            temp[i] = a[i];
        }
        a = temp;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayStack stack = new ResizingArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for(Object i : stack) {
            StdOut.println(i);
        }
    }
}
