class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean vis[]= new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,isConnected,vis);
            }
        }
        return count;
    }
    public static void dfs(int i,int [][]isConnected,boolean[]vis){
        vis[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 &&!vis[j]){
                dfs(j,isConnected,vis);
            }
        }
    }
}