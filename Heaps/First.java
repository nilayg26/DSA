package JAVA_DSA.Heaps;

public class First {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    static int [] sortedArray;
    public static void main(String [] args){
        int [] arr= {9,1,4,2,55,0,8,6,10};
        Node root =new Node(arr[0]);
        sortedArray=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            insert(root, arr[0]);
        }
    }
    public static void insert(Node root,int data){
        if(root.data>data){
            
        }
        insert(root.left, data);
        insert(root.right, data);
         return ;
    }
    public static void delete(Node root,int data){

    }
}
