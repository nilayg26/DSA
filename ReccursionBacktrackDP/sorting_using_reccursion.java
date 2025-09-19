package JAVA_DSA.ReccursionBacktrack;
import java.util.ArrayList;
import java.util.Scanner;
public class sorting_using_reccursion{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string1= sc.nextLine();
        String string2= string1.substring(1,string1.length()-1);
        String [] arraystring= string2.split(",");
        ArrayList<Integer> List= new ArrayList<>();
        for(String str: arraystring){ //new learning
            int i= Integer.valueOf(str);
            List.add(i);
        }
        int n= List.size();
      System.out.println("Initial List: "+List);
      ArrayList<Integer> sort=new ArrayList<>();
      System.out.println("Sorted List: "+sorting(List, sort,n));
    }
    public static ArrayList<Integer> sorting(ArrayList<Integer> List,ArrayList<Integer> sort,int n){
        int i;
        int index=0;
        int smallest_value=List.get(0); 
        if(n==1){
            sort.add(List.get(0));
            List.remove(0);
            return(sort);

        }
        for(i=1; i<n; i++){           
            if(smallest_value>=List.get(i)){
                smallest_value=List.get(i); 
                index=i;
            }
        }
        List.remove(index);
        sort.add(smallest_value);
        sorting(List,sort,(n-1));
        return(sort);
    }
}
