import static njupt.yyz.Print.*;
import java.util.*;

class Node<Item extends Comparable<Item>> {
    Item item;
    Node<Item> next;

    Node(Item item){
        this.item = item;
        this.next = null;
    }

    void appendToTail(Item item){
        Node<Item> x = this;
        while(x.next != null)
            x = x.next;
        x.next = new Node<Item>(item);
    }

    void delTail(){
        assert(this.next != null);
        Node<Item> x = this;
        while(x.next.next != null) x = x.next;
        x.next= null;
    }

    void delete(int k){
        int count = 0;
        if(0 == k) 
            throw new UnsupportedOperationException();   /* need a head node */
        Node<Item> x = this;
        while(x.next != null){
            if(count + 1 == k) break;
            x = x.next;
            count++;
        }
        if(null == x.next)
            throw new NoSuchElementException();
        x.next = x.next.next;
    }

    boolean hasItem(Item item){
        Node<Item> x = this;
        while(null != x){
            if(x.item.equals(item))
                return true;
            x = x.next;
        }
        return false;
    }

    void deleteAfter(Node<Item> node){
        if(this == node)
            throw new UnsupportedOperationException();   /* need a head node */
        Node<Item> x = this;
        while(null != x.next){
            if(x == node){
                break;
            } 
            x = x.next;
        }
        x.next = null;
    }

    void insert(int k, Item item){          /* insert a node after k nodes */
        int count = 0;
        Node<Item> x = this;
        Node<Item> i = new Node<Item>(item);
        while(null != x.next){
            if(k == count){
                break;
            }
            count++;
            x = x.next;
        }
        i.next = x.next;
        x.next = i;
    }

    void remove(Item key){                   /* remove all nodes which has a item equals to key */
        if(this.item.equals(key))
            throw new UnsupportedOperationException();
        Node<Item> x = this;
        Node<Item> y = this.next;
        while(null != y){
            if(y.item.equals(key)){
                x.next = y.next;
            }
            else {
                x = x.next;
            }
            y  = y.next;
        }
    }

    Item max(){                           /* return max value of linkedlist */
        Item max = this.item;
        Node<Item> x = this.next;
        while(null != x){
            if(x.item.compareTo(max) > 0){
                max = x.item;
            }
            x = x.next;
        }
        return max;
    }

    public String toString(){
        Node<Item> x = this;
        String result = "";
        while(x.next != null){
            result += x.item + "->";
            x = x.next;
        }
        result += x.item;
        return result;
    }
}

public class ListTest {
    public static void main(String[] args){
        assert(args.length > 2);
        Node<String> linkedList = new Node<String>(args[0]);

        for(int i = 1; i < args.length; i++){
            linkedList.appendToTail(args[i]);
        }

        Node<Integer> intList = new Node<Integer>(args[0].hashCode());
        for(int i = 0; i < args.length; i++){
            intList.appendToTail(args[i].hashCode());
        }

        /************************
        println(linkedList);
        linkedList.delTail();
        println(linkedList);

        linkedList.delete(2);
        println(linkedList);

        println(linkedList.hasItem(args[2]));
        println(linkedList.hasItem(args[0]));

        Node<String> delNode = linkedList.next.next;
        linkedList.deleteAfter(delNode);
        println(linkedList);

        linkedList.remove("c++");
        println(linkedList);

        linkedList.insert(0, "first");
        linkedList.insert(3, "midde");
        linkedList.insert(10, "last");
        println(linkedList);
        ************************/
        println(intList);
        println(intList.max());
    }
}

