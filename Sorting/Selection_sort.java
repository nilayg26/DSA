package JAVA_DSA.Sorting;
import java.util.Scanner;
import java.util.Arrays;
public class Selection_sort {// in selection sort we find the smallest element and place it at the first index
                             // and then we repeat the same process excluding the smallest element, and find the next
                             // smallest element and place it beside the smallest element, Repeat the same process
                             // we get the sorted list.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = str1.substring(1, str1.length() - 1);
        String[] str3 = str2.split(",");
        int[] array = new int[str3.length];
        int count = 0;
        for (String str : str3) {
            int n = Integer.valueOf(str);
            array[count] = n;
            count++;
            
        }
        selection_sort_loop(array,array.length);
        selection_sort_reccursion(array, array.length,0);
        System.out.println(Arrays.toString(array));
    }

    public static int[] selection_sort_reccursion(int[] array, int n,int count) {
        int smallest_value=array[count];
        int index= indexOf(array,smallest_value);
        if(count==n-1){
            return(array);
        }
        for(int i=count+1; i<n;i++){
            if(array[i]<=smallest_value){
                smallest_value=array[i];
                index=i;
            }
        }
         array[index]=array[count];
         array[count]=smallest_value;
         selection_sort_reccursion(array, n,count+1);
         return(array);
        

    }
    public static int[] selection_sort_loop(int[] array, int n) {
        // selection sort = O(n^2)
        int count=0;
        int index=0;
        for(count=0;count<n-1;count++){
             int smallest_value=array[count];
            for(int i=count+1; i<n;i++){
            if(array[i]<=smallest_value){
                smallest_value=array[i];
            }}
            index=indexOf(array,smallest_value);
            array[index]=array[count];
            array[count]=smallest_value;
        }
        return(array);
    }
        public static int indexOf(int[] array, int element) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == element) {
                    return i;
                }
            }
            return -1;
        }
}