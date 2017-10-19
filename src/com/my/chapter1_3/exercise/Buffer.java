package com.my.chapter1_3.exercise;

import com.my.chapter1_3.Queue;

/**
 * Created by neil on 2017/10/19.
 */
public class Buffer {
    private Queue rightQueue;
    private Queue leftQueue;

    public Buffer() {
        rightQueue = new Queue();
        leftQueue = new Queue();
    }

    public int size() {
        return rightQueue.size() + leftQueue.size();
    }

    public void insert(char c) {
        rightQueue.enqueue(c);
    }

    public char delete() {
        return (char) rightQueue.dequeue();
    }

    public void left(int k) {
        int i=0;
        while (i<k) {
            i++;
            rightQueue.enqueue(leftQueue.dequeue());
        }
    }

    public void right(int k) {
        int i=0;
        while (i<k) {
            i++;
            leftQueue.enqueue(rightQueue.dequeue());
        }
    }
}
