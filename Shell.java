
public class Shell {
    public static void sort(int[] a){
        int h = 1;
        int len = a.length;

        while(h < len)
            h = 3 * h + 1;  /* 1, 4, 13, 41... */

        while(h >= 1){
            for(int i = h; i < len; i++){
                for(int j = i; j >= h; j -= h){
                    if(a[j - h] <= a[j])
                        break;
                    Selection.exch(a, j, j - h);
                }
            }
            Visualize.show(a);
            h = h / 3;
        }
    }

    public static void main(String[] args){
        int[] a = Visualize.randArray(53);
        sort(a);
    }
}
