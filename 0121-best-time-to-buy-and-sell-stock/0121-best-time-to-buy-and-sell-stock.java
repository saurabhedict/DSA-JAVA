// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int profit = 0;
//         for(int i = 0; i<n; i++){
//             int buy = prices[i];
//             int sell = -1;
//             for(int j = i+1; j<n; j++){
//                 if(prices[j] > buy){
//                     sell = Math.max(sell, prices[j]);
//                 }
//             }
//             if(sell != -1) profit = Math.max(profit, sell-buy);
//         }
//         return profit;
//     }
// } //BF



class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_profit = 0;
        int i = 0, j = i+1;
        while(j<n){
            if(prices[j] > prices[i]){
                int profit = prices[j] - prices[i];
                max_profit = Math.max(profit, max_profit);
                j++;
            }
            else{
                i = j;
                j++;
            }
        }
        return max_profit;
    }
}