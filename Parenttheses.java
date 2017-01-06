import static njupt.yyz.Print.*;
import java.util.*;

public class Parenttheses {
    public static boolean isBlance(String s){

        LinkedStack<Character> stack = new LinkedStack<Character>();
        char c;

        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if(c == ')'){
                if(stack.isEmpty()) return false;
                if(stack.pop() != '(') return false;
            }
            if(c == ']'){
                if(stack.isEmpty()) return false;
                if(stack.pop() != '[') return false;
            }
            if(c == '}'){
                if(stack.isEmpty()) return false;
                if(stack.pop() != '{') return false;
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();
        
        println(isBlance(s));
    }
}
