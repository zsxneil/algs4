package com.my.chapter1_4;

import com.my.util.StdOut;
import com.my.util.StdRandom;

/**
 * Created by neil on 2017/10/19.
 */
public class DoublingTest {
    public static double timeTerial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i=0;i<N;i++) {
            a[i] = StdRandom.uniform(-MAX,MAX);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for(int N=250;true;N+=N) {
            double time = timeTerial(N);
            StdOut.printf("%7d %5.1f\n",N,time);
        }
    }
}
