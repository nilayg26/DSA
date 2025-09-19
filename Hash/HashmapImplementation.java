package JAVA_DSA.Hash;
import java.util.ArrayList;
import java.util.LinkedList;
public class HashmapImplementation {
    static class HashMap<K,V>{
      private class Node{
        K key;
        V value;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
        }
      }
      private int n; //size of no. of element
      private int N; //size of bucket
      private LinkedList<Node>[] buckets;
      public HashMap(){
          this.N=4;
          this.buckets= new LinkedList[4];
          for(int i=0;i<4;i++){
            this.buckets[i]= new LinkedList<Node>();
          }
      }
      private int hashingFunction(K key){
        return Math.abs(key.hashCode())%N;
      }
      private int searchInLL(int bi, K key){
        LinkedList<Node> ll= buckets[bi];
        int size=ll.size();
        for(int i=0;i<size;i++){
            if(ll.get(i).key==key){
              return i;
            }
        }
        return -1;
      }
      private void rehashing(){
        System.out.println("Rehasing called n="+n+" N="+N);
        LinkedList<Node>[]oldBucket= buckets;
        buckets= new LinkedList[N*2];
        for(int i=0;i<N*2;i++){
          buckets[i]=new LinkedList<Node>();
        }
        int oN=N;
        N*=2;
        for(int i=0;i<oN;i++){
          for(int j=0;j<oldBucket[i].size();j++){
            Node node= oldBucket[i].get(j);
            n=0;
            put(node.key, node.value);
          }
        }
      }
      public void put(K key,V value){
         int bi= hashingFunction(key);
         int di= searchInLL(bi, key);
         if(di==-1){
            buckets[bi].add(new Node(key, value));
            n++;
         }
         else{
            buckets[bi].get(di).value=value;
         }
         double lambda= (double)n/N;
         if(lambda>2.0){ //K=2.0
            rehashing();
         }
      }
      public V remove (K key){
        int bi=hashingFunction(key);
        LinkedList <Node>ll= buckets[bi];
        for(int i=0;i<ll.size();i++){
          if(ll.get(i).key==key){
              V value= ll.get(i).value;
              ll.remove(i);
              n--;
              return value;
          }
       }
        return null;
      }
      public V get(K key){
        int bi= hashingFunction(key);
         LinkedList <Node>ll= buckets[bi];
         for(int i=0;i<ll.size();i++){
            if(ll.get(i).key==key){
                return ll.get(i).value;
            }
         }
         return null;
      } 
      public boolean containsKey(K key){
         int bi= hashingFunction(key);
         int di=searchInLL(bi, key);
         return (di==-1)?false:true;
      }
      public int size(){
          return n;
      }
      public boolean isEmpty(){
        return n==0?true:false;
      }
      public ArrayList<K> keySet(){
        ArrayList<K> set= new ArrayList<>(); 
         for(int i=0;i<buckets.length;i++){
           for(int j=0;j<buckets[i].size();j++){
              set.add(buckets[i].get(j).key);
           }
         }
         return set;
      }
      @Override
      public String toString(){
        ArrayList<String> map= new ArrayList<>();
        for(int i=0;i<buckets.length;i++){
          for(int j=0;j<buckets[i].size();j++){
             map.add(buckets[i].get(j).key+"="+buckets[i].get(j).value);
          }
        }
        return map.toString();
      }
    }
    public static void main(String[] args) {
      HashMap<Integer,Integer> map= new HashMap<>();
      /*map.put(1,10);
      map.put(2,11);
      map.put(3,12);
      map.put(2,16);
      map.remove(2);
      map.put(4,20);
      map.put(10,23);
      map.put(9, 7);*/
      for(int i=0;i<10;i++){
        map.put(i, i+10);
      }
      ArrayList<Integer> keys= map.keySet();
      for(int k:keys){
        System.out.println(k+"="+map.get(k));
      }
     System.out.println(map);
    }
}
