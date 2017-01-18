import njupt.yyz.Print.*;

public class Merge {
    private static int[] aux;

    public static void sortTD(int[] a){
        aux = new int[a.length];
        sortTD(a, 0, a.length - 1);
    }

    private static void sortTD(int[] a, int lo, int hi){
        if(hi == lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sortTD(a, lo, mid);
        sortTD(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi){
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo, j = mid +1;
        for(int k = lo; k <= hi; k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void sortBU(int[] a){
        aux = new int[a.length];
        int len= a.length;
        for(int as = 1; as < len; as = as + as){
            for(int lo = 0; lo < len - as; lo += as + as){
                merge(a, lo, lo + as- 1, min(lo + 2 * as - 1, len - 1));
            }
        }
    }

    private static int min(int a, int b){
        return a > b ? b : a;
    }

    public static void main(String[] args){
        int[] a = Visualize.randArray(47);
        /***********************
        Visualize.show(a);
        sortTD(a);
        Visualize.show(a);
        ***********************/
        Visualize.show(a);
        sortBU(a);
        Visualize.show(a);
    }
}
