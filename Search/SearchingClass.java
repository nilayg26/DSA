package JAVA_DSA.Search;
public class SearchingClass {
    public static void main(String [] args){
        int []arr={2,3,5,6,7,8,9};
        Search s= new Search(arr);
        System.out.println(s.binarySearch(9));
        int e=s.binarySearch(6);
        if(e!=-1){
            System.out.println("Element found at index: "+e);
        }
        else{
            System.out.println("Element Not found in the sorted array");
        }
    }
}
class Search{
    private int []arr;
    private int size;
    Search(int []arr){
        this.arr=arr;
        this.size=arr.length;
    }
    int linearSearch(int element){ //for unsorted arrays
        for(int i=0;i<size;i++){
            if(element==arr[i]){
               return i;//Found
            }
        }
        return -1; //Not Found
    }
    private int search(int s,int e,int element){//FOR BINARY SEARCH
        if(s>e){
            return -1;
        }
        int middle=(s+e)/2;
        if(arr[middle]==element){
            return middle;
        }
        return (arr[middle]>element?search(s,middle-1,element):search(middle+1,e, element));
    }
    int binarySearch(int element){//for sorted arrays
        return  search(0,size-1,element); 
    }
}
