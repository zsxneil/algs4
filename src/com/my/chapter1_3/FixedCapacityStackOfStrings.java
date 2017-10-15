package com.my.chapter1_3;

import com.my.util.In;
import com.my.util.StdOut;

import java.util.Arrays;

/**
 * 定容栈
 * Created by Administrator on 2017/10/14.
 */
public class FixedCapacityStackOfStrings {
    private String[] a; //stack entries
    private int N;      //size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
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
    }
}
