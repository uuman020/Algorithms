
public class Quick {
    public static void sort(int[] a){
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi){
        if(hi <= lo)
            return ;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void sort3(int[] a){
        sort3(a, 0, a.length - 1);
    }

    private static void sort3(int[] a, int lo, int hi){
        if(hi <= lo)
            return;
        int lt = lo, gt = hi, i = lo + 1;
        int v = a[lo];
        while(i <= gt){
            if(a[i] < v) Selection.exch(a, lt++, i++);
            else if(a[i] > v) Selection.exch(a, i, gt--);
            else i++;
        }
        sort3(a, lo, lt - 1);
        sort3(a, gt + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi){
        int v = a[lo];
        int i = lo, j = hi + 1;
        while(true){
            while(a[++i] < v) if(i == hi) break;
            while(a[--j] > v) if(j == lo) break;
            if(j <= i)
                break;
            Selection.exch(a, i, j);
        }
        Selection.exch(a, lo, j);
        return j;
    }

    public static void main(String[] args){
        int[] a = Visualize.randArray(47);
        
        /********************
        Visualize.show(a);
        sort(a);
        Visualize.show(a);
        ********************/

        Visualize.show(a);
        sort3(a);
        Visualize.show(a);
    }
}
