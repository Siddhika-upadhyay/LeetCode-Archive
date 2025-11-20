class Solution {
    // public boolean isSafe(int i, int j , char [][]board, int n){
    //     //upper diagonal
    //     int row=i;
    //     int col=j;
    //     while(i>=0&&j>=0){
    //         if(board[i][j]=='Q')return false;
    //         i--;
    //         j--;
    //     }
    //     i=row;j=col;
    //     //lower diagonal
    //     while(i<n&&j>=0){
    //         if(board[i][j]=='Q')return false;
    //         i++;
    //         j--;
    //     }
    //     i=row;j=col;
    //     while(j>=0){
    //         if(board[i][j]=='Q')return false;
    //         j--;
    //     }
    //     return true;
    // }

    // public void solve(int col, char [][]board ,List<List<String>>res, int n){
    //     if(col==n){
    //         List<String>temp= new ArrayList<>();
    //         for(int i=0;i<n;i++){
    //             temp.add(new String(board[i]));
    //         }
    //         res.add(temp);
    //         return;
    //     }

    //     for(int row=0;row<n;row++){
    //         if(isSafe(row,col,board,n)){
    //             board[row][col]='Q';
    //             solve(col+1,board,res,n);
    //             board[row][col]='.';
    //         }
    //     }
    // }
    // public List<List<String>> solveNQueens(int n) {
    //     char board[][] = new char [n][n];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             board[i][j] = '.';
    //         }
    //     }
    //     List<List<String>> res = new ArrayList<>();
    //     solve(0, board, res, n);
    //     return res;
    // }


//optimized answer for this ::


public void solve(int col, char [][]board ,List<List<String>>res, int n,
    int []leftRow,int []lowerDiagonal,int []upperDiagonal){
        if(col==n){
            List<String>temp= new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for(int row=0;row<n;row++){
            if(leftRow[row]==0&&lowerDiagonal[row+col]==0 && upperDiagonal[(n-1)+(col-row)]==0){
                board[row][col]='Q';
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[(n-1)+(col-row)]=1;
                solve(col+1,board,res,n,leftRow,lowerDiagonal,upperDiagonal);
                board[row][col]='.';
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[(n-1)+(col-row)]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
       int leftRow[]=new int[n];
       int upperDiagonal[]=new int[2*n-1];
       int lowerDiagonal[]=new int[2*n-1];
       solve(0,board,res,n,leftRow,lowerDiagonal,upperDiagonal);
        return res;
    }
}