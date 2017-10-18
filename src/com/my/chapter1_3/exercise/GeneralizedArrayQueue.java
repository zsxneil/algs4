package com.my.chapter1_3.exercise;

/**1.3.38 数组实现
 *
 * Created by neil on 2017/10/18.
 */
public class GeneralizedArrayQueue<Item> {
    private Item[] a;
    private int N;
    public GeneralizedArrayQueue() {
        a = (Item[]) new Object[1];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item item) {
        if (N == a.length){
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    public Item delete(int k) {
        Item item = a[k-1];
        for(int i=k-1;i<N-1;i++) {
            a[i] = a[i+1];
        }
        N--;
        if (N == a.length/2) {
            resize(a.length/2);
        }
        return  item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for(int i=0;i<N;i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
}
