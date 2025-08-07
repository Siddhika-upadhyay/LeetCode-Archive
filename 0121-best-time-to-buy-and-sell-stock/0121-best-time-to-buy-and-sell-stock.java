class Solution {
    public int maxProfit(int[] prices) {
    // int minPrice = Integer.MAX_VALUE;
    //     int maxProfit = 0;

    //     // for (int price : prices) {
    //     //     if (price < minPrice) {
    //     //         minPrice = price; 
    //     //     } else {
    //     //         maxProfit = Math.max(maxProfit, price - minPrice); 
    //     //     }
    //     // }
    //     for(int i=0;i<prices.length;i++){
    //         if(prices[i]<minPrice){
    //             minPrice=prices[i];
    //         }
    //         else{
    //             maxProfit=Math.max(maxProfit,prices[i]-minPrice);
    //         }
    //     }

    //     return maxProfit;

 //other way to do it directly:
        int minPrice= prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
            minPrice=Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}