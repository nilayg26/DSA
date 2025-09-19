package LabCat;

import java.util.Arrays;
import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        String x= sc.next();
        String y= sc.next();
        int [][]lcs= new int[x.length()][y.length()];
        for (int i = 0; i < lcs.length; i++) {
            Arrays.fill(lcs[i], -1);
        }
        StringBuilder res= new StringBuilder("");
        System.out.println(lcs(x, y,0,0,lcs));
        getSubsequence(res, x, y, lcs, 0, 0);
        System.out.println(res.toString());
    }
    private static void getSubsequence(StringBuilder str,String x, String y,int [][]LCS,int i, int j){  //O(n^2)
        if (i+1>=x.length() || j+1>=y.length()) {
            if (x.charAt(i)==y.charAt(j)) {
                str.append(x.charAt(i));
            }
            return;
        }
        else{
            if (x.charAt(i)==y.charAt(j)) {
                str.append(x.charAt(i));
            }
            if (LCS[i][j+1]>Math.max(LCS[i+1][j+1], LCS[i+1][j])) {
                getSubsequence(str, x, y, LCS, i, j+1);
            }
            else if (LCS[i+1][j+1]>Math.max(LCS[i+1][j], LCS[i][j+1])) {
                getSubsequence(str, x, y, LCS, i+1, j+1);
            }
            else{
                getSubsequence(str, x, y, LCS, i+1, j);
            }
        }
    }
    private static int lcs(String x,String y,int i, int j,int [][]LCS){
        if(i>=x.length() ||  j>=y.length()){
            return 0;
        }
        else{
            if(LCS[i][j]!=-1){
                return LCS[i][j];
            }
            else{
                if (x.charAt(i)==y.charAt(j)) {
                    return LCS[i][j]= 1+lcs(x, y, i+1, j+1, LCS);
                }
                else{
                    return LCS[i][j]= Math.max(lcs(x, y, i+1, j, LCS),lcs(x, y, i, j+1, LCS));
                }
            }
        }
    }
}
