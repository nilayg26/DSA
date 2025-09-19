package LabCat;
import java.util.Arrays;
import java.util.Scanner;
public class KMP {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String text= sc.next();
        String pattern ="ababa";
        int m= pattern.length();
        int []F= new int[m];
        prefixTable(F,pattern,m);
        System.out.println(Arrays.toString(F));
        kmp(text, F,pattern);
    }
    private static void kmp(String text,int []F,String pattern){ //O(n+m)
        int m= pattern.length();
        int j=0;
        int i=0;
        int len = text.length();
        while(i<len){
            if (text.charAt(i)==pattern.charAt(j)) {
                if (j==m-1){
                    System.out.println("Fount at index "+(i-m+1)+" to "+(i));
                    return;
                }
                i++;
                j++;
            }
            else if(j>0){
                j=F[j-1];
            }
            else{
                i++;
            }
        }
    }
    private static void prefixTable(int []F,String pattern,int m){
        int i=1;
        int j=0;
        F[0]=0;
        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(j)) {
                F[i]=j+1;
                i++;
                j++;
            }
            else if(j>0){
                j=F[j-1];
            }
            else{
                F[i]=0;
                i++;
            }
        }
        return;
    }
}
