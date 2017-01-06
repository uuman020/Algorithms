import static njupt.yyz.Print.*;
import java.util.*;

public class CompleLeftBrackets {

    public static boolean isOpt(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    public static String doComple(String s){

        LinkedStack<String> val = new LinkedStack<String>();
        LinkedStack<String> opt = new LinkedStack<String>();

        char c;
        for(int i =0; i < s.length(); i++){
            c = s.charAt(i);

            if(Character.isDigit(c)) val.push(String.valueOf(c));
            if(isOpt(c))             opt.push(String.valueOf(c));

            if(c == ')'){
                String s1 = val.pop();
                String s2 = val.pop();
                String op = opt.pop();

                val.push("(" + s2 + op + s1 + ")");
            }
        }

        return val.pop();
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        println(doComple(str));
    }
}
