// You are using Java
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class Solution {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        QuickSort q = new QuickSort(arr);
        q.sort();
        for(int i : arr)
            System.out.println(i);

        System.out.println(arr[k - 1]);
    }
}

class QuickSort {
    int []arr;

    QuickSort(int []arr){
        this.arr = arr;
    }

    private int partition(int start, int end){
        Random rand = new Random();
        int num = rand.nextInt((end - start + 1)) + start;
        int val = arr[num];
        arr[num] = arr[end];
        arr[end] = val;
        int j = start - 1;
        for(int i = start; i < end; i++){
            if(arr[i] < val){
                j++;
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        j++;
        arr[end] = arr[j];
        arr[j] = val;
        return j;
    }

    private void qSort(int start, int end){
        if(start >= end){
            return;
        }
        int piDx = partition(start, end);
        qSort(start, piDx - 1);
        qSort(piDx + 1, end);
    }

    public void sort(){
        qSort(0, arr.length - 1);
    }
}
