public class PowerSet {
    public static void main(String[] args) {
        String str= "abc";
        bitManupilation(str, str.length());
    }
    private static void bitManupilation(String str,int len){
        int n= 1<<len;
        System.out.println("Subsets are:");
        StringBuilder sub= new StringBuilder("");
        for(int i=0;i<n;i++){
            sub.setLength(0);
            for(int j=0;j<len;j++){
                if ((i & (1<<j))!=0) {
                    sub.append(str.charAt(j));
                }
            }
            System.out.println(sub.toString());
        }
    }
    private static void bactracking(String str,String perm){
        if(str.length()==0){
            return;
        }
        for(int i=0;i<str.length();i++){
            perm+=str.charAt(i);
            bactracking(str.substring(i+1), perm);
        }
    }
}
