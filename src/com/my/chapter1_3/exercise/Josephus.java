package com.my.chapter1_3.exercise;

import com.my.chapter1_3.Queue;
import com.my.util.StdOut;

/**
 * Created by neil on 2017/10/18.
 */
public class Josephus {
    public static void main(String[] args) {
        int n = 7;
        int m = 2;
        Queue<Integer> queue = new Queue();
        for(int i=0;i<n;i++) { //先把所有人加入队列
            queue.enqueue(i);
        }

        //从队尾出列并计数，如果不是第M个r就重新从队头入列
        int  index = 0;
        while (queue.size() != 1) {
            Integer item = queue.dequeue();
            index ++;
            if (index == m) {
                index = 0;
                StdOut.print(item + " ");
            } else {
                queue.enqueue(item);
            }
        }
        StdOut.println();
        Integer last = queue.dequeue();
        StdOut.print(last);
    }
}
