import static njupt.yyz.Print.*;
import java.util.*;

public class LinkedStack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return 0 == N;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next =oldfirst;
        N++;
    }

    public Item pop(){
        if(null == first){
            throw new NullPointerException();
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        String result = "[";
        Node current;
        for(current = first; current.next != null; current = current.next){
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
            return node != null;
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
        LinkedStack<String> stack = new LinkedStack<String>();

        String token;
        while(true){
            token = s.nextLine();
            if(token.equals("exit")){
                break;
            }
            if(token.equals("-")){
                stack.pop();
            }
            else{
                stack.push(token);
            }
            println(stack);
        }

        for(String str : stack){
            print(str + " ");
        }
    }
}
