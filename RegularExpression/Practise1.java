package RegularExpression;
import java.util.regex.*;

public class Practise1 {
    public static void main(String[] args) {
        //check weather a string contains only alphanumeric character
        System.out.println(checkPattern("[a-zA-Z0-9]+","hello123"));
         //Create RE that accept 10 digits number only
         System.out.println(checkPattern("[0-9]{10}","1234567890"));
         //Write a EX to match email addresss
         System.out.println(checkPattern("^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-z]{2,}$", "abc@gmail.com")); 
        // Write a RE for matching username that contain numbers, letters and @,$ only.       
        System.out.println(checkPattern("^[a-zA-Z0-9@$]+$","nilay@123"));
        String str= "a+ab23*fc2";
        String []arr= str.split("[a-z]+");
        for(int i=0;i<arr.length;i++){
            if (arr[i].isEmpty()) {
                arr[i]="1";
            }
        }
        System.out.println(String.join("", arr));

        System.out.println(checkPattern("^[a-zA-Z0-9@$]+$","nilay@123"));
    }
    private static boolean checkPattern(String regex, String sequence){
        Pattern ptr= Pattern.compile(regex);
        Matcher m= ptr.matcher(sequence);
        return m.matches(); //checks weather the sequence satisfies the given regex 
    }
}
