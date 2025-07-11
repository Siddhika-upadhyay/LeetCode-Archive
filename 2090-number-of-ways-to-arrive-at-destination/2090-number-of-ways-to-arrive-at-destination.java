class Solution {
    class Pair{
        long time;
        int node;
        Pair(long t,int n){
            this.time=t;
            this.node=n;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int []>>adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
    }
    for (int[] road : roads) {
        int u = road[0];
        int v = road[1];
        int time = road[2];
        adj.get(u).add(new int[]{v, time});
        adj.get(v).add(new int[]{u, time});
    }
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
    long[] dis = new long[n];
    int []ways= new int[n];
    for(int i=0;i<n;i++){
        dis[i]=Long.MAX_VALUE;
        ways[i]=0;
    }
    dis[0]=0;
    ways[0]=1;
    pq.add(new Pair(0,0));
    int mod=(int)1e9+7;
    while(!pq.isEmpty()){
        long time=pq.peek().time;
        int node=pq.peek().node;
        pq.remove();
        for(int[] it: adj.get(node)){
            int adjNode= it[0];
            int edTime= it[1];
            if(time+edTime<dis[adjNode]){
                dis[adjNode]=time+edTime;
                ways[adjNode]=ways[node];
                pq.add(new Pair(time+edTime,adjNode));
            }
            else if(time+edTime==dis[adjNode]){
                ways[adjNode]=(ways[adjNode]+ways[node])%mod;
            }
        }
    }
    return ways[n-1]%mod;
    }
 }