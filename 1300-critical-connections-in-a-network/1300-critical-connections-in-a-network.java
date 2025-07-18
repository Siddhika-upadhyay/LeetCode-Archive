class Solution {
    private int timer=1;
    private void dfs(int node,int parent,int []vis ,ArrayList<ArrayList<Integer>>
        adj,int tim[],int low[],List<List<Integer>>bridge){
            vis[node]=1;
            tim[node]=low[node]=timer;
            timer++;
            for(Integer it: adj.get(node)){
                if(it==parent)continue;
                if(vis[it]==0){
                    dfs(it,node,vis,adj,tim,low,bridge);
                    low[node]=Math.min(low[node],low[it]);
                    if(low[it]>tim[node]){
                        bridge.add(Arrays.asList(it,node));
                    }
                }
                else{
                    low[node]=Math.min(low[node],low[it]);
                }
            }
        }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
       ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
       for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
       }
       for(List<Integer>it : connections){
            int u= it.get(0);
            int v=it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
       }
        int []vis = new int [n];
        int []low = new int [n];
        int []tim = new int [n];
        List<List<Integer>>bridge= new ArrayList<>();
        dfs(0,-1,vis,adj,tim,low,bridge);
        return bridge;
    }

}