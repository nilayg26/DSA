public class LongestWordPrefix {
    static class Node{
        Node []child;
        boolean eow;
        Node(){
            child= new Node[26];
            eow=false;
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    }
    static String maxString="";
    private static void insert(Node root,String word, int curr){
        int idx= word.charAt(curr)-'a';
        if (root.child[idx]==null) {
            root.child[idx]= new Node();
        }
        if (curr==word.length()-1) {
            root.child[idx].eow=true;
            return;
        }
        insert(root.child[idx], word, curr+1);
    }
    private static void dfsTrie(Node root,StringBuilder currString){
        if (root==null) {
             return;
        }
        for(int i=0;i<26;i++){
            Node curr= root.child[i];
            if (curr!=null && curr.eow) {
                currString.append((char)(i+'a'));
                if (currString.length()>maxString.length()){
                    maxString= currString.toString();
                }
                dfsTrie(curr, currString);
                currString.deleteCharAt(currString.length()-1);   
            }
        }
    }
    public static void main(String[] args) {
       String words [] = {"a", "banana","app", "appl", "ap", "apply", "apple"};
       Node root= new Node();
       for(String word: words){
          insert(root, word, 0);
       }
       dfsTrie(root, new StringBuilder(""));
       System.out.println(maxString);
    }
}
