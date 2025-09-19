package LabCat;

import java.util.Arrays;
import java.util.Scanner;

public class q1 {
    static int n;
    static int count;
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        count=0;
        n=sc.nextInt();
        char [][]chessboard= new char[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessboard[i][j]='.';
            }
        }
        move(0, chessboard);
    }
    private static void move(int col,char [][]chessboard){
        if (col==n) {
            count++;
            System.out.println(Arrays.deepToString(chessboard));
            return;
        }
        for(int i=0;i<n;i++){
            if(safe(i,col,chessboard)){
               chessboard[i][col]='Q';
               move(col+1,chessboard);
               chessboard[i][col]='.';
            }
        }
    }
    private static boolean safe(int r, int c, char [][]chessboard){
        for(int i=0;i<n;i++){
            if(chessboard[r][i]=='Q'){
                return false;
            }
        }
        for(int i=0;i<n;i++){
            if(chessboard[i][c]=='Q'){
                return false;
            }
        }
        for(int i=r, j=c;i>=0 && j<n;i--,j++){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        for(int i=r, j=c;i<n && j<n;i++,j++){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        for(int i=r, j=c;i<n && j>=0;i++,j--){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        for(int i=r, j=c;i>=0 && j>=0;i--,j--){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}
