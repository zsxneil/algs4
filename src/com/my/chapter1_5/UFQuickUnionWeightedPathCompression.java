package com.my.chapter1_5;

import com.my.util.In;
import com.my.util.StdOut;

/**
 * 加权的quick-union算法，总是让小树连接到大树
 * 路径压缩算法，find时将所有节点都连接到根节点
 * Created by Administrator on 2017/10/28.
 */
public class UFQuickUnionWeightedPathCompression {
    private int[] id;//父链接数组(由触点索引)
    private int[] sz;//(由触点索引的)各个根节点所对应的分量的大小
    private int count;

    public UFQuickUnionWeightedPathCompression(int N){
        //初始化分量id数组
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i=0;i<N;i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p,int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        int root = p;
        while (root !=id[root]) {
            root = id[root];
        }
        while (p != root) {
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }

    public void union(int p,int q) {
        //将p和q归并到相同的分量中
        int i = find(p);
        int j = find(q);

        //如果p和q已经在相同的分量之中则不需要采取任何行动
        if (i == j) return;

        //将小树的根节点连接到大树的根节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        In in = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter1_5\\largeUF.txt");
        int[] a = in.readAllInts();
        int N = a[0];
        StdOut.println(a.length);
        UFQuickUnion uf = new UFQuickUnion(N);
        for(int i=1;i<a.length;){
            int p = a[i];
            int q = a[i + 1];
            i += 2;
            if(uf.connected(p,q))
                continue;
            uf.union(p,q);
            //StdOut.println(p + " " + q);

        }
        StdOut.println(uf.count() + " components");
    }

}
