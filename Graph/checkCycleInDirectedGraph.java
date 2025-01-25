package Graph;

import java.util.ArrayList;

// Take two array
// visited and path-visited once the path visited is done mark it as unvisted

public class checkCycleInDirectedGraph {
    public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V];
        int pathVisited[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfsCheck(i,adj,vis,pathVisited)) return true;
            }
        }
        return false;
    }
    private boolean dfsCheck(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] pathVisited){
        vis[node] = 1;
        pathVisited[node] = 1;

        // Traverse for adjcent node
        for(int val:adj.get(node)){
            if(vis[val]==0){
                if(dfsCheck(val,adj,vis,pathVisited)) return true;
            }
            else if(pathVisited[val]==1){
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;

    }
}
