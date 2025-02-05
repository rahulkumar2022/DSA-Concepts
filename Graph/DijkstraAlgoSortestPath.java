package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Using priority Queue
class Pair{
    
    int node;
    int distance;
    public Pair(int node,int distance) {
        this.node = node;
        this.distance = distance;
    }
    
}
public class DijkstraAlgoSortestPath {

    //Function to find Sortest part to all vertices if source is s
    public static int[] disjetra(int V,ArrayList<ArrayList<Integer>> adj,int s){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance);
        int[] dis = new int[V];
        Arrays.fill(dis, (int)(1e9));
        dis[s] = 0;
        pq.add(new Pair(0, s));
        while(!pq.isEmpty()){
            // gettting min dis and node
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            // Check for all its adjacent nodes and compare with its prev distance
            for(ArrayList<Integer> list:adj.get(node) ){
                int wt = list.get(1);
                int adjNode = list.get(0);

                if(distance+wt<dis[adjNode]){
                    dis[adjNode] = distance + wt;
                    pq.add(new Pair(dis[adjNode], adjNode));
                }
            }

        }

        return dis;

    }

    
}
