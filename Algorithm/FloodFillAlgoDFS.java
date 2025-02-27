package Algorithm;

public class FloodFillAlgoDFS {
    public void floodFill(int[][] image,int sr,int sc,int newColor){
        if(image[sr][sc]==newColor){
            return;
        }
        dfs(image,sr,sc,image[sr][sc],newColor);

    }
    private void dfs(int[][] image,int x,int y,int oldColor,int newColor){
        if(x<0 || y<0 || x>=image.length || y>=image.length || image[x][y]!=oldColor){
            return;
        }
        image[x][y] = newColor;
        dfs(image,x+1,y,oldColor,newColor);
        dfs(image,x-1,y,oldColor,newColor);
        dfs(image,x,y+1,oldColor,newColor);
        dfs(image,x,y-1,oldColor,newColor);
    }
}
