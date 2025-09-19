package LabCat;
//Max Sub array sum
import java.util.ArrayList;
import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of array");
        int n=sc.nextInt();
        int arr[]=new int [n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(divideANDconquer(0, n-1, arr, new ArrayList<Integer>()));
    }
    public static int divideANDconquer(int start, int end,int []arr, ArrayList<Integer>result){
        if(start>=end){
            return arr[end]>0? arr[end]:0;
        }
        int mid= (start+end)/2;
        int sum1=divideANDconquer(start,mid, arr, result);
        int sum2=divideANDconquer(mid+1, end, arr, result);
        int sum3=0;
        int maxLeftSum= 0;
        int maxRightSum=0;
        int leftSum=0;
        int rightSum=0;
        for(int i=mid;i>=start;i--){
            leftSum+=arr[i];
            if (leftSum>maxLeftSum) {
                maxLeftSum=leftSum;
            }
        }
        for(int i=mid+1;i<=end;i++){
            rightSum+=arr[i];
            if (rightSum>maxRightSum) {
                maxRightSum=rightSum;
            }
        }
        sum3=maxLeftSum+maxRightSum;
        return Math.max((sum1),Math.max(sum2, sum3));
    }
}
