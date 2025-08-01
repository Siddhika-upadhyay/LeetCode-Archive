class Solution {
    class tuple{
        int dis;
        int row;
        int col;
        tuple(int d, int r, int c){
            dis=d;
            row=r;
            col=c;
        }
    }
    public int minimumEffortPath(int[][] heights) {
       PriorityQueue<tuple>pq= new PriorityQueue<tuple>
       ((x,y)->x.dis-y.dis);
       int n= heights.length;
       int m= heights[0].length;
       int [][]dist= new int[n][m];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            dist[i][j]=(int)1e9;
        }
       }
       dist[0][0]=0;
       pq.add(new tuple(0,0,0));
       int[] dr={-1,0,1,0};
       int[] dc={0,1,0,-1};
        while(!pq.isEmpty()){
            tuple it= pq.peek();
            pq.remove();
            int diff=it.dis,row=it.row,col=it.col;
            if(row==n-1&&col==m-1)return diff;
            for(int i=0;i<4;i++){
                int newr=row+dr[i];
                int newc= col+dc[i];
                if(newr >= 0 && newr < n && newc >= 0 && newc < m)
                {int newEffort=Math.max(Math.abs(heights[row][col]
                -heights[newr][newc]),
                diff);
                if(newEffort<dist[newr][newc]){
                    dist[newr][newc]=newEffort;
                    pq.add(new tuple(newEffort,newr,newc));
                }
                }
            }
        }
        return 0;
    }
}