//Famous problem : 'Tower of Hanoi'
package JAVA_DSA.ReccursionBacktrack;
import java.util.Scanner;
public class TowerOfHanoi {
    public static int count;
    public static void main(String [] args){
        Scanner sc=new Scanner (System.in);
        System.out.println("Tower of Hanoi");
        System.out.println("Enter the value of n (number of rings)");
        int n=sc.nextInt();
        count=0;
        towerOfHanoi(n, 1, 3);
        System.out.println("No. of ways: "+count);
    }
    private static void towerOfHanoi(int n,int start,int end){
        if(n==1){
            printWay(start, end);
            return;
        }
        int other=6-(start+end);
        towerOfHanoi(n-1, start, other);
        printWay(start, end);
        towerOfHanoi(n-1, other ,end);
        return;
    }
    private static void printWay(int start, int end){
        System.out.println(start+" -> "+end);
        count++;
        //this line means moving the top most disk from rod 'start' to rod 'end'
    }
}
