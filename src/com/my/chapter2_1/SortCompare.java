package com.my.chapter2_1;

import com.my.chapter1_4.StopWatch;
import com.my.util.StdOut;
import com.my.util.StdRandom;

/**
 * 比较两种排序算法的性能
 * Created by Administrator on 2017/10/28.
 */
public class SortCompare {
    public static double time(String alg, Double[] a) {
        StopWatch timer = new StopWatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg,int N,int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t=0;t<T;t++) {
            for(int i=0;i<N;i++){
                a[i] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Shell";
        int N = 100000;//长度为N
        int T = 100;//重复T次
        double t1 = timeRandomInput(alg1,N,T);
        double t2 = timeRandomInput(alg2,N,T);
        StdOut.printf("For %d random Doubles\n %s is",N,alg1);
        StdOut.printf(" %.1f times faster than %s\n",t2/t1,alg2);

    }
}
