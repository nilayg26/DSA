package JAVA_DSA.ReccursionBacktrack;
import java.util.Arrays;
import java.util.Scanner;
public class LengthOfConnectedCells{
    public static void main(String [] args){
        Scanner sc= new Scanner (System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int [][] matrix = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
    public static int countConnectingCells(int [][]matrix,int row,int col,int count){
        
    }