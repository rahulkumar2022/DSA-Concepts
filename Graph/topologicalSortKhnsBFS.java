package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Kahns algorithm
// indegree [] no of incomming edges to nodes
// Take queue -> put in with 0 indegree 
// pop and do dfs -> and reduce all rechable indegree by 1
// if indree reaches 0 pull and put in queue
// All poped from queue put in array thats answer
public class topologicalSortKhnsBFS {
    
    public int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int indegree[] = new int[V];
        for(int i = 0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int topo[] = new int[V];
        int idx = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo[idx++] = node;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.add(it);
                }
            }
        }

        return topo;

    }
}
