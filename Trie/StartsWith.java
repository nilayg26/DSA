public class StartsWith {
    static class Node{
        Node [] child;
        boolean eow;
        Node(){
            child= new Node[26];
            eow=false;
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    }
    private static void insert(Node root, String word, int curr){
        int idx= word.charAt(curr)-'a';
        if (root.child[idx]==null) {
            root.child[idx]=new Node();
        }
        if (curr==word.length()-1) {
            root.child[idx].eow=true;
            return;
        }
        insert(root.child[idx], word, curr+1);
    }
    private static boolean search(Node root, String word, int curr){
        if (curr>=word.length()) {
            return false;
        }
        int idx= word.charAt(curr)-'a';
        if(root.child[idx]!=null){
            return  ((curr==word.length()-1) ? root.child[idx].eow:false) || search(root.child[idx], word, curr+1)  ;
        }
        return false;
    }
    public static boolean startsWith(Node root ,String word, int curr){
        if (curr>=word.length()) {
            return true;
        }
        int idx= word.charAt(curr)-'a';
        if (root.child[idx]!=null) {
            return startsWith(root.child[idx], word, curr+1);
        }
        return false;
    }
 public static void main(String[] args) {
    String []words= { "app","apple","mango", "man", "woman"};
    String prefix= "ma";
    Node root = new Node();
    for(String word: words){
        insert(root, word, 0);
    }
    System.out.println(startsWith(root, prefix, 0));
 }   
}
