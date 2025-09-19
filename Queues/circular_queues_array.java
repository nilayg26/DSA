package JAVA_DSA.Queues;
import java.util.Arrays;
public class circular_queues_array {
     static int [] array;
     static class circular_queues{
        int rear=-1;
        int front=-1 ;
        int size;
        circular_queues(int size){
            this.size=size;
            array= new int[size];
        }
        boolean is_empty(){
           return (rear==-1 && front==-1);
            //return True if return statement is true, else false. 
        }
        boolean is_full(){
             return (rear+1)%size==front; //return True if return statement is true, else false.
        }
        void add(int ele){
            int rear_1= rear;
            if(is_full()){
                System.out.println("Array is full");
                return;
            }
            rear=(rear+1)%size; 
            array[rear]=ele;            
        }
        int remove(){
            if (is_empty()){
                System.out.println("List is empty");
                return -1;
            }
            front= (front+1)%size;
            int result= array[front];
            return(result);
        }
        int peek(){
            if (is_empty()){
                System.out.println("List is empty");
                return -1;
            }
            return array[front];
        }                 
        }
        public static void main(String [] args){
            circular_queues q= new circular_queues(4);
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);
            
        }
        }
        

    
    

