package JAVA_DSA.Queues;
import java.util.Scanner;  
public class QUEUES {
    static class queue{
        int rear=-1;
        static int [] array;
        static int size_arr;
        queue(int size_arr){
            array = new int [size_arr];
            this.size_arr= size_arr;
        }
       public  boolean is_empty(){
            if(rear==-1){
                return true;
            }
            return false;
        }
        void add(int element){ //enque
            if(rear==size_arr-1){
                System.out.println("Array is full");
                 return;
            }
            rear++; 
            array[rear]=element;
        }
        int remove(){  //dequeue
            int front = array[0];
            if (is_empty()) {
                System.out.println("List is empty");
                return -1;                
            } 
            for(int i=0;i<=size_arr-2;i++){
                array[i]=array[i+1];
            } 
            array[size_arr-1]=0;
            rear--;
            return front;            
        }
        int peek(){
            if (is_empty()) {
                return 0;    
            }
            return(array[0]);
        }
        void print_queue(){
            System.out.print("|");
            for(int i=0;i<rear;i++){
                System.out.print(array[i]+"|");
            }
            System.out.println(array[rear]+"|");
        }
    }
    public static void main(String [] args){
        queue test= new queue(3);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4); // List is full
        test.print_queue();  // 0 1 3
        System.out.println(test.remove()); // 0
        test.print_queue(); // 1 3 0
        test.add(4);
        test.print_queue();  
    }
    
}