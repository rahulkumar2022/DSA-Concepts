package Graph;
// Leetcode 547
// dfs traversal
public class NoOfProvince {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int province = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                province++;
                dfs(i,isConnected,visited);
            }

        }
        return province;
    }
    private void dfs(int node,int[][] isConnected,boolean[] visited){
        visited[node] = true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[i][node]==1 && !visited[i]){
                dfs(i,isConnected,visited);
            }
        }
    }
    
}
