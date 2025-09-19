package JAVA_DSA.Sorting;
import java.util.Scanner;
import java.util.Arrays;
public class Insertion_sort {// in insertion sort we first we divide the array in two different parts, sorted and unsorted;
                             // we select each element and put in the sorted side. this way sorted side gets full and unsorted
                             // side is finished.
                             //           (:
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int []array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void insertionSort(int []array){
        int size=array.length;
        int key=0;
        int j=0;
        for(int i=1;i<size;i++){
            key=array[i];
            j=i-1;
            for(j=i-1;j>=0;j--){
                if(array[j]>=key){
                    array[j+1]=array[j];
                }
                else{
                    break;
                }
            }
            array[j+1]=key;
        }
    }
    public static void insertionSortReccursion(int[]array,int count){
        

    }
    
    
}