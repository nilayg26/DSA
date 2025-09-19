import java.util.LinkedList;
import java.util.Queue;

public class UniqueSubstring {
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
    public static void main(String[] args) {
        Node root= new Node();
        String str= "ababa";
        for(int i=0;i<str.length();i++){
            insert(root, str.substring(i), 0); //storing all suffixes in Trie DS 
        }
        System.out.println(bfsTrie(root));
    }
    public static int bfsTrie(Node root){
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        int count=1; //considering empty string also
        while(!q.isEmpty()){
            Node curr= q.remove();
            for(int i=0;i<26;i++){
                if (curr.child[i]!=null) {
                    q.add(curr.child[i]);
                    count++;
                }
            }
        }
        return count;
    }
    private static void insert(Node root, String word, int curr){
        int idx = word.charAt(curr)-'a'; 
        if (root.child[idx]==null) {
            root.child[idx]= new Node();
        }
        if (curr== word.length()-1) {
            root.child[idx].eow= true;
            return;
        }
        insert(root.child[idx], word, curr+1);
    }
}
