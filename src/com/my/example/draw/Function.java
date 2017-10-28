package com.my.example.draw;

import com.my.util.StdDraw;

/**
 * Created by Administrator on 2017/10/28.
 */
public class Function {
    public static void main(String[] args) {
        int N = 1000;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0,N*N);
        StdDraw.setPenRadius(.01);
        for(int i=0;i<N;i++){
            StdDraw.point(i,i);
            StdDraw.point(i,i*i);
            StdDraw.point(i,i*Math.log(i));
        }
    }
}
