import static njupt.yyz.Print.*;
import java.util.*;

public class ArrayStack<Item> implements Iterable<Item>{

    Item[] a;
    int N;

    public ArrayStack(int cap){
        a = (Item[]) new Object[cap];
        N = 0;
    }

    public boolean isEmpty(){
        return 0 == N;
    }

    public int size(){
        return N;
    }

    private void resize(int cap){
        Item[] b = (Item[]) new Object[cap];
        for(int i = 0; i < N; i++){
            b[i] = a[i];
        }
        a = b;
    } 

    public void push(Item item){
        if(a.length == N){
            resize(2 * a.length);
        }
        a[N++] = item;
        print(a.length + " ");
    }

    public Item pop(){
        if(0 == N){
            throw new NoSuchElementException();
        }
        Item item = a[--N];
        a[N] = null;
        if(N > 0 && a.length / 4 == N){
            resize(a.length / 2);
        }
        print(a.length + " ");
        return item;
    }

    public String toString(){
        String result = "[";
        if(0 == N){
            return result + "]";
        }
        for(int i = 0; i < N - 1; i++){
            result += a[i] + ",";
        }
        result += a[N - 1] + "]";
        return result;
    }
    
    public Iterator<Item> iterator(){
        return new ArrayIterator(); 
    }

    private class ArrayIterator implements Iterator<Item>{
        private int current;

        public ArrayIterator(){
            current = N;
        }

        public boolean hasNext(){
            return current > 0;
        }

        public Item next(){
            if(0 == current){
                throw new NoSuchElementException();
            }
            return a[--current];
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayStack<String> stack = new ArrayStack<String>(1);
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
