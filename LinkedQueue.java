import static njupt.yyz.Print.*;
import java.util.*;

public class LinkedQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return null == first;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if(null == oldlast){
            first = last;
        }
        else {
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue(){
        if(isEmpty()){
            throw new NullPointerException();
        }
        Item a = first.item;
        first = first.next;
        if(null == first){
            last = null;
        }
        N--;
        return a;
    }

    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        String result = "[";
        Node current = first;
        for(; current.next != null; current = current.next){
            result += current.item + "->";
        }
        result += current.item + "]";
        return result;
    }

    public Iterator<Item> iterator(){
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node node = first;

        public boolean hasNext(){
            return null != node;
        }

        public Item next(){
            Item a = node.item;
            node = node.next;
            return a;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        LinkedQueue<String> q = new LinkedQueue<String>();

        String token = null;
        while(true){
            token = s.nextLine();
            if(token.equals("exit")){
                break;
            }
            if(token.equals("-")){
                q.dequeue();
            }
            else{
                q.enqueue(token);
            }
            println(q);
        }
        for(String str : q){
            print(str + " ");
        }
    }
}
