public class MaxXOR {
    
}
class Solution {
    static class Node{
        Node []child;
        Node(){
            child = new Node [2];
            child[0]=null;
            child[1]=null;
        }
    }
    private void insert(int num, Node root){
        for(int i=0;i<32;i++){
            int d=(num>>(31-i)&1);
            if(root.child[d]==null){
               root.child[d]=new Node();
            }
            root=root.child[d];
        }
    }
    public int findMaximumXOR(int[] nums){
       Node root= new Node();
       for(int i: nums){
         insert(i,root);
       }
       int max=0;
       Node main= root;
       for(int i:nums){
            root=main;
            int xor=0;
            int val=0;
             for(int t=0;t<32;t++){
                int d1= (i>>(31-t)&1);
                if(root.child[d1^1]!=null){
                    val = (val<<1) | (d1^1);
                    root=root.child[d1^1];
                }
                else{
                    val = (val<<1) | (d1);
                    root=root.child[d1];
                }
             }
             xor=val^i;
            if(max<xor){
                max=xor;
            }
       }
       return max;
    }
}