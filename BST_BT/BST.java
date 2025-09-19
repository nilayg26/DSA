package JAVA_DSA.BST_BT;
public class BST {
  static int value=0;
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
    public static void main(String [] args){
        Node root =null;
        int []arr={8,5,3,1,4,6,10,11,14};
        for(int i=0;i<arr.length;i++){
            root=bstBuilder(arr[i], root);
        }
        inOrder(root);
       // inOrder(root);
      //  root=bstDelete(10,root);
        System.out.println();
       // inOrder(root);
      // Node floor= floor(root,root,12);
       for(int i=0;i<arr.length;i++){
          Node floor= floor(root,null,arr[i]+1);
          if(floor!=null){
            System.out.println((arr[i]+1)+"="+floor.data);
          }
       }
      // Node ceil= ceil(root,root,12);
    //   System.out.println(floor.data+" "+ceil.data);
        shortestPath(root, 3, 14);
    }
    public static void shortestPath(Node root, int a,int b){
       if(Math.min(a, b)<=root.data&& root.data<=Math.max(a, b)){
        System.out.println();
          printPath(root, a,b,"->");
         // System.out.println();
         // printPath(root,a,b,"->");
       }
       else{
       shortestPath(root.left, a, b);
       shortestPath(root.right, a, b);
       }
    }
    public static Node printPath(Node root,int a,int b,String direct){
      if(root==null){
         return null;
      }
       if(root.data==a||root.data==b){
           System.out.print(root.data+direct);
           return root;
       }
       Node left=printPath(root.left, a, b, direct);
       if(root.left!=null){
        System.out.print(root.data+direct);
       }
       Node right=printPath(root.right, a, b, direct);
       if(left==null||right!=null){
           System.out.print(root.data+direct);
       }
       return left!=null?left:right;
    }
    public static Node bstBuilder(int val, Node root){//O(H), H is the height of the tree
        if(root==null){
          return new Node(val);
        }
        if(root.data>val){
            root.left=bstBuilder(val, root.left);
        }
        else{
          root.right=bstBuilder(val, root.right);
        }
        return root;
      }   
    public static void inOrder(Node root){ //Inorder traversal of BST gives Sorted results
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static Node floor(Node root,Node prev, int val){ //Inorder traversal of BST gives Sorted results
    if(root==null){
        return null;
    }
    Node left=floor(root.left,prev,val);
    System.out.println(root.data);
    if(root.data==val){
      return root;
    }
    
    if(prev!=null&&val<root.data){
    //  System.out.println(prev.data);
       return prev; 
    }
    prev=root;
     Node right=floor(root.right,prev,val);
     return (left!=null)?left:right;
   // return floor(root.right,prev,val);
  }
  public static Node ceil(Node root,Node prev, int val){ //Inorder traversal of BST gives Sorted results
    if(root==null){
        return null;
    }
    Node right=ceil(root.right,prev,val);
    System.out.println(root.data);
    if(root.data==val){
      return root;
    }
    if(val>root.data){
      System.out.println("called");
       return prev; 
    }
    if(prev!=null&&val>root.data){
      return prev; 
   }
    prev=root;
    Node left=ceil(root.left,prev,val);
    return (right!=null)?right:left;
}
    public static boolean bstSearch(int val, Node root){//O(H), H is the height of the tree
        if(root==null){
          return false;
        }
        if(root.data==val){
            return true;
        }
        return (root.data>val)?bstSearch(val, root.left):bstSearch(val, root.right);
    }
    public static Node bstDelete(int val, Node root){//O(H), H is the height of the tree
      if(root==null){
        System.out.println("Node cannot be found");
        return null;
      }
      if(root.data==val){
        //case1: 
        if(root.right==null&&root.left==null){
            value=root.data;
            return null;
        }
        //case2:
        if(root.right==null){
            return root.left;
        }
        else if (root.left==null){
            return root.right;
        }
        //case3:
        else{
            root.right= inOrderSuccessor(root.right);
            root.data=value;
            return root;
        }
      }
      if(root.data>val){
        root.left=bstDelete(val, root.left);
      }
      else{
       root.right=bstDelete(val, root.right);
      }
    return root;
    }
    private static Node inOrderSuccessor(Node root){
        if(root.right==null&&root.left==null){
            value=root.data;
            return null;
        }
        else if(root.left==null){
            value=root.data;
            return root.right;
        }
        root.left= inOrderSuccessor(root.left);
        return root;
    }
    private static Node inOrderPredecessor(Node root){
      if(root.right==null&&root.left==null){
          value=root.data;
          return null;
      }
      else if(root.right==null){
          value=root.data;
          return root.left;  
      }
      root.right= inOrderSuccessor(root.right);
      return root;
  }
}
/*On the basis H the time complexity is calculated:
    in best case: Balanced tree H= O(log n), same for avg case also H= O(log n)
    for worst case: H=O(n) skewed tree
    */   
/*The `static` keyword in Java has several roles, but its primary function in the context of the `Node` class in your code is to make it a static inner class. This means that `Node` objects can be created and used independently of any `BST` object. 

Here's a breakdown of the implications of using `static` in this context:

**1. Shared Memory Space:**

- Static inner classes share the same memory space as the outer class (`BST`). This means that all instances of `Node` will share the same class definition and methods, which can lead to memory efficiency.

**2. Creation and Usage:**

- You can create `Node` objects directly using the `new` keyword within static methods like `bstBuilder`. This is because static inner classes are not associated with specific instances of the outer class.

**3. Accessibility:**

- Static inner classes can access static members of the outer class. However, in this case, `bstBuilder` doesn't need to access any non-static members of `BST`.

**4. Non-Static Inner Classes:**

- If `Node` were not static, it would be a non-static inner class. This would mean that instances of `Node` could only be created within the context of a `BST` object, and they would have access to non-static members of the `BST` instance.

In summary, the `static` keyword in the `Node` class declaration allows you to create and use `Node` objects independently of `BST` objects, which is beneficial for the structure and efficiency of your code.

*/
