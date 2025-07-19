class DisjointSet{
    List<Integer>size= new ArrayList<>();
    List<Integer>parent= new ArrayList<>();
    DisjointSet(int n){
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
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DisjointSet ds= new DisjointSet(n);
        for(int []edge: edges){
            int u=edge[0];
            int v=edge[1];
            int pu = ds.findUPar(u);
            int pv = ds.findUPar(v);
            if(pu==pv)return edge;
            else{
                ds.unionBySize(u, v);
            }
        }
      return new int[0];
    }
}