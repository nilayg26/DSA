package LabCat;

import java.util.Scanner;

//rabin karp
public class q2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        System.out.println("Enter text");
        String text= sc.nextLine();
        System.out.println("Enter word");
        String word= sc.next();
        System.out.println(rabinKarpSearch(text.toLowerCase(), word.toLowerCase()));
    }
    private static int rabinKarpSearch(String text, String word){
        double base_val=10;
        int word_size= word.length();
        int text_length= text.length();
        double word_val=0;
        double curr_val=0;
        int freq=0;
        for(int i=word_size-1;i>=0;i--){
            word_val+=(word.charAt(word_size-1-i)-'a'+1)*Math.pow(base_val, i);
            curr_val+=(text.charAt(word_size-1-i)-'a'+1)*Math.pow(base_val, i);
        }
        if (curr_val==word_val) {
            if(word.equals(text.substring(0,word_size))){
                freq++;
            }
        }
        double max_pow=Math.pow(base_val,word_size-1);
        for(int i=1;i<text_length-word_size+1;i++){
            curr_val=((curr_val-((text.charAt(i-1)-'a'+1)*max_pow))*10)+(text.charAt(i+word_size-1)-'a'+1);
            if (curr_val==word_val) {
                if(word.equals(text.substring(i,i+word_size))){
                    freq++;
                }
            }
        }
        return freq;
    }
}
