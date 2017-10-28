package com.my.chapter1_5;

import com.my.util.In;
import com.my.util.StdOut;

/**
 * Union find
 * 构造一个森林（树）
 * 路径压缩算法，find时将所有节点都连接到根节点
 * Created by neil on 2017/10/25.
 */
public class UFQuickUnionPathCompression {
    private int[] id;
    private int count;

    public UFQuickUnionPathCompression(int N){
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
        int pRoot = find(p);
        int qRoot = find(q);

        //如果p和q已经在相同的分量之中则不需要采取任何行动
        if (pRoot == qRoot) return;

        //将p的分量命名为q的分量
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        In in = new In("E:\\web\\idea-workspace\\algs4\\src\\com\\my\\chapter1_5\\mediumUF.txt");
        int[] a = in.readAllInts();
        int N = a[0];
        UFQuickUnionPathCompression uf = new UFQuickUnionPathCompression(N);
        for(int i=1;i<a.length;){
            int p = a[i];
            int q = a[i + 1];
            i += 2;
            if(uf.connected(p,q))
                continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);

        }
        StdOut.println(uf.count() + " components");
    }
}
