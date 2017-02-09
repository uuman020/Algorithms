import static njupt.yyz.Print.*;
import java.util.*;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxPQ(int cap){
        pq = (Key[]) new Comparable[cap];
        N = 0;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k){
        while(k > 1 && less(k, k / 2)){
            int j = k / 2;
            exch(k, j);
            k = j;
        } 
    }

    private void sink(int k){
        while(k <= N / 2){
            int j = 2 * k;
            if(j < N && less(j, j + 1)) j++;
            if(!less(k, j)) break;
            exch(j, k);
            k = j;
        }
    }

    public Key delMax(){
        Key key = pq[1];
        pq[1] = pq[N];
        pq[N--] = null;  
        sink(1);
        return key;
    }

    public void insert(Key key){
        pq[++N] = key;
        swim(N);
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return 0 == N;
    }
}
