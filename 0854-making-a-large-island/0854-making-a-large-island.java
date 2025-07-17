class DisjointSet{
    List<Integer>parent= new ArrayList<>();
    List<Integer>size= new ArrayList<>();
     public DisjointSet(int n){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
     }
     int findUPar(int node){
        if(node==parent.get(node))return node;
        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
     }
     void unionBySize(int u, int v){
            int pu= findUPar(u);
            int pv= findUPar(v);
            if(pu==pv)return ;
            if(size.get(pu)<size.get(pv)){
                parent.set(pu,pv);
                size.set(pv,size.get(pu)+size.get(pv));
            }
            else{
                parent.set(pv,pu);
                size.set(pu,size.get(pv)+size.get(pu));
            }
     }
}
class Solution {
    private boolean isValid(int row, int col ,int n){
        return row>=0 && row<n && col>=0 && col<n ;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds= new DisjointSet(n*n);
        //step 1: connect all ones to the ulp
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0)continue;
                int dr[]={-1,0,1,0};
                int dc[]={0,1,0,-1};
                for(int ind=0;ind<4;ind++){
                    int newr=row+dr[ind];
                    int newc= col+dc[ind];
                    if(isValid(newr,newc,n)&&grid[newr][newc]==1){
                        int nodeNo=row*n+col;
                        int adjNodeNo= newr*n+newc;
                        ds.unionBySize(nodeNo,adjNodeNo);
                    }
                }
            }
        }
        int mx=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1)continue;
                int dr[]={-1,0,1,0};
                int dc[]={0,1,0,-1};
               HashSet<Integer> st = new HashSet<>();
                for(int ind=0;ind<4;ind++){
                    int newr=row+dr[ind];
                    int newc= col+dc[ind];
                    if(isValid(newr,newc,n)&&grid[newr][newc]==1){
                       st.add(ds.findUPar(newr*n+newc));
                    }
                }
            
            int sizeTotal=0;
            for(Integer parent: st){
                sizeTotal+=ds.size.get(parent);
            }
            mx=Math.max(mx,sizeTotal+1);
        }
        }
        //for case is all are one
        for(int cellNo=0;cellNo<n*n;cellNo++){
            mx=Math.max(mx,ds.size.get(ds.findUPar(cellNo)));
        }
        return mx;
    }
}