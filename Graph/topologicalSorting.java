package Graph;

// Topological Sort -> arrange the nodes into sorted array

import java.util.ArrayList;
import java.util.Stack;

// Directed acylic graph
// take visted Array and one answer array
// Use stack
// Take a element
// do dfs
// Put all in stack
// and continue for all nodes
// then pop all elemts fron stack
// and put in array
public class topologicalSorting {
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V];
        Stack<Integer> stack = new ArrayList();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,stack,adj);
            }
        }
        int ans[] = new int[V];
        int idx = 0;
        while(!stack.isEmpty()){
            ans[idx++] = stack.pop();
        }
        return ans;
    }
    private static void dfs(int node,int visited[],Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        for(int val:adj.get(node)){
            if(visited[val]==0){
                dfs(val,visited,st,adj);
            }
        }
        st.push(node);
    }

}
