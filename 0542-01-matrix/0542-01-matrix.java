class Solution {
    class Pair{
        int first,second,third;
        Pair(int f, int s,int t){
            this.first=f;
            this.second=s;
            this.third=t;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;
        int vis[][]=new int[n][m];
        int dis[][]=new int [n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int step= q.peek().third;
            q.remove();
            dis[row][col]=step;
            for(int i=0;i<4;i++){
                int nrow= row+delrow[i];
                int ncol= col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,step+1));
                }
            }
        }
        return dis;

    }
}