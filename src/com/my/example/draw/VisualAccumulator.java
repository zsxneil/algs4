package com.my.example.draw;

import com.my.util.StdDraw;
import com.my.util.StdOut;
import com.my.util.StdRandom;

/**
 * 累加器
 * Created by Administrator on 2017/10/28.
 */
public class VisualAccumulator {
    private double total;
    private int N;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N,val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N,total/N);
    }

    public double mean(){
     return total/N;
    }

    public String toString() {
        return "Mean (" + N + " values): " + String.format("%7.5f",mean());
    }

    public static void main(String[] args) {
        int T = 20000;
        VisualAccumulator a = new VisualAccumulator(T,1.0);
        for(int t=0;t<T;t++) {
            a.addDataValue(StdRandom.uniform());
        }
        StdOut.println(a);
    }
}
