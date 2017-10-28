package com.my.example.draw;

import com.my.util.StdDraw;
import com.my.util.StdRandom;

/**
 * Created by Administrator on 2017/10/28.
 */
public class Random {
    public static void main(String[] args) {
        int N = 50;
        double[] a = new double[N];
        for (int i=0;i<N;i++){
            a[i] = StdRandom.uniform();
        }
        for (int i=0;i<N;i++){
            double x = 1.0*i/N;
            double y = a[i]/2.0;
            double rw = 0.5/N;
            double rh = a[i]/2.0;
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }
}
