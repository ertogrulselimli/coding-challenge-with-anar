import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * @author Ertogrul Selimli on 1/6/2022
 * @project IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {

        List<TestCase> testCases=new ArrayList<>();
        testCases.add(new TestCase("((((((((","invalid",""));
        testCases.add(new TestCase("()[][]{}","valid",""));
        testCases.add(new TestCase("[){](]}[","invalid",""));
        testCases.add(new TestCase("()()(((())))[][][[[[]]]]{{(([]))}}","valid",""));

        System.out.println("************Anar Solution ************************");
        boolean congrat=true;
        AnarSolution anarSolution=new AnarSolution();
        for(TestCase t:testCases){
            final String s = anarSolution.testBrackets(t.input);
            t.output=s;
            System.out.printf("\ninput:%s output: %s expected output: %s",t.input,t.output,t.expectedOutput);
            if(!t.output.equals(t.expectedOutput)){
                congrat=false;
            }
        }
        String anarMessage=congrat?"Congratulations Anar":"Shame on you Anar";
        System.out.println("\n"+anarMessage);


        TogrulSolution togrulSolution=new TogrulSolution();

        for(TestCase t:testCases){
            final String s = togrulSolution.solution(t.input);
            t.output=s;
            System.out.printf("\ninput:%s output: %s expected output: %s",t.input,t.output,t.expectedOutput);
            if(!t.output.equals(t.expectedOutput)){
                congrat=false;
            }
        }

        String togrulMessage=congrat?"Congratulations Togrul":"Shame on you Togrul";
        System.out.println("\n"+togrulMessage);


    }
}
