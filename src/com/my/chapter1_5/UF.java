package com.my.chapter1_5;

import com.my.util.In;
import com.my.util.StdOut;

/**
 * Union find
 * Created by neil on 2017/10/25.
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int N){
        //初始化分量id数组
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p,int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return 0;
    }

    public void union(int p,int q) {

    }

    public static void main(String[] args) {
        In in = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter1_5\\tinyUF.txt");
        int[] a = in.readAllInts();
        int N = a[0];
        UF uf = new UF(N);
        for(int i=1;i<a.length;){
            int p = a[i];
            int q = a[i + 1];
            if(uf.connected(p,q))
                continue;
            uf.union(p,q);
            StdOut.println(uf.count() + " components");
            i += 2;
        }
    }
}
