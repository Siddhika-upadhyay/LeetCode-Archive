class Solution {
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