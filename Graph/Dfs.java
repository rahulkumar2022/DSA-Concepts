package Graph;

import java.util.ArrayList;

public class Dfs {
    public static ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[V];
        visited[0] = true;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0,visited,adj,list);
        return list;
    }
    private static void dfs(int node,boolean visited[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list){
        visited[node] = true;
        list.add(node);
        for(Integer it:adj.get(node)){
            if(visited[it]==false){
                dfs(it,visited,adj,list);
            }
        }
    }
    
}
