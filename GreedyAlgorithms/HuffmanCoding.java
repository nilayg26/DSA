package JAVA_DSA.GreedyAlgorithms;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanCoding {
    static class Node implements Comparable<Node>{
        int data;
        Node left;
        Node right;
        char c;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            this.c=(char)125;
        }
        Node(int data,char c){
            this.data=data;
            this.left=null;
            this.right=null;
            this.c=c;
        }
        @Override
        public int compareTo(Node b){
            return this.data-b.data;
        }

    }
    // static class A implements Comparable<A>{
    //     char c;
    //     int freq;
    //     A(char c,int f){
    //         this.freq=f;
    //         this.c=c;
    //     }
    // }
    public static void main(String [] args){
        char []c={'a','b','c','d','e','f'};
        int []freq={12,2,7,13,14,85}; 
        HashMap<Integer,Character>map=new HashMap<>();
        PriorityQueue<Node>q=new PriorityQueue<>();
        for(int i=0;i<c.length;i++){
            q.add(new Node (freq[i],c[i]));
        }
        Node root=buildTree(q);
    }
    private static Node buildTree(PriorityQueue<Node>q){
        Node root=new Node(0);
        for(int i=1;i<6;i++){
            root=new Node(0);
            root.right=q.remove();
            root.left=q.remove();
            root.data=root.right.data+root.left.data;
            q.add(root);
        }
        return root;
    }
    private static void preOrder(Node root,String str){
        if(root==null){
            return;
        }
        str+="1";
        preOrder(root.left,str);
        str=str.substring(0,str.length()-1)+"0";
        preOrder(root.right, str);
        return;
    }
}
