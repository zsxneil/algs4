package com.my.chapter2_1;

import com.my.util.In;
import com.my.util.StdOut;

/**
 * 插入排序，升序排序
 * Created by Administrator on 2017/10/28.
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i=0;i<N;i++) {
            for (int j=i;j>0;j--) {
                if (less(a[j],a[j-1]))//如果a[j]<a[j-1]则交换
                    exch(a,j,j-1);
            }
        }
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
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
