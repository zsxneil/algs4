package com.my.chapter1_3;

/**
 * 定容栈，泛型
 * Created by Administrator on 2017/10/14.
 */
public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        return item;
    }


}
