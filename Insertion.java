
public class Insertion {
    public static void sort(int[] a){
        int len = a.length;
        for(int i = 1; i < len; i++){
            for(int j = i; j > 0; j--){
                if(a[j] >= a[j - 1])
                    break;
                Selection.exch(a, j, j - 1);
            } 

            Visualize.show(a);
        }
    }

    public static void newSort(int[] a){
        int len = a.length;
        for(int i = 1; i < len; i++){
            int t = a[i];
            for(int j = i; j >= 0; j--){
                if(j == 0 || t >= a[j - 1]){
                    a[j] = t;
                    break;
                }
                a[j] = a[j - 1];
            }
            Visualize.show(a);
        }
    }

    public static void main(String[] args){
        int[] a = Visualize.randArray(23);
        //sort(a);
        newSort(a);
    }
}
