package JAVA_DSA.Linked_List;
import java.util.*;
class LL{
    static class Node{
        String data;
        Node next;
        Node(String data){
            this.data= data;
            this.next= null;
        }}
        Node head;
        public void add_first(String data){
            Node newNode= new Node(data);
            if(head==null){
                head= newNode;
                return;
            }
            newNode.next= head;
            head= newNode;
        }
        public void add_last(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current_node = head;
            while (current_node.next != null) {
                current_node = current_node.next;

            }
            current_node.next = newNode;
        }
        public void printInfo(){
            if (head == null) {
                System.out.println("list is empty");
                return;
            }
            Node current_node= head;
            while(current_node!=null){
                System.out.print(current_node.data +" --> ");
                current_node= current_node.next;
            }
            System.out.println("Null");
        }
        public void delete_first() {
            if (head == null) {
                System.out.println("LIST IS Empty");
                return;
            }
            if (head.next == null) {
                head = null;
                System.out.println("List erased completely");
                return;
            }
            head = head.next;
        }
        public void delete_last(){
            if (head == null) {
                System.out.println("LIST IS Empty");
                return;
            }
            else if (head.next == null) {
                head = null;
                System.out.println("List erased completely");
                return;
            }
            Node last_node= head.next;
            Node secondlast_node= head;
            while(last_node.next!= null){
                secondlast_node= secondlast_node.next;
                last_node=last_node.next;
            }
            secondlast_node.next=null;

        }
        public void delete_all(){
            head=null;
            System.out.println("List sent to garbage memory of java");
        }
    public static void main(String [] args){
        LL list = new LL();
        //NEW LIST

       /* for(a=0;a<=6;a++){
            String s = String.valueOf(a);
            list.add_last(s);
        }
        list.printInfo();  */
        System.out.println("Enter element to form a list");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String i = sc.nextLine();
            if(Objects.equals(i, "done")){
                break;
            }

            list.add_last(i);

        }
        list.printInfo();
        list.delete_all();
        list.printInfo();
    }




}


