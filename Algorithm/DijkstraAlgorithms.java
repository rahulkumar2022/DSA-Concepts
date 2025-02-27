package Algorithm;
import java.util.*;
public class DijkstraAlgorithms {
    public int[] directions(int V,ArrayList<ArrayList<Integer>> adj,int s){
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[1]-y[1]);

        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[s] = 0;
        pq.offer(new int[]{s,0});

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int dis = arr[1];
            int node = arr[0];
            for(int i=0;i<adj.get(node).size();i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int edegeNode = adj.get(node).get(i).get(0);
                if(dis+edgeWeight<dist[edegeNode]){
                    dist[edegeNode] = dis + edgeWeight;
                    pq.add(new int[]{edegeNode,dist[edegeNode]});
                }
            }
        }
    }
}
