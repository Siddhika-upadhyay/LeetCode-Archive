class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int m= isConnected[0].length;
        int vis[]= new int [n];
        int count=0;
        for(int i=0;i<n;i++){
                if(vis[i]==0){
                    count++;
                    dfs(i, vis, isConnected);  
            }
        }
        return count;
    }
    public void dfs( int i, int []vis, int [][]isConnected){
        vis[i]=1;
           for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 &&vis[j]==0){
                dfs(j,vis,isConnected);
            }
        }
    }
}