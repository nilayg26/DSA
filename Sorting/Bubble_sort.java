package JAVA_DSA.Sorting;
import java.util.Scanner;
import java.util.Arrays;
public class Bubble_sort{ //in bubble sort we compare each element of an array of size n
                          // one by one and then and find the largest element and then  
                          //again run the loop n-1 times.  
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        String str1= sc.nextLine();
        String str2= str1.substring(1,str1.length()-1);
        String[] str3= str2.split(",");
        int[] array= new int[str3.length];
        int count=0;
        for(String str:str3){
            int n= Integer.valueOf(str);
            array[count]= n;
            count++; 
        }
        System.out.println(Arrays.toString(bubble_sort_loop(array,array.length)));    
    }
    public static int[] bubble_sort_reccursion(int []array,int n){
        int largest_value = array[0];
        if(n==1){
            return(array);
        }
        for(int i=0; i<n-1;i++){
            if(array[i]>=array[i+1]){
                largest_value=array[i];
                array[i]=array[i+1];
                array[i+1]= largest_value;
                }
            }
        bubble_sort_reccursion(array,n-1);
        return(array);        
    }
    public static int[] bubble_sort_loop (int [] array,int n){
        //bubble sort = O(n^2)
        for(int j=n;j>=1;j--){
            int largest_value= array[0];
            for(int i=0; i<j-1;i++){
                if(array[i]>=array[i+1]){
                    largest_value=array[i];
                    array[i]=array[i+1];
                    array[i+1]= largest_value;
                }
            }
        }
        return(array);
    }    
}
    

