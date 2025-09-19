package JAVA_DSA.Hash;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
public class Hashmap {
    public static void main(String [] args){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,10);
        map.put(1,11);
        map.put(2,12);
        map.put(3,13);
        //map.entrySet() is the set version of our map 
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            System.out.println(e);
        }
        Set<Integer> keys= map.keySet();
        for(int i:keys){
            System.out.println(i);
            System.out.println(map.get(i));
        }
    }
}
/*A LinkedHashMap in Java is a class that extends HashMap and is part of the 
Java Collections Framework. It combines the features of a HashMap and a LinkedHashSet.
 In a LinkedHashMap, the order of elements is based on their insertion order, and it
  maintains a doubly-linked list that allows you to iterate over the elements in the
   order in which they were added.
   likedhashmap can be iterated like:
   linkedHashMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
 */
/*
 * The reason your check for `keys instanceof HashSet` is not printing "hashset" is
 *  because the `keySet()` method of `HashMap` 
 * does **not return a `HashSet`** object. 
 * Instead, it returns an **internal implementation of
 *  a `Set`** that is backed by the `HashMap`, but it is not actually a `HashSet`. 

The `keySet()` method of `HashMap` returns an instance of a private inner class that implements the `Set` interface but is not specifically a `HashSet`. This is why the `instanceof HashSet` check fails.

### Why This Happens:
- `HashMap` has its own implementation of the `Set` interface for the keys.
- This implementation is a private inner class (typically named something like `KeySet`), which is used for memory and performance optimizations.
- Even though this `KeySet` behaves like a `Set`, it's not an actual `HashSet` instance.

### Correct Behavior:
If you want to check if a particular `Set` is a `HashSet`, you should either:
1. Directly create a `HashSet` from the `keySet()` like this:

   ```java
   Set<Integer> keys = new HashSet<>(map.keySet());
   if (keys instanceof HashSet) {
       System.out.println("hashset");
   }
   ```

   Here, you are explicitly creating a `HashSet` from the `keySet()`, so the check will print "hashset".

2. Check only if it is a `Set` (not a specific implementation like `HashSet`):

   ```java
   if (keys instanceof Set) {
       System.out.println("It's a Set");
   }
   ```

This will work because `keySet()` always returns an object that implements the `Set` interface, though it is not a `HashSet`.
 */
