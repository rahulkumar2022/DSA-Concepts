package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class sortedtPathInUndirectedGraphWithUnitDistance {
    public int[] sortestPath(int[][] edges,int n,int m,int src){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){ 
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){ 
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int dis[] = new int[n];
        Arrays.fill(dis, (int)(1e9));
        dis[src] = 0;
        Queue<Integer> q =new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it:adj.get(node)){
                if(dis[node]+1<dis[it]){
                    dis[it] = dis[node]+1;
                    q.add(it);
                }
            }
        }
        for(int i=0;i<n;i++){ 
            if(dis[i]==1e9){
                dis[i] = -1;
            }
        }


        return dis;
    }
}
