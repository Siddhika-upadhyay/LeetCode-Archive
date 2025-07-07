class Solution {
    public boolean dfs(int node, int[] vis, int[] dfsVis, List<List<Integer>> adj) {
        vis[node] = 1;
        dfsVis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, vis, dfsVis, adj)) return true;
            } else if (dfsVis[it] == 1) {
                return true;
            }
        }
        dfsVis[node] = 0;
        return false;
    }

    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v); 
        }

        int[] vis = new int[V];
        int[] dfsVis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, vis, dfsVis, adj)) {
                    return false; 
                }
            }
        }
        return true; 
            //   int indegree[]=new int[V];
            //   for(int i=0;i<V;i++){
            //       for(int it:adj.get(i)){
            //              indegree[it]++;
            //       }
            //   }
            //   Queue<Integer>q= new LinkedList<Integer>();
            //   for(int i=0;i<V;i++){
            //       if(indegree[i]==0){
            //           q.add(i);
            //       }
            //   }
            //   ArrayList<Integer>topo= new ArrayList<>();
            //   while(!q.isEmpty()){
            //       int node = q.peek();
            //       q.remove();
            //       topo.add(node);
            //       for(int it:adj.get(node)){
            //           indegree[it]--;
            //           if(indegree[it]==0){
            //               q.add(it);
            //           }
            //       }
            //   }
            //   if(topo.size()==V)return true;
            //   return false;
    }
}