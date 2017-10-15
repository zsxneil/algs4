package com.my.chapter1_3.exercise;

import com.my.chapter1_3.Stack;
import com.my.util.StdOut;

/**
 * 计算一个正整数的二进制表示
 * Created by neil on 2017/10/14.
 */
public class BinaryPrint {
    public static void main(String[] args) {
        int n = 3;
        printBinaryOfInteger(n);
    }
    public static void printBinaryOfInteger(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n%2);
            n = n / 2;
        }
        for(int d : stack) {
            StdOut.print(d);
        }
        StdOut.println();
    }
}
