class Solution {
    class Pair {
        int time,node;
        Pair(int time,int node){
            this.time=time;
            this.node=node;
        }
    }
    public int networkDelayTime(int[][] time,int n,int k){
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<time.length;i++){
            int u=time[i][0],v=time[i][1],t=time[i][2];
            adj.get(u).add(new int[]{v,t});
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new Pair(0,k));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int t=curr.time,node=curr.node;
            for(int[] arr:adj.get(node)){
                int adjNode=arr[0],edTime=arr[1];
                if(t+edTime<dist[adjNode]){
                    dist[adjNode]=t+edTime;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        int maxTime=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            maxTime=Math.max(maxTime,dist[i]);
        }
        return maxTime;
    }
}
