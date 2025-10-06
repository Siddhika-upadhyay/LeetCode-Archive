class Pair{
    int row;
    int col;
    int dist;
    Pair(int r,int c,int d){
        row=r;
        col=c;
        dist=d;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n= heights.length;
        int m= heights[0].length;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.dist-b.dist);
        int dist[][]= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;;
            }
        }
        dist[0][0]=0;
        pq.add(new Pair(0,0,0));
        int []delRow= {-1,0,1,0};
        int []delCol={0,1,0,-1};
        while(!pq.isEmpty()){
            int row=pq.peek().row;
            int col=pq.peek().col;
            int dis= pq.peek().dist;
            pq.remove();
            if(row==n-1&&col==m-1)return dis;
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol= col+delCol[i];
                if(nRow>=0&& nRow<n && nCol>=0 && nCol<m){
                  int diff= Math.abs(heights[nRow][nCol]- heights[row]     
                  [col]);
                    int newEffort= Math.max(diff,dis);
                  if(newEffort<dist[nRow][nCol]){
                    dist[nRow][nCol]=newEffort;
                    pq.add(new Pair(nRow,nCol,newEffort));
                }
                }
            }
             }
             return 0;
    }
}