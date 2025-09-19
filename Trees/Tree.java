package JAVA_DSA.Trees;
import java.util.LinkedList;
import java.util.Queue;
class BinaryTree{
    private Node root;
    public Integer data;
    private class Node{
        Integer data;
        Node left;
        Node right;
        int height;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
        Node(){
            this.data=null;
            left=null;
            right=null;
        }
    }
    BinaryTree(){
        root=null;
        this.data=null;
    }
    BinaryTree(int data){
        root=new Node(data);
        this.data=data;
    }
    Integer getLowestCommoInteger(int a,int b){
        return lowestCommonAncestor(root, a, b);
    }
    Integer lowestCommonAncestor(Node root,int a,int b){
        if(root==null){
            return null;
        }
        if(root.data==a||root.data==b){
            return root.data;
        }
        Integer left=lowestCommonAncestor(root.left, a, b);
        Integer right=lowestCommonAncestor(root.right,a, b);
        if(left!=null&&right!=null){
            return root.data;
        }
        return (left!=null)?left:right;
    }
    void inOrder(){
        if(root==null){
            System.out.println("Tree is empty");
            return;
        }
        Node r= root;
        inOrder(r);
        System.out.println();
    }
    private void inOrder(Node r){
        if(r==null){
            return;
        }
        inOrder(r.left);
        System.out.print(r.data+" ");
        inOrder(r.right);
    }
    void postOrder(){
        if(root==null){
            System.out.println("Tree is empty");
            return;
        }
        Node r= root;
        postOrder(r);
        System.out.println();
    }
    private void postOrder(Node r){
        if(r==null){
            return;
        }
        postOrder(r.left);
        postOrder(r.right);
        System.out.print(r.data+" ");
    }   
    void preOrder(){
        if(root==null){
            System.out.println("Tree is empty");
            return;
        }
        Node r= root;
        preOrder(r);
        System.out.println();
    }
    private void preOrder(Node r){
        if(r==null){
            return;
        }
        System.out.print(r.data+" ");
        preOrder(r.left);
        preOrder(r.right);
    }
    boolean checkCompleteTree(){
        if(root==null){
            System.out.println("Tree empty");
            return true;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curr= q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty()){
                    return true;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(curr.data+" ");
                if(curr.left==null&&curr.right!=null){
                    return false;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return true;
    }
    void levelOrder(){
        if(root==null){
            System.out.println("Tree empty");
            return;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curr= q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty()){
                    return;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }
    void insert(int data){
        if(root==null){
            root=new Node(data);
            return;
        }
        else{
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr= q.remove();
                if(curr.left==null){
                    curr.left=new Node(data);
                    return;
                }
                else{
                    q.add(curr.left);
                }
                if(curr.right==null){
                    curr.right=new Node(data);
                    return;
                }
                else{
                    q.add(curr.right);
                }       
            }
        }
    }
}
public class Tree {
    public static void main(String [] args){
        int arr[]={1,2,3,4,5,6,7};
        BinaryTree tr= new BinaryTree();
        for(int i=0;i<arr.length;i++){
            tr.insert(arr[i]);
        }
        // System.out.println(tr.checkCompleteTree());
        // tr.levelOrder();
        // tr.postOrder();
        System.out.println(tr.getLowestCommoInteger(4, 5));
    }
}
