class Solution {
    public int maxProfit(int[] prices) {
      int min1=Integer.MAX_VALUE ,min2=Integer.MAX_VALUE ;
      int maxp1=0,maxp2=0;
      for(int i=0;i<prices.length;i++){
        min1=Math.min(min1,prices[i]);
        maxp1 = Math.max(maxp1, prices[i] - min1);
         min2 = Math.min(min2, prices[i] - maxp1);
        maxp2 = Math.max(maxp2, prices[i] - min2);
      }
      return maxp2;
    }
}