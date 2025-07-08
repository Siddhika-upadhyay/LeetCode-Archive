class Solution {
    public int dfs(int row, int col,int [][]matrix ,int [][]res,int delRow[],int delCol[]){
        int n= matrix.length;
        int m= matrix[0].length;
        if(res[row][col]!=0)return res[row][col];
        int max=1;
        for(int i=0;i<4;i++){
            int newRow= row+delRow[i];
            int newCol= col+delCol[i];
            if(newRow>=0&& newRow<n&& newCol>=0&& newCol<m&& 
            matrix[newRow][newCol]>matrix[row][col])
            max= Math.max(max,1+dfs(newRow,newCol,matrix, res,
            delRow,delCol));
        }
        res[row][col]=max;
        return max;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n= matrix.length;
        int m=matrix[0].length;
        int res[][]= new int[n][m];
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        int maxpath=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxpath= Math.max(maxpath,dfs( i,  j, 
                matrix,res,delRow,delCol));
            }
        }
        return maxpath;
    }
}