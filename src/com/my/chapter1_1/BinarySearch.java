package com.my.chapter1_1;

import com.my.util.In;
import com.my.util.StdIn;
import com.my.util.StdOut;

import java.util.Arrays;

/**
 * Created by neil on 2017/10/8.
 *@command java BinarySearch tinyW.txt < tinyT.txt
 *  完整命令： java com.my.chapter1_1.BinarySearch com\my\chapter1_1\tinyW.txt < com\my\chapter1_1\tinyT.txt
 * 网络链接：http://algs4.cs.princeton.edu/11model/BinarySearch.java.html
 * 上述网址有程序所用到的文件的地址
 *
 * 已修改为直接在程序中读取文件，不用使用cmd窗口了
 */
public class BinarySearch {

    /**
     * 二分法查找
     *
     * @param key 整数键
     * @param a int数组
     * @return
     */
    public static int rank(int key, int[] a) {
        //数组必须是有序的，二分查找算法有才意义
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            //被查找的键要么不存在，要么存在于a[lo .. hi]中
            int mid = lo +(hi - lo) / 2; //从中间开始查找，随着循环，不断缩小范围
            if (key < a[mid]) {        //小于中间的值，则从左半边开始查找
                hi = mid - 1;
            } else if (key > a[mid]) { //大于中间的值，则从右半边开始查找
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        In in = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter1_1\\tinyW.txt");
        int[] whiteList = in.readAllInts();
        Arrays.sort(whiteList);

        In keyIn = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter1_1\\tinyT.txt");
        int[] keyList = keyIn.readAllInts();
        if(keyList != null) {
            for(int key : keyList) {
                if (rank(key,whiteList) < 0) {
                    StdOut.println(key);
                }
            }
        }

    }
}
