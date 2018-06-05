package com.my.chapter2_2;

import com.my.util.In;
import com.my.util.StdOut;
import com.my.util.StdRandom;

/**
 * 快速排序
 * Created by Administrator on 2017/10/28.
 */
public class Quick {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);//消除对输入的依赖，避免最坏的情况
        sort(a,0,a.length-1);
        
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j + 1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        //将数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while (true) {
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i],v))
                if (i==hi) break;
            while (less(v,a[--j]))
                if (j==lo) break;
            if (i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }


    private static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for(int i=0;i<a.length;i++) {
            if (less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        In in = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter2_1\\tiny.txt");
        String[] a = in.readAllStrings();
        System.out.println(a.length);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
