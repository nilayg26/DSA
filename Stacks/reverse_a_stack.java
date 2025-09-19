package JAVA_DSA.Stacks;
import java.util.Stack;
import java.util.Scanner;

public class reverse_a_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count= sc.nextInt();
        Stack<Integer> s = new Stack<>();
        for (int j =1; j <=count; j++) {
            s.push((sc.nextInt()));
        }
        System.out.println(s);
        Stack <Integer>reverse = reverse(s);
        System.out.println(reverse);
        while(reverse.size()!=0){
            System.out.println(reverse.pop());
        }

    }

    public static Stack<Integer> reverse(Stack<Integer> s){
       Stack<Integer> r= new Stack<>();
       int n;
       while(s.size()!=0){
        n =s.pop();
        r.push(n);
       }
    return(r);
   }
}