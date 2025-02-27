package Algorithm;
import java.util.*;
public class FloodFillAlgoBFS {
    public int[][] floodFill(int[][] image,int sr,int sc,int newColor){
        if(image[sr][sc]==newColor){
            return image;
        }
        int oldColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr,sc});
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(queue.isEmpty()){
            int[] front = queue.poll();
            int row = front[0], col = front[1];
            for(int direction:directions){
                int xAxis = row + direction[0];
                int yAxis = col + direction[1];
                if(xAxis<0 || yAxis<0 || xAxis>=image.length || yAxis>=image.length || image[xAxis][yAxis]!=oldColor){
                    continue;
                }
                image[xAxis][yAxis] = newColor;
                queue.offer(new int[]{xAxis,yAxis});

            }
        }
    }
}
