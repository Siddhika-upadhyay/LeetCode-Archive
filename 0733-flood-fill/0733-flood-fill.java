class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int n= image.length;
       int m= image[0].length;
       Queue<int[]> q= new LinkedList<>();
       int []dr={-1,0,1,0};
       int []dc={0,1,0,-1};
       int originalColor= image[sr][sc];
       if(originalColor== color)return image;
      q.add(new int[]{sr,sc});
      while(!q.isEmpty()){
        int []arr= q.poll();
        int r= arr[0];
        int c= arr[1];
        image[r][c]=color;
        for(int i=0;i<4;i++){
            int nr= r+dr[i];
            int nc= c+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==originalColor){
                q.add(new int[]{nr,nc});
            }
        }
      }
      return image;
    }
}