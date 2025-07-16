class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node))return node;
        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_v==ulp_u)return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
       DisjointSet ds=new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUPar(i) == i) count++;
        }
        return count;
    }
}

//using dfs

// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n= isConnected.length;
//         boolean vis[]= new boolean[n];
//         int count=0;
//         for(int i=0;i<n;i++){
//             if(!vis[i]){
//                 count++;
//                 dfs(i,isConnected,vis);
//             }
//         }
//         return count;
//     }
//     public static void dfs(int i,int [][]isConnected,boolean[]vis){
//         vis[i]=true;
//         for(int j=0;j<isConnected.length;j++){
//             if(isConnected[i][j]==1 &&!vis[j]){
//                 dfs(j,isConnected,vis);
//             }
//         }
//     }
// }