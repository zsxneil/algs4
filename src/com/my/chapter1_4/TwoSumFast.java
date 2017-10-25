package com.my.chapter1_4;

import com.my.chapter1_1.BinarySearch;
import com.my.util.In;
import com.my.util.StdOut;

import java.util.Arrays;

/**
 * 找出一个输入文件中所有和为0的整数对的数量。
 * 假设：所有的正数均不相同
 * 简单算法：两边遍历，计算和是否为0.时间为平方级别
 * 快速算法：1，归并排序；2，查找-a[i]是否存在于数组中.时间为NlogN级别
 * Created by neil on 2017/10/23.
 */
public class TwoSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i=0;i<N;i++) {
            if(BinarySearch.rank(-a[i],a) > i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter1_4\\8Kints.txt");
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}
