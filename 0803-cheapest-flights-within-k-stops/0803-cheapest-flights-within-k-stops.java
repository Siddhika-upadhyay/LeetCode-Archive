class Solution {
    class Pair{
        int stops;
        int node;
        int price;
        Pair(int s,int n,int p){
            this.stops=s;
            this.node=n;
            this.price=p;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         ArrayList<ArrayList<int []>> adj= new ArrayList<>();
           for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
         }
         for(int i=0;i<flights.length;i++){
            int s=flights[i][0];
            int d=flights[i][1];
            int p=flights[i][2];
            adj.get(s).add(new int[]{d,p});
         }
         //as moving forward with one stop at each level so no need
         //to take priority queue
         Queue<Pair>q= new LinkedList<>();
         q.add(new Pair(0,src,0));
         int cost[]=new int[n];
         for(int i=0;i<n;i++){
            cost[i]=(int)1e9;
         }
         cost[src]=0;
         while(!q.isEmpty()){
            Pair it=q.peek();
            q.remove();
            int stop= it.stops;
            int node= it.node;
            int price= it.price;
            if(stop>k) continue;
            for(int[] arr: adj.get(node)){
                int adjNode= arr[0];
                int p=arr[1];
                if( price+p < cost[adjNode]&& stop<=k){
                    cost[adjNode]=price+p;
                    q.add(new Pair(stop+1,adjNode,price+p));
                }
            }
         }
         if(cost[dst]==(int)1e9)
         return -1;
         else return cost[dst];
    }
}