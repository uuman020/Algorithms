import static njupt.yyz.Print.*;
import java.util.*;

public class ArrayQueue<Item> implements Iterable<Item> {
    
    private int first;
    private int last;
    private Item[] a;
    private int N;

    public ArrayQueue(int cap){
        a = (Item[]) new Object[cap];
        N = first = last = 0;
    }

    private boolean isFull(){
        return a.length == N;
    }

    private void resize(int cap){
        Item[] b = (Item[]) new Object[cap];
        for(int i = 0; i < N; i++){
            b[i] = a[first++];
            first %= a.length;
        }
        a = b;
        first = 0;
        last = N;
    }

    public boolean isEmpty(){
        return 0 == N;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        if(isFull()){
            resize(2 * a.length);
        }
        if(last == a.length){
            last = 0;
        }
        a[last++] = item;
        N++;
    }

    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(N > 0 && N == a.length / 4){
            resize(a.length / 2);
        }
        if(a.length == first){
            first = 0;
        }
        Item item = a[first];
        a[first++] = null;
        N--;
        return item;
    }

    public String toString(){
        String result = "[";
        if(isEmpty()){
            return result + "]";
        }
        for(int i = 0; i < a.length - 1; i++){
            result += a[i] + ",";
        }
        result += a[a.length - 1] + "]" + " first is " + first + " last is " + last;
        return result;
    }

    public Iterator<Item> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int current = first;
        private int num = N;
        
        public boolean hasNext(){
            return num == 0;
        }

        public Item next(){
            if(0 == num){
                throw new NoSuchElementException();
            }
            if(a.length == current){
                current = 0;
            }
            num--;
            return a[current++];
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayQueue<String> q = new ArrayQueue<String>(1);
        String token;

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
    }
}
