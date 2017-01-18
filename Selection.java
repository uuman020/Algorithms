import java.util.*;

public class Selection {
    public static void sort(int[] a){
        int len = a.length;
        for(int i = 0; i < len; i++){
            int min = i;
            for(int j = i + 1; j < len; j++){
                if(less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
            Visualize.show(a);
        }
    }

    public static void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(int a, int b){
        return  a < b;
    }

    public static void main(String[] args){
        int[] a = Visualize.randArray(23);
        sort(a);
    }
}
