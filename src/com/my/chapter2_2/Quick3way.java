package com.my.chapter2_2;

import com.my.util.In;
import com.my.util.StdOut;
import com.my.util.StdRandom;

/**
 * 三向切分的快速排序
 * Created by Administrator on 2017/10/28.
 */
public class Quick3way {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);//消除对输入的依赖，避免最坏的情况
        sort(a,0,a.length-1);
        
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i=lo+1, gt = hi;
        Comparable v = a[lo];
        while (i<=gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a,lt++,i++);
            else if (cmp > 0) exch(a,i,gt--);
            else i++;
        }//现在a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
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
