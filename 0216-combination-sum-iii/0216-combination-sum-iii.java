class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
     List<List<Integer>> ans = new ArrayList<>();
     comb(1,k,n,new ArrayList<>(),ans);
     return ans;   
    }
    public void comb(int ind, int k , int n , ArrayList<Integer>arr, List<List<Integer>> ans ){
        if(k==0&&n==0){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(k==0||n<0)return;
        for(int i=ind;i<=9;i++){
            if (i > n) break;
            arr.add(i);
            comb(i+1,k-1,n-i,arr,ans);
            arr.remove(arr.size()-1);
        }
    }
}