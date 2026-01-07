class Solution {
    //  private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[], int safe[]) {
    //     vis[node] = 1; 
    //     pathVis[node] = 1;

    //     for(int it : adj.get(node)) {
    //         if(vis[it] == 0) {
    //             if(dfsCheck(it, adj, vis, pathVis, safe)) {
    //                 return true; // cycle detected
    //             }
    //         } else if(pathVis[it] == 1) {
    //             return true; // cycle detected
    //         }
    //     }

    //     pathVis[node] = 0; // backtrack
    //     safe[node] = 1;    // mark as safe
    //     return false;      // no cycle from this node
    // }

    // public List<Integer> eventualSafeNodes(int[][] graph) {
    //     int V = graph.length;
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    //     for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
    //     for(int i = 0; i < V; i++) {
    //         for(int j : graph[i]) {
    //             adj.get(i).add(j);
    //         }
    //     }

    //     int vis[] = new int[V];
    //     int pathVis[] = new int[V];
    //     int safe[] = new int[V];

    //     for(int i = 0; i < V; i++) {
    //         if(vis[i] == 0) {
    //             dfsCheck(i, adj, vis, pathVis, safe);
    //         }
    //     }

    //     List<Integer> result = new ArrayList<>();
    //     for(int i = 0; i < V; i++) {
    //         if(safe[i] == 1) result.add(i);
    //     }

    //     return result;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>>adj= new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
         int indegree[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int it:graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }
         Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
           if(indegree[i]==0)q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            safeNodes.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)q.add(it);
            }
        }
         Collections.sort(safeNodes);
        return safeNodes;
    }
}