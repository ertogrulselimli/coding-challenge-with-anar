import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Ertogrul Selimli on 1/8/2022
 * @project IntelliJ IDEA
 */
public class TogrulSolution {

    public String solution(final String s){
        int []a =new int[126];
        a[')']='(';
        a['}']='{';
        a[']']='[';
        Stack<Character> stack=new Stack<>();
        boolean result=true;
        for(int i=0;i<s.length();i++){
            try{
                if(s.charAt(i)==')' || s.charAt(i)=='}' || s.charAt(i)==']'){
                    final char peek = stack.peek();
                    if(peek==a[s.charAt(i)]){
                        stack.pop();
                    }else{
                        result=false;
                        break;
                    }
                }else{
                    stack.push(s.charAt(i));
                }}catch (EmptyStackException ex){
                result=false;
                break;
            }
        }
        if(stack.isEmpty() && result){
            return "valid";
        }else{
           return "invalid";
        }
    }
}
