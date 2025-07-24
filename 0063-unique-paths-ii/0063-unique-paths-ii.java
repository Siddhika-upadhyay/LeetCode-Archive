class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] prev= new int[m];
        if (obstacleGrid[0][0] == 1||obstacleGrid[n-1][m-1] == 1) return 0;
      for(int row=0;row<n;row++){
        int[]temp=new int[m];
        for(int col=0;col<m;col++){
            if(row==0&&col==0&&obstacleGrid[row][col]!=1){
                temp[col]=1;
                continue;
            }
            if(obstacleGrid[row][col]==1){
                temp[col]=0;
                continue;
            }
            int up=0,left=0;
            if(col>0)left=temp[col-1];
            if(row>0)up=prev[col];
            temp[col]=left+up;
            }
            prev=temp;
      }
      return prev[m-1];
    }
}