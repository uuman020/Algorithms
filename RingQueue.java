import static njupt.yyz.Print.*;
import java.util.*;

public class RingQueue<Item> {
    private Node last;
    int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return null == last;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if(null == oldlast) last.next = last;
        else {
            last.next = oldlast.next;
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue(){
        if(isEmpty()) 
            throw new NoSuchElementException();
        Item item = last.next.item;
        if(1 == N) last = null;
        else last.next = last.next.next;
        N--;
        return item;
    }

    public String toString(){
        String result = "";
        if(isEmpty()) return result;
        Node cur = last.next;
        while(cur != last){
            result += cur.item + "->";
            cur = cur.next;
        }
        result += cur.item;
        return result;
    }

    public static void main(String[] args){
        RingQueue<String> rq = new RingQueue<String>();
        Scanner s = new Scanner(System.in);

        String token;
        while(true){
            token = s.nextLine();
            if(token.equals("exit"))
                break;
            if(token.equals("-"))
                rq.dequeue();
            else
                rq.enqueue(token);

            println(rq);
        }
    }
}
