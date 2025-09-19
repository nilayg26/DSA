public class WordProblem {
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
    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile"};
        String key= "ilikesamsung";
        Node root= new Node();
        for(String word:words){
            insert(word, root, 0);
        }
        System.out.println(backtrack(key, root));
    }
    public static boolean backtrack(String key,Node root){
        if (key.isEmpty()) {
            return true;
        }
        for(int i=0;i<key.length();i++){
            String left= key.substring(0, i+1);
            String right= key.substring(i+1);
            if (search(left, root, 0)&& backtrack(right, root)) {
                return true;
            }
        }
        return false;
    }
    private static void insert(String word, Node root,int curr){
        int idx= word.charAt(curr)-'a';
        if (root.child[idx]==null) {
            root.child[idx]= new Node();
        }
        if (curr== word.length()-1) {
            root.child[idx].eow=true;
        }
        else{
            insert(word, root.child[idx], curr+1);
        }
    }
    private static boolean search(String word, Node root,int curr){
        if (curr>=word.length()) {
            return false;
        }
        int idx= word.charAt(curr)-'a';
        if (root.child[idx]!=null) {
            return ((curr==word.length()-1)?root.child[idx].eow:false)||search(word, root.child[idx], curr+1) ;
        }
        return false;
    }
}
