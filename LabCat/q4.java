package LabCat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//increasing & decreasing order
public class q4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of array");
        int n=sc.nextInt();
        int arr[]=new int [n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(divideANDconquer(0, n-1, arr, new ArrayList<Integer>())));
    }
    public static int[] divideANDconquer(int start, int end,int []arr, ArrayList<Integer>result){
        if(start>=end){
            return new int []{start,start};
        }
        int mid= start + (end-start)/2;
        int []order1=divideANDconquer(start,mid, arr, result);
        int []order2=divideANDconquer(mid+1, end, arr, result);
        int order3[]=new int[2];
        int leftPeakIndex = mid;
        int rightPeakIndex = mid;
    while (leftPeakIndex > start && arr[leftPeakIndex - 1] < arr[leftPeakIndex]) {
        leftPeakIndex--;
    }
    while (rightPeakIndex < end && arr[rightPeakIndex + 1] < arr[rightPeakIndex]) {
        rightPeakIndex++;
    }
        order3[0]=leftPeakIndex;
        order3[1]=rightPeakIndex;
        if (order3[1]-order3[0]>=Math.max(order1[1]-order1[0],order2[1] - order2[0])) {
            return order3;
        }
        else if(order2[1]-order2[0]>=Math.max(order1[1]-order1[0],order3[1] - order3[0])){
            return order2;
        }
        else{
            return order1;
        }
    }
}
