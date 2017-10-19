package com.my.chapter1_4;

/**
 * Created by neil on 2017/10/19.
 */
public class StopWatch {
    private final long start;
    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
