package JAVA_DSA.Hash;
import java.util.HashSet;
import java.util.Iterator;
public class Hashset {
    public static void main(String[] args) {
      HashSet<Integer> set= new HashSet<>();
      set.add(0);
      set.add(1);
      set.add(2);
      Iterator it= set.iterator();
      while(it.hasNext()){
        System.out.println(it.next());
      }
    }
}
/*
 * For your understanding (it does not happen like this just for understanding)
 * when you initialise your iterator, its initially pointing towards a null
 * when you call it.next() it prints 0
 * when you call it.next() it prints 1
 *  and so on unitl hasNext() is true
 */
