public class Trie {
    static class Node {
        Node[] child; // small a to small z
        boolean eow;

        Node() {
            child = new Node[26];
            eow = false;
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    }
    public static void main(String[] args) {
        String[] words = { "the", "a", "there", "their", "any" };
        Node root = new Node();
        for(int i=0;i<words.length;i++){
            insert(words[i], root, 0);
        }
        System.out.println(search("their", root, 0));

    }
    public static boolean search(String word, Node root, int curr){
        if (curr>=word.length()) {
            return false;
        }
        int idx = word.charAt(curr) - 'a';
        if (root.child[idx]!=null) {
            return ((curr==word.length()-1)?root.child[idx].eow:false)||search(word, root.child[idx], curr+1);
        }
        return false;
    }
    public static void insert(String word, Node root, int curr) {
        int idx = word.charAt(curr) - 'a';
        if (root.child[idx]==null) {
            root.child[idx]=new Node();
        }
        if (curr==word.length()-1) {
            root.child[idx].eow=true;
        }
        else{
            insert(word, root.child[idx], curr + 1);
        }
    }
}