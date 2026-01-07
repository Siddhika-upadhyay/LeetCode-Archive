class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
        int V= numCourses;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for( int i=0;i< prerequisites.length;i++){
            int u= prerequisites[i][0];
            int v=  prerequisites[i][1];
            adj.get(v).add(u);
        }
        int []indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer>q= new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> arr= new ArrayList<>();
        while(!q.isEmpty()){
            int num= q.poll();
            arr.add(num);
            for(int it: adj.get(num)){
                indegree[it]--;
                if(indegree[it]==0){
                  q.add(it);
                }
            }
        }
        if(arr.size() != V) return new int[0];

        int[] result = new int[V];
        for(int i = 0; i < V; i++) {
            result[i] = arr.get(i);
        }
        return result;
    }
}