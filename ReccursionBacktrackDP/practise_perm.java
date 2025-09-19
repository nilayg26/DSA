package JAVA_DSA.ReccursionBacktrack;
import java.util.Scanner;
public class practise_perm {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str= sc.next();
        permutate(str , "");
        System.out.println("Total no: of permutation: "+factorial(str.length()));
    }
    public static int factorial(int len)
    {
        if(len==1){
            return 1;
        }
        else{
            return len*factorial(len-1);
        }

    }
    public static void permutate(String str, String perm){
        int i;
        if(str.length()==0){
            System.out.println(perm);
        
        }
        else{
        for(i=0; i<str.length(); i++){
            String s= str.substring(i,i+1);
            String p= str.substring(0,i)+str.substring(i+1,str.length());
            permutate(p, perm+s);
        }}

    }  
    
}

