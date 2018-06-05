package com.my.chapter2_2;

import com.my.util.In;
import com.my.util.StdOut;

/**
 * 归并排序，递归
 * Created by Administrator on 2017/10/28.
 */
public class Merge {

    private static Comparable[] aux;//辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a,0,a.length - 1);
    }

    private static void sort(Comparable[] a,int lo,int hi) {
        //将数组a[lo..hi]排序
        if (hi<=lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);//左半部分排序
        sort(a,mid +1,hi);//右半部分排序
        merge(a,lo,mid,hi);
    }

    public static void merge(Comparable[] a,int lo, int mid,int hi) {
        int i = lo, j = mid + 1;
        for (int k=lo;k<=hi;k++) {
            aux[k] = a[k];
        }

        for (int k=lo;k<=hi;k++) { //归并到a[lo..hi]
            if (i>mid)                       a[k] = aux[j++];
            else if (j>hi)                  a[k] = aux[i++];
            else if (less(aux[j] ,aux[i]))  a[k] =aux[j++];
            else                            a[k] = aux[i++];
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
        System.out.println(a.length);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
