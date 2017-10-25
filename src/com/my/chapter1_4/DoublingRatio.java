package com.my.chapter1_4;

import com.my.util.StdOut;
import com.my.util.StdRandom;

/**
 * 倍率试验
 * Created by neil on 2017/10/19.
 250     0.0   0.3
 500     0.0   2.0
 1000     0.1   4.2
 2000     0.2   3.1
 4000     1.1   4.9
 8000     3.9   3.5
 16000    15.2   3.9
 32000    65.2   4.3
 64000   277.4   4.3
 128000  1179.1   4.2
 */
public class DoublingRatio {
    public static double timeTerial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i=0;i<N;i++) {
            a[i] = StdRandom.uniform(-MAX,MAX);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSumFast.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTerial(125);
        for(int N=250;true;N+=N) {
            double time = timeTerial(N);
            StdOut.printf("%6d %7.1f ",N,time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
