package Algorithm;
import java.util.ArrayList;
import java.util.Arrays;
// Detect negative cycle
// Find sortest path from source to each node
public class BellManFord {
    public void findSortestPath(int V,ArrayList<ArrayList<Integer>> adj,int s){
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> nodeData:adj){
                //source->Destination and cost to react from source to destination
                int source = nodeData.get(0);
                int destination = nodeData.get(1);
                int cost = nodeData.get(2);
                if(dis[source]!=Integer.MAX_VALUE && dis[source]+cost<dis[destination]){
                    dis[destination] = dis[source]+cost;
                }
            }
        }
        // temp contains the distance from source to each node with min cost
        
        // check if it has negative weight
        // one more iteration chnages value in DIS[] means it has negative cycle
        for(ArrayList<Integer> nodeData:adj){
            //source->Destination and cost to react from source to destination
            int source = nodeData.get(0);
            int destination = nodeData.get(1);
            int cost = nodeData.get(2);
            if(dis[source]!=Integer.MAX_VALUE && dis[source]+cost<dis[destination]){
                System.out.println("Contains negative cycle");
                break;
            }
        }
        
    }
}
