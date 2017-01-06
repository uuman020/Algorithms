import static njupt.yyz.Print.*;
import java.util.*;

public class BackwardK {
    public static void main(String[] args){
        LinkedQueue<String> q = new LinkedQueue<String>();
        Scanner s = new Scanner(System.in);
        int count = 0;
        int k = Integer.parseInt(args[0]);

        while(true){
            if(s.nextLine().equals("exit")){
                break;
            }
            q.enqueue(s.nextLine());
            count++;
        }

        assert(count > k);
        int i= 0;
        while(i < count - k){
            q.dequeue();
        }

        println(q.dequeue());
    }
}
