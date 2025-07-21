class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<trust.length;i++){
            int u= trust[i][0];
            int v = trust[i][1];
            adj.get(u).add(v);
        }
        for(int i=1;i<=n;i++){
            if(adj.get(i).isEmpty()){
            int count = 0;
                for (int j = 1; j <= n; j++) {
                    if (j != i && adj.get(j).contains(i)) {
                        count++;
                    }
                }
                if (count == n - 1) return i;
            }
        }
        return -1;
    }
}