import static njupt.yyz.Print.*;
import java.util.*;

public class Visualize {

    public static int[] randArray(int l){
        Random r = new Random(7);
        int[] a = new int[l];
        for(int i = 0; i < l; i++){
            a[i] = r.nextInt(17) + 1;
        }

        return a;
    }
    public static void show(int[] a){
        int max = getMax(a);
        int len = a.length; 

        for(int i = 0; i < max; i++){
            for(int j = 0; j < len; j++){
                if(max - a[j] <= i)
                    print("*" + " ");
                else
                    print("  ");
            }
            print("\n");
        }
    }

    private static int getMax(int[] a){
        int max = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] > max)
                max = a[i];
        }
        return max;
    }

    public static void main(String[] args){
        int[] a = new int[10];

        for(int i = 0; i < 10; i++){
            a[i] = i + 1;
        }

        show(a);
    }
}
