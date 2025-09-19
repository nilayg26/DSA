package LabCat;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixMultiplication {
    static int []r={5,4,6,2,7}; 
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=r.length-1;
        int[][]matrix= new int [n+1][n+1];
        calculate(matrix, n); 
        System.out.println("Minimum cost is: "+matrix[1][n]);
    }
    private static void calculate(int [][]matrix,int n){ //O(n^3)
        int [][]trace = new int[n+1][n+1];
        for(int l=2;l<=n;l++){ //Length of one chain
            for(int i=1;i<=n-l+1;i++){ //No. of pairs of chain of length l
                int j= i+l-1; //ending point of each chain
                matrix[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){ // Calculating Ai..Ak..Aj
                    int cost= matrix[i][k]+matrix[k+1][j] + (r[i-1]*r[k]*r[j]);
                    if(cost<matrix[i][j]){
                        matrix[i][j]=cost;
                        trace[i][j]=k;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(trace));
    }
}
