package Graph;

import java.util.ArrayList;
import java.util.Stack;

class Pair{

    int first;
    int second;

    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

public class shortestPathDAG {

    private void topoSort(int node,ArrayList<ArrayList<Pair>> adj,int vis[],Stack<Integer> st){
        vis[node] = 1;
        for(int i=0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(vis[v]==0){
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }


    public int[] sortestPath(int V,int E,int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }

        // we create a graph first in the form of an adjcency list
        for(int i=0;i<E;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                topoSort(i,adj,vis,st);
            }
        }

        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)(1e9);
        }

        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            for(Pair pair:adj.get(node)){
                int v = pair.first;
                int wt = pair.second;
                if(dist[node]+wt<dist[v]){
                    dist[v] = wt + dist[node];
                }
            }
        }

        for(int i=0;i<V;i++){
            if(dist[i]==1e9) dist[i] = -1;
        }

        return dist;

    }
}
