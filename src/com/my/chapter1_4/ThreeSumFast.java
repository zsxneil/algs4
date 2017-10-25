package com.my.chapter1_4;

import com.my.chapter1_1.BinarySearch;
import com.my.util.In;
import com.my.util.StdOut;

import java.util.Arrays;

/**
 * ThreeSum的快速算法：时间为N^2logN
 * Created by neil on 2017/10/23.
 */
public class ThreeSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                if(BinarySearch.rank(-(a[i] + a[j]),a) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter1_4\\4Kints.txt");
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}
