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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds= new DisjointSet(n);
        HashMap<String,Integer>mapMailNode= new HashMap<>();
        for(int i=0;i<n;i++){
         for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(mapMailNode.containsKey(mail)==false){
                    mapMailNode.put(mail,i);
                }
                else{
                    ds.unionBySize(i,mapMailNode.get(mail));
                }
            }
        }
        ArrayList<String>[]mergedMail= new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedMail[i]=new ArrayList<String>();
        }
        for(Map.Entry<String,Integer>it:mapMailNode.entrySet()){
                String mail=it.getKey();
                int node= ds.findUPar(it.getValue());
                mergedMail[node].add(mail);
         }
            List<List<String>>ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(mergedMail[i].size()==0)continue;
                Collections.sort(mergedMail[i]);
                List<String>temp= new ArrayList<>();
                temp.add(accounts.get(i).get(0));
                for(String it:mergedMail[i]){
                    temp.add(it);
                }
                ans.add(temp);
            }
        return ans;
    }
}