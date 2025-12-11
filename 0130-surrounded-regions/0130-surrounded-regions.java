class Solution {
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||j==0||i==n-1||j==m-1)&&board[i][j]=='O')
                dfs(i,j,board,n,m);
            }
        }
        for( int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')board[i][j]='X';
                else if(board[i][j]=='S')board[i][j]='O';
            }
        }
    }
    public void dfs( int row,int col, char [][]board,int n, int m){
        board[row][col]='S';
        for(int i=0;i<4;i++){
            int nr= row+dr[i];
            int nc= col+dc[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && board[nr][nc]== 'O' ){
                dfs(nr,nc,board,n,m);
            }
        }
    }
}