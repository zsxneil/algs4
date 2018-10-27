package com.my.chapter3_2;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root; //二叉查找树的根结点

    private class Node {
        private Key key;    //键
        private Value val;  //值
        private Node left, right; //指向子树的链接
        private int N;  //以该结点为根的子树中的结点总数

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.N = n;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        //在以x为根结点的子树中查找并返回key所对应的值
        //如果找不到则返回null
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        }
        else if (cmp > 0) {
            return get(x.right, key);
        }
        else return x.val;
    }

    public void put(Key key, Value val) {
        //查找key，找到则更新它的值，否则为它创建一个新的结点
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        //如果key存在于以x为根结点的子树中则更新它的值
        //否则，将以key和val为键值对的新结点插入到该子树中
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else x.val = val;
        x.N = size(x.left ) + size(x.right) + 1;
        return x;
    }

}
