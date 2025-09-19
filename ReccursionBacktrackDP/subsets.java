package JAVA_DSA.ReccursionBacktrack;
//This programme prints all the subsets of the n natural numbers
import java.util.ArrayList;
import java.util.Scanner;

public class subsets{
    public static void main(String [] args){
        System.out.println("Enter n: ");
        Scanner sc = new Scanner (System.in);
        int n= sc.nextInt();
        ArrayList<ArrayList<Integer>> allset= new ArrayList<>();
        ArrayList<Integer> subset= new ArrayList<>();
        for(int i=1; i<=n;i++){
            subset.add((i-1),i);
        }
        count(subset,allset,n);
        System.out.println(allset);
    }
    public static void count(ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> allset,int n){
        System.out.println(subset);
        check_add(allset,subset);
        if(n==1){
            return;
        }
        else{
            for(int i=n;i>=1;i--){
                int a= subset.remove(i-1);
                count(subset,allset,n-1);
                subset.add(i-1,a);
            }}
    }
    public static void check_add(ArrayList<ArrayList<Integer>> allset,ArrayList<Integer> subset){
        ArrayList<Integer> acces;
        for(int j=0; j<allset.size(); j++){
            acces= allset.get(j);
          if(acces==subset && acces.size()== subset.size()){
            return;
          }
          }
        ArrayList<Integer> check = subset;
        allset.add(check);

         return;
        }
}

