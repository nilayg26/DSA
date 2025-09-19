import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
public class Practise {
       static class Pair implements Comparable<Pair>{
        int node;
        int dis;
        Pair(int node, int dis ){
            this.node= node;
            this.dis=dis;
        }
        public int compareTo(Pair p1){
            return this.dis-p1.dis;
        }
    }
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        boolean []vis= new boolean[V];
        int cost=0;
        PriorityQueue<Pair> q= new PriorityQueue<>();
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair curr= q.remove();
            if(!vis[curr.node]){
            vis[curr.node]=true;
            cost+=curr.dis;
            for(int i=0;i<adj.get(curr.node).size();i++){
                List<Integer> edge= adj.get(curr.node).get(i);
                int u= curr.node;
                int v= edge.get(0);
                int wt= edge.get(1);
                if(!vis[v]){
                    q.add(new Pair(v,wt));
                }
            }
        }   
        }
        return cost;
    }
}

}
