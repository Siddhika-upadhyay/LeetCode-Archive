class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V= numCourses;
        List<List<Integer>>adj= new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
       }

        for(int[]edges: prerequisites){
            int u= edges[0];
            int v=edges[1];
            adj.get(v).add(u);
        }
        int[]indegree= new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                    indegree[it]++;
            }
        }
        Queue<Integer>q= new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0)q.add(i);
        }
        ArrayList<Integer>topo= new ArrayList<>();
        while(!q.isEmpty()){
           int node = q.poll();
           topo.add(node);
           for(int it:adj.get(node)){
            indegree[it]--;
            if(indegree[it]==0)q.add(it);
           }
        }
        if(topo.size()!=V)return false;
        return true;
    }
}