class Solution {
    class Tuple{
        int row;
        int col;
        int steps;
        Tuple(int r, int c, int s){
            this.row=r;
            this.col=c;
            this.steps=s;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
      int n= mat.length;
      int m = mat[0].length;
      int vis[][]= new int [n][m];
      int res[][]= new int [n][m];
      Queue<Tuple>q= new LinkedList<>();
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(mat[i][j]==0){
                vis[i][j]=1;
                q.add(new Tuple(i,j,0));
            }
        }
      }
      int[]dr={-1,0,1,0};
      int []dc={0,1,0,-1};
      while(!q.isEmpty()){
        Tuple t= q.poll();
        int r= t.row;
        int c= t.col;
        int s= t.steps;
        res[r][c]=s;
        for( int i=0;i<4;i++){
          int nr= r+dr[i];
          int nc= c+dc[i];
          if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0){
            q.add(new Tuple(nr,nc,s+1));
            vis[nr][nc]=1;
          }
        }
      }
     return res;
    }
}