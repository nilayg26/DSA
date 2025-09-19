package JAVA_DSA.Stacks;
import java.util.Stack;
import java.util.Scanner;
public class stacks_add_bottom {
    public static void main(String [] args){
        Stack<Integer> s= new Stack<>();
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++) {
            s.push(sc.nextInt());
        }
        System.out.println(s);
        s= add_bottom(s);
        while(s.empty()==false){
            System.out.println(s.pop());
        }
    }
    public static Stack<Integer> add_bottom(Stack<Integer> s){
        if(s.size()==0){
            Scanner sc= new Scanner (System.in);
            s.push(sc.nextInt());
            return(s);
        }
        int a= s.pop();
        add_bottom(s);
        s.push(a);
        return(s);
    }

    
}
